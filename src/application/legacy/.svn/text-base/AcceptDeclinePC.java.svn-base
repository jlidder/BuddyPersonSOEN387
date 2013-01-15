package application.legacy;
/*
package application;


import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.invite.Invite;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

public class AcceptDeclinePC extends SampleHttpServlet {


	public AcceptDeclinePC() 
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
				String s1 = "\nServletException error comes from the Accept\\Decline controller";
				request.setAttribute("ERROR", s+s1);
			} 
			catch (IOException e2)
			{
				String s2 = e2.getMessage();
				String s3 = "\nIO error comes from the Accept\\Decline controller";
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
				String accept = request.getParameter("accepted");
				int groupid = Integer.parseInt(request.getParameter("groupid"));
				int inviteversion = Integer.parseInt(request.getParameter("inviteversion"));

				//ACCEPT THE GROUP
				if(accept.equalsIgnoreCase("true"))
				{
					User user = UserInputMapper.find((Long)(request.getSession().getAttribute("userid")));
					
					//Setting the session group variable so that the menu shows accordingly
					request.getSession().setAttribute("usergroup", groupid);

					List<Invite> fullList = InviteInputMapper.findAll();	

					for(Invite inv: fullList)
					{
						if(inv.getUserId() == user.getId())
						{
							if(inviteversion != inv.getVersion()) //VERSION CHECKING. CHECK IF INVITATIONS THAT ARE BEING ADJUSTED OR OF RIGHT VERSIONS
								throw new VersionException("Trying to accept/reject a invitation, but his/her data is out of sync from our system. Refresh page.");
							
							InviteOutputMapper.delete(inv);
							user.setGroupId(groupid);
							System.out.println("NEW GROUP:"+user.getGroupId());
							UserOutputMapper.update(user);
						}
					}
					
					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("/BrowseGroups").forward(request, response); //TODO: make this a confirmation page
				}
				else if(accept.equalsIgnoreCase("false"))
				{
					User user = UserInputMapper.find((Long)(request.getSession().getAttribute("userid")));
					//InviteOutputMapper.delete(InviteInputMapper.find(user.getId(), groupid));	
					InviteOutputMapper.delete(InviteInputMapper.find(user.getId()));   //This doesnt find the groupID...
					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("/BrowseInvites").forward(request, response);
				}
				else
				{
					//Dead meat
					System.out.println("There was an Error with the ACCEPT GROUP portion of the AcceptDecline controller");
				}
			}
			catch(VersionException ve)
			{
				String s = ve.getString();
				request.setAttribute("ERROR", s);
			}
			
			catch (SQLException e5) 
			{
				String s8 = e5.getMessage();
				String s9 = "\nSQL error comes from the Accept\\Decline controller";
				request.setAttribute("ERROR", s8+s9);
			} 
			catch (ServletException e6) //FIRST INNER CATCH BLOCK
			{
				String s10 = e6.getMessage();
				String s11 = "\nServletException error comes from the Accept\\Decline controller first inner catch block";
				request.setAttribute("ERROR", s10+s11);
			}
			catch (IOException e7) //FIRST INNER CATCH BLOCK
			{
				String s12 = e7.getMessage();
				String s13 = "\nIO error comes from the Accept\\Decline controller first inner catch block";
				request.setAttribute("ERROR", s12+s13);
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

		} //END of processRequest
	}
}
*/