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
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

/**
 * Servlet implementation class RemoveMemberPC
 */
/*
@WebServlet("/RemoveMemberPC")
public class RemoveMemberPC extends SampleHttpServlet 
{
	private static final long serialVersionUID = 1L;

	public RemoveMemberPC() {
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
			//IF the user is not assigned to a group, send him to the Browse Groups page
			else if(((Integer)(request.getSession().getAttribute("usergroup"))) == 0)
			{
				request.getRequestDispatcher("/BrowseGroups").forward(request, response); //TODO: Make this View Current Group later
			}
			/*
			int myGroupId = (Integer)request.getSession().getAttribute("usergroup"); //gets the current users group id

			if (myGroupId == 0){
				request.getRequestDispatcher("/BrowseGroups").forward(request, response);
			} */
/*
			else
			{
				//get userId & Version from RemoveMemberTV
				String parameterId = request.getParameter("userId");
				String parameterVersion = request.getParameter("version");

				//No member is removed yet, just display RemoveMemberTV
				if(parameterId == null)
				{
					List<User> uList = UserInputMapper.findAll();	
					List<Group> gList = GroupInputMapper.findAll();
					String title = "Remove a Member";

					request.setAttribute("users", uList);
					request.setAttribute("groups", gList);
					request.setAttribute("title", title);

					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("JSP/RemoveMemberTV.jsp").forward(request, response);
				}

				else
				{

					//checking to see if this removed member is the only member in the group. If so, deleting the group too
					List<User> userList = UserInputMapper.findAll();
					int numOfMembers = 0;
					int grptest = (Integer) request.getSession().getAttribute("usergroup");
					for(User usr: userList)
					{
						if(usr.getGroupId() == grptest)
						{
							numOfMembers++;
						}
					}
					System.out.println("Number of members:" +numOfMembers);

					int selectedId = Integer.parseInt(parameterId);
					int selectedVersion = Integer.parseInt(parameterVersion);

					for(User usr: userList)
					{

						if(usr.getId() == selectedId)//compare userId's
						{ 
							if(usr.getVersion() != selectedVersion)
							{
								throw new VersionException("Trying to remove a group member but his/her data is out of sync from our system. Refresh page.");
							}
							long oldGroupId = usr.getGroupId(); //incase update fails due to bad version

							usr.setGroupId(0); //set user groupId to zero
							//Update the removed User
							User removedUser = new User(usr.getId(), usr.getGroupId(), usr.getFirstName(), usr.getLastName(),usr.getUserName(),usr.getPassword(), usr.isAdmin(), usr.getVersion());
							System.out.println("This info of User will got to DB "+usr.getId()+" | "+ usr.getGroupId()+" | "+ usr.getFirstName()+" | "+usr.getLastName()+" | "+usr.getUserName()+" | "+usr.getPassword()+" | "+ usr.isAdmin());
							int returnedrows = UserOutputMapper.update(removedUser);

							if(returnedrows < 1)
							{
								usr.setGroupId(oldGroupId);
								throw new VersionException("Trying to remove a group member but his/her data is out of sync from our system. Refresh page.");
							}

						}

					}//end of for loop

					//If the member being removed was the only member in the group,  deleting the group
					if(numOfMembers == 1)
					{
						Group gDelete = GroupInputMapper.find(grptest);
						GroupOutputMapper.delete(gDelete);
					}

					//If the member being removed is himself, then must set the usergroup session attrib to 0;
					int selfid = (Integer)request.getSession().getAttribute("userid");
					if(selectedId == selfid)
					{
						request.getSession().removeAttribute("usergroup");
						request.getSession().setAttribute("usergroup", 0);
					}


					List<User> uList = UserInputMapper.findAll();	
					List<Group> gList = GroupInputMapper.findAll();
					String title = "Remove a Member";

					request.setAttribute("users", uList);
					request.setAttribute("groups", gList);
					request.setAttribute("title", title);

					DbRegistry.closeDbConnectionIfNeeded();
					request.getRequestDispatcher("JSP/RemoveMemberTV.jsp").forward(request, response);	
				} 


			}
		}
		catch (VersionException ve1)
		{
			String s = ve1.getString();
			request.setAttribute("ERROR", s);
		}
		catch (SQLException e1) 
		{

			String s = e1.getMessage();
			String s1 = "\nSQL error comes from the remove member controller";
			e1.printStackTrace();
			request.setAttribute("ERROR", s+s1);
		} 
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the remove member controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the remove member controller first inner catch block";
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