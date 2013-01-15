package application.dispatcher;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.AddUserCommand;

public class AddUserDispatcher extends Dispatcher
{
	public void execute() throws ServletException, IOException 
	{
		if(this.myRequest.getMethod().equals("POST"))
		{
		}
		
		try 
		{
			//check if admin
			if(!(Boolean)myHelper.getSessionAttribute("userisadmin") )
			{
				myHelper.setRequestAttribute("ERROR", "You are not a admin, so you cannot upload CSV files.");
				throw new CommandException();
			}
			
			//execute command
			new AddUserCommand(myHelper, this.myRequest, this.myRequest.getMethod().equals("POST")).execute();
			//done executing, so lets move over to the view.
			forward("JSP/AddUserTV.jsp");
		}
		
		catch (CommandException e)
		{
			forward("JSP/Errors.jsp");
			//e.printStackTrace();
		}
	}
}
