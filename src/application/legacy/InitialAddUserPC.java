package application.legacy;
import java.io.*;  
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.SampleHttpServlet;

//import com.sun.tools.javac.util.List;

import domain.model.user.User;

public class InitialAddUserPC extends SampleHttpServlet 
{

	private static final long serialVersionUID = 1L;

	public InitialAddUserPC()
	{
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//if the user is not logged in then he gets sent back to the login page, else he can view this page
		if(request.getSession().getAttribute("userid") == null)
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}	
		
		else if(!((Boolean)request.getSession().getAttribute("userisadmin")))
		{
			try
			{
				request.getRequestDispatcher("/BrowseGroups").forward(request, response);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			request.getRequestDispatcher("JSP/AddUserTV.jsp").forward(request, response);
		}
	} //END of processRequest
}
