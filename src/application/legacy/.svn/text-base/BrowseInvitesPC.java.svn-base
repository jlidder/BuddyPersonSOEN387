package application.legacy;
/*
package application;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.invite.Invite;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class BrowseInvitesPC extends SampleHttpServlet 
{
	private static final long serialVersionUID = 8734948275795581347L;

	public BrowseInvitesPC() 
	{
		super();
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
			//IF the user is already assigned to a group, send him to the Browse Groups page
			else if(((Integer)(request.getSession().getAttribute("usergroup"))) > 0)
			{
				request.getRequestDispatcher("/BrowseGroups").forward(request, response); //TODO: Make this View Current Group later
			}
			else
			{
				List<Invite> fullList = InviteInputMapper.findAll();			
				List<User> uList = UserInputMapper.findAll();	
				
				String title = "Browse Invites";

				Integer userid = (Integer)(request.getSession().getAttribute("userid"));

				List<Invite> iList = new ArrayList<Invite>();
				for(Invite inv: fullList)
				{
					if(inv.getUserId() == userid)
						iList.add(inv);
				}


				request.setAttribute("invites", iList);
				request.setAttribute("title", title);
				request.setAttribute("users", uList);

				//request.setAttribute("browseAccept",  );
				//request.setAttribute("browseDecline", );
				DbRegistry.closeDbConnectionIfNeeded();
				request.getRequestDispatcher("JSP/BrowseInvitesTV.jsp").forward(request, response);	
			}
		}
		catch (SQLException e5) 
		{

			String s8 = e5.getMessage();
			String s9 = "\nSQL error comes from the BrowseInvites controller";
			request.setAttribute("ERROR", s8+s9);
		} 
		catch (ServletException e6) //FIRST INNER CATCH BLOCK
		{
			String s10 = e6.getMessage();
			String s11 = "\nServletException error comes from the BrowseInvites controller";
			request.setAttribute("ERROR", s10+s11);
		}
		catch (IOException e7) //FIRST INNER CATCH BLOCK
		{
			String s12 = e7.getMessage();
			String s13 = "\nIO error comes from the BrowseInvites controller";
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


	} //END of process Request
} 
*/
