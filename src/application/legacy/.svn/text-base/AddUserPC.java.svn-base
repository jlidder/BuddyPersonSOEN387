package application.legacy;
/*
package application;
import java.io.*;   
import java.util.StringTokenizer;

import org.apache.commons.fileupload.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.WebServlet;




import domain.JavaMD5Hashing;
import domain.model.user.User;
import domain.model.user.mapper.UserOutputMapper;
@WebServlet(urlPatterns = "/AddUser")
@MultipartConfig

public class AddUserPC extends SampleHttpServlet 
{
	

	private static final long serialVersionUID = 4476238393334938584L;

	public AddUserPC()
	{
		super();
	}
	
	private String getFileName(Part part) {
	    String partHeader = part.getHeader("content-disposition");
	    //logger.info("Part Header = " + partHeader);
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	      if (cd.trim().startsWith("filename")) {
	        return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	      }
	    }
	    return null;

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
			
			FileOutputStream os;
			String fileName = "";
			String revpath = this.getServletContext().getRealPath("/");  //returns the file path of the current location
			System.out.println("revpath is: " + revpath);
			File createStoragePathFile = null;
										//File createStoragePathFile = new File("//usr//local//www//vhosts//groupsoen3872012a//webapp//servlet//WEB-INF//Logs//csvFile.txt");
										//String storePath = "/usr/local/www/vhosts/groupsoen3872012a/webapp/servlet/WEB-INF/Logs/";//"c:/temp/logs/"; 
			
			for (Part part : request.getParts()) {
				System.out.println("part.getName: " + part.getName());
			      InputStream is = request.getPart(part.getName()).getInputStream();
			      int i = is.available();
			      byte[] b  = new byte[i];
			      is.read(b);		//reading the file
			      System.out.println("Length : " + b.length); //length of file
			      fileName = getFileName(part);
			      System.out.println("File Name : " + fileName);
			      createStoragePathFile = new File(revpath + fileName); //creating the temporary "buffer" file, for storage to the database
			      os = new FileOutputStream(revpath + fileName);		
			      os.write(b);		//writing the original file to the temporary "buffer" file
			      is.close();		//close inputstream
			}
			
			//Below is where the temporary file in the server is read, and added to the database
			BufferedReader bufRdr = new BufferedReader(new InputStreamReader(new FileInputStream(revpath + fileName)));
			
			String line = null;
	
			while((line = bufRdr.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line,",");
				while (st.hasMoreTokens())
				{
					User newUser;
					int userId = 0;
					String group = st.nextToken();
					String first = st.nextToken();
					String last = st.nextToken();
					String userN = st.nextToken();
					String passW = st.nextToken();
					String isAdmin = st.nextToken();
					
					System.out.println(userId + " " + group + " " + first + " " + last + " " + userN + " " + passW + " " + isAdmin);
					
					passW = JavaMD5Hashing.produceMD5Hash(passW);		//hash the password for storage
					
					newUser = new User(userId, Integer.parseInt(group), first, last, userN, passW, Boolean.parseBoolean(isAdmin), 1); 
					
					try 
					{
						UserOutputMapper.insert(newUser);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
						
						//TODO: real error handling (e.g. username taken)
					}
		
			}
		}
		
			bufRdr.close();
			
			//now delete the temporarily uploaded "buffer" file from the server
			boolean success = createStoragePathFile.delete();
			if(!success)
				{
				System.out.println("The file : " + createStoragePathFile.getName() + " failed to delete");
				}else{
					System.out.println("Tempory file on server successfully deleted");
				}
			request.getRequestDispatcher("/BrowseGroups").forward(request, response);
			 
		}
			

		}// END of processRequest
	}

*/

