package application.legacy;
/*
package application;

import java.io.IOException;     
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;



@WebServlet("/ViewCurrentGroupPC")
public class ViewCurrentGroupPC extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCurrentGroupPC() {
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
				List<User> uList = UserInputMapper.findAll();	
				List<Group> gList = GroupInputMapper.findAll();
				String title = "View Your Current Group";

				request.setAttribute("users", uList);
				request.setAttribute("groups", gList);
				request.setAttribute("title", title);

				DbRegistry.closeDbConnectionIfNeeded();
				request.getRequestDispatcher("JSP/ViewCurrentGroupTV.jsp").forward(request, response);	
			}

		}
		catch (SQLException e1) 
		{

			String s = e1.getMessage();
			String s1 = "\nSQL error comes from the view current Group controller";
			request.setAttribute("ERROR", s+s1);
		} 
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the view current Group controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the view current Group controller first inner catch block";
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
*/