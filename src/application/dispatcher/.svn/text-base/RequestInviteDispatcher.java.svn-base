package application.dispatcher;

import java.io.IOException; 

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.RequestInviteCommand;

public class RequestInviteDispatcher extends Dispatcher{

	@Override
	public void execute() throws ServletException, IOException {
		
		
		try 
		{
			new RequestInviteCommand(myHelper).execute();
			forward("JSP/RequestInviteTV.jsp");
		} 
		catch (CommandException e) 
		{
			forward("JSP/Errors.jsp");
			
		}
		
		
		
	}
	
}

