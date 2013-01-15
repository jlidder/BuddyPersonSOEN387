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

import domain.JavaMD5Hashing;
import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class LoginPC extends SampleHttpServlet 
{
	private static final long serialVersionUID = 7622286105092849102L;

	public LoginPC() 
	{

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException 
	{
		//Clearing the Error attribute
		request.removeAttribute("ERROR");
		

		try
		{
			//if the user is already logged in then he gets sent back to the browse group page, else he can log in
			if(request.getSession().getAttribute("userid") != null)
				request.getRequestDispatcher("/BrowseGroups").forward(request, response);
			else
			{
				String un, pw;
				un = request.getParameter("username");

				//convert user written password into a standardized hash md5, which is how we store it in the DB
				pw = JavaMD5Hashing.produceMD5Hash(request.getParameter("password")); 


				//DEBUG
				System.out.println(" " + un + " " +pw);

				List<User> userlist = new ArrayList<User>();


				userlist = UserInputMapper.findAll();
				boolean access = false;
				for(User ur: userlist)
				{
					if(un.equals(ur.getUserName()))
					{
						System.out.println(pw + " " + ur.getPassword());

						//IF this is successful then you go to the BrowseGroups view....
						System.out.println("USER NAME IS RIGHT...");
						if(pw.equals(ur.getPassword()))
						{
							//DEBUG
							System.out.println("PASSWORD IS RIGHT...");

							access = true;
							
							//Creates the session and sets the userid and first name variables to access.
							HttpSession session = request.getSession();
							session.setAttribute("userid", ur.getId());
							session.setAttribute("usergroup", ur.getGroupId());
							session.setAttribute("loggedinfname", ur.getFirstName());
							session.setAttribute("loggedinlname", ur.getLastName());
							session.setAttribute("userisadmin", ur.isAdmin());
							session.setAttribute("sessionUserVersion", ur.getVersion());			//sets the session version of the user
							
							int groupID = (Integer)request.getSession().getAttribute("usergroup");	//These 3 lines of code gets the usergroup,
							Group currentGroup = GroupInputMapper.find(groupID);							//finds the group using the groupId,
							
							if(currentGroup!=null)session.setAttribute("sessionGroupVersion", currentGroup.getVersion());	//then sets the session version for the group you are in
																									//group version will be more important than user version, as it is the only one that should allow concurrency
							
							//This times out the user after 5 min of inactivity.
							session.setMaxInactiveInterval(300);
							DbRegistry.closeDbConnectionIfNeeded();
							break;
						}
					}
					request.setAttribute("loginerror", "The username and\\or password is incorrect.");
				}

				//If the user supplied good credentials, you get the BrowseGroups page, else you get the prompt to reinsert your info
				if(access)
					request.getRequestDispatcher("/BrowseGroups").forward(request, response);
				else
					request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		catch (SQLException e1) 
		{
			String s = e1.getMessage();
			String s1 = "\nSQL error comes from the Login controller";
			request.setAttribute("ERROR", s+s1);
		}
		catch (IOException e2) 
		{
			String s4 = e2.getMessage();
			String s5 = "\nIO error comes from the Login controller";
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



