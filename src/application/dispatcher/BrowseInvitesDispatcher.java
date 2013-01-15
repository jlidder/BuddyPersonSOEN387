package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.BrowseInvitesCommand;

public class BrowseInvitesDispatcher extends Dispatcher
{

	public void execute() throws ServletException, IOException 
	{
		try 
		{
			new BrowseInvitesCommand(myHelper).execute();
			forward("JSP/BrowseInvitesTV.jsp");
		}
		catch (CommandException e)
		{
			forward("JSP/Errors.jsp");
			//e.printStackTrace();
		}
	}
}
