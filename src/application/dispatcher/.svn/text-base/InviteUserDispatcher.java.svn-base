package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.InviteUserCommand;

public class InviteUserDispatcher extends Dispatcher
{

	public void execute() throws ServletException, IOException 
	{
		String requestMethod = this.myRequest.getMethod();
		boolean isPost =  "POST".equals(requestMethod);
		
		try 
		{
			new InviteUserCommand(myHelper, isPost).execute();
			forward("JSP/InviteUserTV.jsp");
		}
		catch (CommandException e)
		{
			forward("JSP/Errors.jsp");
			//e.printStackTrace();
		}
	}

}
