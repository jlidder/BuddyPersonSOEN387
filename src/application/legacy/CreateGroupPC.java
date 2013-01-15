/*
package application.legacy;

import java.io.IOException; 
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import application.SampleHttpServlet;

import domain.model.group.Group;
import domain.model.group.GroupFactory;
import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.group.mapper.GroupOutputMapper;
import domain.model.invite.Invite;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

public class CreateGroupPC extends SampleHttpServlet{


	public CreateGroupPC()
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

				String groupname = request.getParameter("groupname");
				String groupdesc = request.getParameter("groupdesc");

				//****************************************************************************************
				//this doesn't check if a current group exists with the same name... should we allow this?
				//****************************************************************************************

				long userid = (Long)(request.getSession().getAttribute("userid"));
				Group gr = GroupFactory.createNew(groupname,groupdesc);

				long newgroupid = 0;

				//****************************
				//This call to insert returns an integer from the TDG so gotta figure out how to assign it to a variable
				//AND then after do a set to the user creating this group...
				GroupOutputMapper.insert(gr);   //TODO: FIX THIS


				//System.out.println("NEW GROUP ID:" +gr.getId());

				
				List<Group> gList = GroupInputMapper.findAll();
				for(Group g: gList)
				{
					if(g.getName().equalsIgnoreCase(groupname))
					{
						newgroupid = g.getId();	
						break;
					}
				}

				User ur = (UserInputMapper.find(userid));
				IGroup newG = new GroupProxy(newgroupid);
				ur.setGroup(newG);

				UserOutputMapper.update(ur);
				request.getSession().setAttribute("usergroup", newgroupid);

				
				//Removing any invites that the user may have left
				List<Invite> iList = InviteInputMapper.findAll();
				for(Invite inv: iList)
				{
					if(userid == inv.getUser().getId())
					{
						InviteOutputMapper.delete(inv);
					}
				}
				
				
				//forwards you to a screen saying successfully done!
				//request.getRequestDispatcher("JSP/BrowseGroupsTV.jsp").forward(request, response);
				request.getRequestDispatcher("/BrowseGroups").forward(request, response);
			}
		}
		catch (SQLException e5) 
		{
			String s8 = e5.getMessage();
			String s9 = "\nSQL error comes from the Create Group controller";
			request.setAttribute("ERROR", s8+s9);
		}
		catch (ServletException e1) 
		{
			String s = e1.getMessage();
			String s1 = "\nServletException error comes from the Create Group controller";
			request.setAttribute("ERROR", s+s1);
		} 
		catch (IOException e2)
		{
			String s2 = e2.getMessage();
			String s3 = "\nIO error comes from the Create Group controller";
			request.setAttribute("ERROR", s2+s3);
		} catch (DomainObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MapperException e) {
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
}
*/



