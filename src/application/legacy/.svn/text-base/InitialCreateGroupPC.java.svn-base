package application.legacy;

import java.io.IOException; 
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.SampleHttpServlet;

import domain.model.group.Group;
import domain.model.invite.Invite;


//THIS class is a helper class to the CreateGroupPC
public class InitialCreateGroupPC extends SampleHttpServlet
{


	public InitialCreateGroupPC()
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
				request.getRequestDispatcher("JSP/CreateGroupTV.jsp").forward(request, response);
			}
		}
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the Initial create Group controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the Initial create Group controller first inner catch block";
			request.setAttribute("ERROR", s4+s5);
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