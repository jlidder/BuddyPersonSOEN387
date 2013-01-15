package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;

import domain.command.AcceptDeclineInviteCommand;

public class AcceptDeclineInviteDispatcher extends Dispatcher
{
	public void execute() throws ServletException, IOException 
	{
		
		try 
		{
			new AcceptDeclineInviteCommand(myHelper).execute();
			forward("JSP/ViewCurrentGroupTV.jsp");
		} 
		catch (CommandException e) 
		{
			if(e.getCause() instanceof LostUpdateException) 
			{
				e.printStackTrace();
				forward("JSP/Errors.jsp");
			}
			e.printStackTrace();
			forward("JSP/BrowseInvitesTV.jsp");
		}
	}

}
