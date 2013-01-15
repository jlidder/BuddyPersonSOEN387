package application.legacy;
/*
package application;

import java.io.IOException;  
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.group.mapper.GroupOutputMapper;
import domain.model.user.User;

/**
 * Servlet implementation class EditGroupReceiverPC
 */
/*
@WebServlet("/EditGroupReceiverPC")
public class EditGroupReceiverPC extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;


	public EditGroupReceiverPC() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		//Clearing the Error attribute
		request.removeAttribute("ERROR");

		try
		{
			//if the user is not logged in then he gets sent back to the login page, else he can view this page
			if(request.getSession().getAttribute("userid") == null)
			{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}	
			else
			{

				int groupID = (Integer)request.getSession().getAttribute("usergroup"); //gets the current users group id

				String gn, gd;
				gn = request.getParameter("groupname");
				gd = request.getParameter("description");
				
				Group grouplist = GroupInputMapper.find(groupID);
				long currentGroupVersion = grouplist.getVersion();	//currentGroupVersion from Database
				long sessionGroupVersion = Integer.parseInt(request.getParameter("groupversionedit")); //sessionGroupVersion from LoginPC

				//DEBUG
				System.out.println(" " + gn + " " + gd);

				if(gn.length() > 0 && gd.length() > 0) 		//if a new name and description was submitted
				{
					if(currentGroupVersion != sessionGroupVersion)
						throw new VersionException("Trying to edit group, but his/her data is out of sync from our system. Refresh page.");
					
					else
					{ 
						Group grUpdate = new Group(groupID, gn, gd, currentGroupVersion); //Increment the version by 1
						//debug
						System.out.println("Works here 1");
						GroupOutputMapper.update(grUpdate);
						DbRegistry.closeDbConnectionIfNeeded();
						request.getRequestDispatcher("/ViewCurrentGroup").forward(request, response);
					}
				}
				else
				{
					if(gn.length() == 0 && gd.length() > 0)
					{		//if no new description was submitted, but a name was	
						if(currentGroupVersion != sessionGroupVersion)
							throw new VersionException("Trying to edit group, but his/her data is out of sync from our system. Refresh page.");
		
						else
						{ 
							String gname = grouplist.getName();
							Group grUpdate = new Group(groupID, gname, gd, currentGroupVersion);
							//debug
							System.out.println("Works here 2");
							GroupOutputMapper.update(grUpdate);
							DbRegistry.closeDbConnectionIfNeeded();
							request.getRequestDispatcher("/ViewCurrentGroup").forward(request, response);
						}
					}
					else
					{
						if(gn.length() > 0 && gd.length() == 0){		//if no new name was submitted, but a description was
							//need to get the session version to compare it to the currentVersion
							if(currentGroupVersion != sessionGroupVersion)
								throw new VersionException("Trying to edit group, but his/her data is out of sync from our system. Refresh page.");
							
							else
							{ 
								String gdesc = grouplist.getDescription();
							
								Group grUpdate = new Group(groupID, gn, gdesc, currentGroupVersion);
								//debug
								System.out.println("Works here 3");
								GroupOutputMapper.update(grUpdate);
								DbRegistry.closeDbConnectionIfNeeded();
								request.getRequestDispatcher("/ViewCurrentGroup").forward(request, response);
							}
						}
						else
						{
							if(gn.length() == 0 && gd.length() == 0)
							{
								request.getRequestDispatcher("/EditGroup").forward(request, response);
							}
						}
					}
				}
			}
		}
		
		catch (VersionException ve)
		{
			String s = ve.getString();
			request.setAttribute("ERROR", s);
		}
		
		catch (SQLException e1) 
		{

			String s = e1.getMessage();
			String s1 = "\nSQL error comes from the Edit Group receiver controller";
			request.setAttribute("ERROR", s+s1);
		} 
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the Edit Group receiver controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the Edit Group receiver controller first inner catch block";
			request.setAttribute("ERROR", s4+s5);
		} catch (DomainObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(request.getAttribute("ERROR") != null)
			{
				try 
				{
					request.getRequestDispatcher("JSP/Errors.jsp").forward(request, response);
				}
				catch (ServletException e4) 
				{
					// Going to end it here by printing this stack trace or we'll have cyclic exception handling
					e4.printStackTrace();
				} 
				catch (IOException e5)
				{
					// Going to end it here by printing this stack trace or we'll have cyclic exception handling
					e5.printStackTrace();
				}
			}
		} //END OF FINALLY
	}
}
*/