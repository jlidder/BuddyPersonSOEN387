package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.LoginCommand;

public class LoginDispatcher extends Dispatcher 
{

	@Override
	public void execute() throws ServletException, IOException 
	{
		//if the user is already logged in then he gets sent back to the browse group page, else he can log in
		if(myHelper.getSessionAttribute("userid") != null)
		{
			forward("/GroupFormationSoftware?dispatcher=application.dispatcher.BrowseGroupsDispatcher");
		}
		
		else
		{
			try 
			{
				new LoginCommand(myHelper).execute();
				forward("/GroupFormationSoftware?dispatcher=application.dispatcher.BrowseGroupsDispatcher");
			} 
			catch (CommandException e) 
			{
				forward("/index.jsp");
			}
		}
	}

}