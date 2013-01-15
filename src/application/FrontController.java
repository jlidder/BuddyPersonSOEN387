package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.application.servlet.dispatcher.HttpServletHelper;
import org.dsrg.soenea.service.MySQLConnectionFactory;
import org.dsrg.soenea.service.registry.Registry;
import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.dsrg.soenea.service.threadLocal.ThreadLocalTracker;
import org.dsrg.soenea.uow.MapperFactory;
import org.dsrg.soenea.uow.UoW;

import domain.model.group.Group;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupOutputMapper;
import domain.model.invite.Invite;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.person.Person;
import domain.model.person.mapper.PersonOutputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserOutputMapper;



public class FrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_DISPATCHER = "application.dispatcher.LoginDispatcher";
	
	public void init() throws ServletException 
	{
		super.init();
		prepareDbRegistry("");
	}
	
	public static void prepareDbRegistry(String db_id) 
	{
		MySQLConnectionFactory f = new MySQLConnectionFactory(null, null, null, null);
		try {
			f.defaultInitialization(db_id);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		DbRegistry.setConFactory(db_id, f);
		String tablePrefix;
		try {
			tablePrefix = Registry.getProperty(db_id+"mySqlTablePrefix");
		} catch (Exception e1) {
			e1.printStackTrace();
			tablePrefix = "";
		}
		if(tablePrefix == null) {
			tablePrefix = "";
		}
		DbRegistry.setTablePrefix(db_id, tablePrefix);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		preProcessRequest(request, response);
		try {
			processRequest(request, response);
		} finally {
			postProcessRequest(request, response);
		}
	}
	
	protected void preProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		try
		{
			// START TRANSACTION.
			DbRegistry.getDbConnection().createStatement().execute("START TRANSACTION;");
			
			// prep UoW
			UoW.newCurrent();
			MapperFactory mFac = new MapperFactory();
			
			// add mapping to the factory (for each Input/Output Mapper)
			 mFac.addMapping(Group.class, GroupOutputMapper.class);
			 mFac.addMapping(User.class, UserOutputMapper.class);
			 mFac.addMapping(Invite.class, InviteOutputMapper.class);
			 mFac.addMapping(Person.class, PersonOutputMapper.class);
			 
			UoW.initMapperFactory(mFac);
		}
		
		catch (Exception e)
		{
			
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().setMaxInactiveInterval(300);
		
		//DEBUG
		System.out.println("Printing the request URL: " + request.getRequestURL());
		
		//check if logged in.
		if(request.getSession().getAttribute("userid")==null)
		{
			request.setAttribute("dispatcher", DEFAULT_DISPATCHER);
		}
		
		Dispatcher disp = getDispatcher(request);
		
		if(disp != null) 
		{
			disp.init(request, response);
			disp.execute();
		}
		
	}
	
	private Dispatcher getDispatcher(HttpServletRequest request) 
	{
		try 
		{
			String dispatcher = request.getParameter("dispatcher");
			
			if(dispatcher == null || dispatcher.isEmpty()) 
			{
				dispatcher = DEFAULT_DISPATCHER;
			}
			return (Dispatcher) Class.forName(dispatcher).newInstance();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	protected void postProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			//UoW.getCurrent().commit();
			DbRegistry.getDbConnection().createStatement().execute("COMMIT;");
			DbRegistry.closeDbConnectionIfNeeded();
		} 
		catch (Exception e) {}
		
		ThreadLocalTracker.purgeThreadLocal();
	}
	
	/**
	 * ======>>>>CODE USED/BASED FROM SOEN387 TUTORIAL. Author of this code is Dr.Chalin i think?
	 * 
	 * Attempt to extract the command from the request's pathInfo. Note that
	 * this method might set request attributes.
	 * 
	 * @param request
	 * @return null or the command as a simple class name (i.e. not fully
	 *         qualified with the package).
	 */
	private String getDispatcherFromPathInfoAndMaybeSetSomeAttributes(HttpServletRequest request) 
	{
		String path = request.getPathInfo();
		// System.out.println("path = " + path);
		if (path == null)
			return null;

		String dispatcher = null;
		if ("/browse".equals(path)) 
		{
			dispatcher = "BrowsePeople";
		} 
		
		else 
		{
			Pattern pattern = Pattern.compile("^/(view|inc)/(\\d+)$");
			Matcher matcher = pattern.matcher(path);
			if (matcher.find()) 
			{
				String id = null;
				dispatcher = "view".equals(matcher.group(1)) ? "ViewPerson" : "IncreaseAge";
				id = matcher.group(2);
				request.setAttribute("id", id);
			}
		}
		// System.out.println("command = " + command);
		return dispatcher;
	}
}
