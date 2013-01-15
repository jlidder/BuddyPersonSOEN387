package application.legacy;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.SampleHttpServlet;

import domain.model.user.User;

public class LogoutPC extends SampleHttpServlet{

	public LogoutPC() {

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		//Clearing the Error attribute
		request.removeAttribute("ERROR");

		request.getSession().invalidate();

		try
		{
			request.getRequestDispatcher("JSP/logout.jsp").forward(request, response);
		}
		catch (ServletException e2) //FIRST INNER CATCH BLOCK
		{
			String s2 = e2.getMessage();
			String s3 = "\nServletException error comes from the log out controller first inner catch block";
			request.setAttribute("ERROR", s2+s3);
		}
		catch (IOException e3) //FIRST INNER CATCH BLOCK
		{
			String s4 = e3.getMessage();
			String s5 = "\nIO error comes from the log out controller first inner catch block";
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
