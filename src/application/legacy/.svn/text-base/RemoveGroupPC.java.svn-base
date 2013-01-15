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
import domain.model.invite.Invite;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

/**
 * Servlet implementation class RemoveGroupPC
 */
/*
@WebServlet("/RemoveGroupPC")
public class RemoveGroupPC extends SampleHttpServlet 
{
	private static final long serialVersionUID = 1L;

	public RemoveGroupPC() 
	{
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

			if ((Integer)request.getSession().getAttribute("usergroup") == 0)
			{
				request.getRequestDispatcher("/BrowseGroups").forward(request, response);
			}
			
			else
			{
				String parameterId = request.getParameter("clicked");
				if(parameterId == null)
				{
					List<User> uList = UserInputMapper.findAll();	
					List<Group> gList = GroupInputMapper.findAll();
					String title = "Remove Your Current Group";

					request.setAttribute("users", uList);
					request.setAttribute("groups", gList);
					request.setAttribute("title", title);
					
					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("JSP/RemoveGroupTV.jsp").forward(request, response);	
				}
				else
				{
					List<User> userList = UserInputMapper.findAll();
					int myGroupId = (Integer)request.getSession().getAttribute("usergroup"); //gets the current users group id
					
					int myGroupVersion = Integer.parseInt(request.getParameter("groupversiondeleted"));
					long properGroupVersionInDB = GroupInputMapper.find(myGroupId).getVersion();
					
					if(myGroupVersion != properGroupVersionInDB)
						throw new VersionException("Trying to remove group, but his/her data is out of sync from our system. Refresh page.");
					
					for(User u: userList)
					{
						long userGroupId = (Long)u.getGroupId(); // get the user groupId from the list
						myGroupId = (Integer)request.getSession().getAttribute("usergroup"); // this user groupId
						
						if(userGroupId == myGroupId)
						{ // compare groupIds 
							u.setGroupId(0); //set user groupId to zero
							User updatedUser = new User(u.getId(), u.getGroupId(), u.getFirstName(), u.getLastName(),u.getUserName(),u.getPassword(), u.isAdmin(), u.getVersion());    							
							UserOutputMapper.update(updatedUser);
						}
					}

					Group updatedGroup = GroupInputMapper.find(myGroupId);
					System.out.println("Group TEST: "+updatedGroup.getVersion());
					System.out.println("My Updated Group: "+updatedGroup);
					
					
					
					//Removing invites associated to the group being deleted
					List<Invite> iList = InviteInputMapper.findAll();
					for(Invite inv: iList)
					{
						if(inv.getGroup().getId() == updatedGroup.getId())
						{
							InviteOutputMapper.delete(inv);
						}
					}
					
					
					
					GroupOutputMapper.delete(updatedGroup);// delete this group

					System.out.println("My GroupId: "+myGroupId);

					//set the session to Zero
					request.getSession().removeAttribute("usergroup");
					request.getSession().setAttribute("usergroup", 0);
					parameterId = null;
					//------------------------
					List<User> uList = UserInputMapper.findAll();	
					List<Group> gList = GroupInputMapper.findAll();
					String title = "Remove Your Current Group";

					request.setAttribute("users", uList);
					request.setAttribute("groups", gList);
					request.setAttribute("title", title);

					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("/BrowseGroups").forward(request, response);	
				}
			}
		}
		
		catch (VersionException ve)
		{
			
		}
		
		catch (SQLException e1) 
		{

			String s = e1.getMessage();
			String s1 = "\nSQL error comes from the remove Group controller";
			request.setAttribute("ERROR", s+s1);
		} 
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the remove Group controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the remove Group controller first inner catch block";
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