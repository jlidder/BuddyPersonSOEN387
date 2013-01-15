package application.legacy;
/*
package application;

import java.io.IOException;  
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.invite.Invite;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class BrowseGroupsPC extends SampleHttpServlet 
{
	private static final long serialVersionUID = -8307204158598192000L;

	public BrowseGroupsPC()
	{
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		//Clearing the Error attribute
		request.removeAttribute("ERROR");
		
		//if the user is not logged in then he gets sent back to the login page, else he can view this page
		if(request.getSession().getAttribute("userid") == null)
		{
			try 
			{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} 
			catch (ServletException e1) 
			{
				String s = e1.getMessage();
				String s1 = "\nServletException error comes from the BrowseGroups controller";
				request.setAttribute("ERROR", s+s1);
			} 
			catch (IOException e2)
			{
				String s2 = e2.getMessage();
				String s3 = "\nIO error comes from the BrowseGroups controller";
				request.setAttribute("ERROR", s2+s3);
			}
			finally
			{
				if(request.getAttribute("ERROR") != null)
				{
					try 
					{
						request.getRequestDispatcher("JSP/Errors.jsp").forward(request, response);
					}
					catch (ServletException e3) 
					{
						// Going to end it here by printing this stack trace or we'll have cyclic exception handling
						e3.printStackTrace();
					} 
					catch (IOException e4)
					{
						// Going to end it here by printing this stack trace or we'll have cyclic exception handling
						e4.printStackTrace();
					}
				}
			} // END OF FINALLY BLOCK
		}		
		else
		{
			try 
			{
				List<Group> gList = GroupInputMapper.findAll();		
				List<User> uList = UserInputMapper.findAll();
				String title = "Browse Groups";

				request.setAttribute("groups", gList);
				request.setAttribute("users", uList);
				request.setAttribute("title", title);
				
				DbRegistry.closeDbConnectionIfNeeded();
				request.getRequestDispatcher("JSP/BrowseGroupsTV.jsp").forward(request, response);	
			}
			catch (SQLException e5) 
			{

				String s8 = e5.getMessage();
				String s9 = "\nSQL error comes from the BrowseGroups controller";
				request.setAttribute("ERROR", s8+s9);
			} 
			catch (ServletException e6) //FIRST INNER CATCH BLOCK
			{
				String s10 = e6.getMessage();
				String s11 = "\nServletException error comes from the BrowseGroups controller first inner catch block";
				request.setAttribute("ERROR", s10+s11);
			}
			catch (IOException e7) //FIRST INNER CATCH BLOCK
			{
				String s12 = e7.getMessage();
				String s13 = "\nIO error comes from the BrowseGroups controller first inner catch block";
				request.setAttribute("ERROR", s12+s13);
			} 
			finally
			{
				if(request.getAttribute("ERROR") != null)
				{
					try 
					{
						request.getRequestDispatcher("JSP/Errors.jsp").forward(request, response);
					}
					catch (ServletException e8) 
					{
						// Going to end it here by printing this stack trace or we'll have cyclic exception handling
						e8.printStackTrace();
					} 
					catch (IOException e9)
					{
						// Going to end it here by printing this stack trace or we'll have cyclic exception handling
						e9.printStackTrace();
					}
				}
			} //END OF FINALLY
		} // end of ELSE
	} //end of processRequest
}
*/