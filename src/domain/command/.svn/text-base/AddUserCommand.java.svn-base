package domain.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.role.IRole;
import org.dsrg.soenea.uow.UoW;

import domain.JavaMD5Hashing;
import domain.model.group.Group;
import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.invite.IInvite;
import domain.model.person.IPerson;
import domain.model.person.Person;
import domain.model.person.PersonFactory;
import domain.model.person.data.PersonTDG;
import domain.model.person.mapper.PersonOutputMapper;
import domain.model.requestInvite.IRequestInvite;
import domain.model.role.StudentRole;
import domain.model.user.IUser;
import domain.model.user.User;
import domain.model.user.UserFactory;
import domain.model.user.data.UserTDG;
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

public class AddUserCommand extends Command
{
	private HttpServletRequest request = null;
	private boolean POST = false;
	
	public AddUserCommand(Helper helper, HttpServletRequest request, boolean POST) 
	{
		super(helper);
		// TODO Auto-generated constructor stub
		this.request = request;
		this.POST = POST;
	}

	@Override
	public void setUp() throws CommandException 
	{
		// TODO Auto-generated method stub
	}

	/*
	 * Some code of this method was used from stackoverflow
	 * http://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
	 * (non-Javadoc)
	 * @see org.dsrg.soenea.domain.command.DomainCommand#process()
	 */
	@Override
	public void process() throws CommandException 
	{
		try
		{
			if(POST == true)
			{
				 try 
				   {
					   //Check that we have a file upload request
					   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
					   
					   if(isMultipart)
					   {
						    // Create a new file upload handler
				            ServletFileUpload upload = new ServletFileUpload();
						   
						   FileItemIterator iter = upload.getItemIterator(request);  
						   FileItemStream itemer;  
						   InputStream stream;  
						      
						   while (iter.hasNext()) 
						   {  
						       itemer = iter.next();  
						       stream = itemer.openStream();  
						       String temp = convertStreamToString(stream);
						       
				               String newUserEntriesPerLine[] = temp.split("(?<=[ \\n])");
				                
				                for (String saa : newUserEntriesPerLine )
				                {
				                    System.out.println("Data Line from CSV: " + saa + "");
				                }
				                
				                //now parse each sentence and create new objects based on that.
				                for(String newPerson : newUserEntriesPerLine)
				                {
				                	//each sentence is formatted in this fashion in the CSV file: sthiel,1234,Stuart,Thiel    (username,password,firstname,lastname)
				                	String personsInformation[] = newPerson.split(",");
				                	
				                	for(String temper : personsInformation)
				                	{
				                		System.out.println("======>>>>"+temper);
				                	}
				                	
				                	User user=null;
				                	IRole studRole = new StudentRole();
				                	List<IRole> roles = new ArrayList<IRole>();
				                	List<IInvite> inviteList = new ArrayList<IInvite>();
				                	List<IRequestInvite> requestinviteList = new ArrayList<IRequestInvite>();
				                	roles.add(studRole);

				                	// use factory
				                	Person person = PersonFactory.createNew(
				                								 (PersonTDG.getMaxID() + 1),
				                								 personsInformation[0], 
				                								 JavaMD5Hashing.produceMD5Hash(personsInformation[1]), 
				                								 roles, 
				                								 user); //(long id, long version, String username, String password, List<IRole> roles, IUser user)

				                	List<IUser> userList = new ArrayList<IUser>();

				                	userList.add(user);
				                	IGroup group = new GroupProxy((long) 0); //new Group(0,1,"","",userList,requestinviteList);//(long id, long version, String name, String desc, List<IUser> userList, List<IRequestInvite> requestList)

				                	// use factory
				                	user = UserFactory.createNew(
				                					 (UserTDG.getMaxID()+1),
				                			         group,
				                			         personsInformation[2],
				                			         personsInformation[3],
				                			         person); //(long id, long version, IGroup group, String fn, String ln, IPerson per, List<IInvite> inviteList)
				                	
				                	try
				                	{
				                		PersonOutputMapper pom = new PersonOutputMapper();
				                		UserOutputMapper uom = new UserOutputMapper();
				                		
				                		pom.insert(person);
				                		uom.insert(user);
				                		
				                		UoW.getCurrent().registerNew(person);
				                		UoW.getCurrent().registerNew(user);
				                		
				                		UoW.getCurrent().commit();
				                	}
				                	
				                	catch(Exception d)
				                	{
				                		System.out.println("EXCEPTION FROM INSERT()" + d.getMessage());
				                	}
				                }
				            }
						} 
					}//end of try block
				    
				 
				    catch (Exception e) 
				    {
				        throw new ServletException("Cannot parse multipart request.", e);
				    } 
			}//end of IF POST block 
			
			else
			{
				//do nothing if its a GET request command execution.
			}
		}
		
		catch(Exception d)
		{
			
		}
	}
	
	/*
	 * Got this method from stackoverflow.
	 * http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
	 */
	public static String convertStreamToString(java.io.InputStream is) 
	{
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}

	@Override
	public void tearDown() throws CommandError 
	{
		// TODO Auto-generated method stub
		
	}	
}
