package application.legacy;
/*
package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.group.Group;
import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.invite.Invite;
import domain.model.invite.InviteFactory;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.user.IUser;
import domain.model.user.User;
import domain.model.user.UserProxy;
import domain.model.user.mapper.UserInputMapper;


public class InviteUserPC extends SampleHttpServlet 
{
	private static final long serialVersionUID = -4499475665559881540L;

	public InviteUserPC() 
	{
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{				
				// query parameters
				String uid = request.getParameter("userId");
				String gid = request.getParameter("groupId");
		
				// information about the inviting user and his/her group				
				long invitingUserId = (Long)(request.getSession().getAttribute("userid"));
				long invitingGroupId = 0;
				try 
				{
					invitingGroupId = UserInputMapper.find(invitingUserId).getGroup().getId();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				int userversionForInvitation = Integer.parseInt(request.getParameter("userversionForInvitation"));
				
				// a User has been invited
				User invitedUser = UserInputMapper.find( Long.parseLong(uid) );
				
				if(invitedUser.getVersion() != userversionForInvitation) //VERSION CHECK.
					throw new VersionException("");
				
				Group group = GroupInputMapper.find( Integer.parseInt(gid) );
		
				// create the invite
				IUser invU = new UserProxy(invitedUser.getId());
				IGroup invG = new GroupProxy(group.getId());
				Invite invite = null;
				try 
				{
					invite = InviteFactory.createNew(invU,invG );
				} 
				catch (MapperException e) 
				{
					e.printStackTrace();
				}
				InviteOutputMapper.insert(invite);
		
				String title = "Invite Users to Your Group";
				String msg = "The user " + invitedUser.getFirstName() + " " + invitedUser.getLastName() + ", has been invited to the group: " + group.getName();
		
		
				List<User> uList = UserInputMapper.findAll();	
				List<User> filteredUList = new ArrayList<User>();
		
				// get a list of invites
				List<Invite> inviteList = InviteInputMapper.findAll();
				List<Long> invitedUsers = new ArrayList<Long>();
		
				// filter the users that have already been invited to the group
				for(Invite inv: inviteList)
				{
					if(inv.getGroup().getId() == invitingGroupId)
					{
						invitedUsers.add( inv.getUser().getId() );
					}
				}
		
				// filter the list to remove users that are already in a group
				for(User u: uList)
				{
					if( u.getGroup().getId() == 0 )
					{
						filteredUList.add(u);
					}
				}
		
				request.setAttribute("users", filteredUList);
				request.setAttribute("title", title);
				request.setAttribute("msg", msg);
				request.setAttribute("invitedList", invitedUsers);
				request.setAttribute("groupId", invitingGroupId);  // TODO: make sure this comes from the inviting user!
		
				DbRegistry.closeDbConnectionIfNeeded();
				request.getRequestDispatcher("JSP/InviteUserTV.jsp").forward(request, response);
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
			String s1 = "\nSQL error comes from the invite user controller";
			request.setAttribute("ERROR", s+s1);
		} 
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the invite user controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the invite user controller first inner catch block";
			request.setAttribute("ERROR", s4+s5);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			//IF the user is not assigned to a group, send him to the Browse Groups page
			else if(((Integer)(request.getSession().getAttribute("usergroup"))) == 0)
			{
				request.getRequestDispatcher("/BrowseGroups").forward(request, response); //TODO: Make this View Current Group later
			}
			else
			{

				// information about the inviting user and his/her group				
				long invitingUserId = (Long)(request.getSession().getAttribute("userid"));
				long invitingGroupId = 0;
				invitingGroupId = UserInputMapper.find(invitingUserId).getGroup().getId();
				if(invitingGroupId == 0)
					request.getRequestDispatcher("/BrowseGroups").forward(request, response);

					// browsing the users available to invite
					List<User> uList = UserInputMapper.findAll();	
					List<User> filteredUList = new ArrayList<User>();

					// get a list of invites
					List<Invite> inviteList = InviteInputMapper.findAll();
					List<Long> invitedUsers = new ArrayList<Long>();

					// filter the users that have already been invited to the group
					for(Invite inv: inviteList)
					{
						if(inv.getGroup().getId() == invitingGroupId)
						{
							invitedUsers.add( inv.getUser().getId() );
						}
					}

					// filter the list to remove users that are already in a group
					for(User u: uList)
					{
						if( u.getGroup().getId() == 0 )
						{
							filteredUList.add(u);
						}
					}

					String title = "Invite Users to Your Group";

					request.setAttribute("users", filteredUList);
					request.setAttribute("title", title);
					request.setAttribute("groupId", invitingGroupId); 
					request.setAttribute("invitedList", invitedUsers);

					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("JSP/InviteUserTV.jsp").forward(request, response);	
				}
		}
		
		catch (SQLException e1) 
		{

			String s = e1.getMessage();
			String s1 = "\nSQL error comes from the invite user controller";
			request.setAttribute("ERROR", s+s1);
		} 
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the invite user controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the invite user controller first inner catch block";
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
	} //END of processRequest
}
*/