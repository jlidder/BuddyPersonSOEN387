package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.CreateGroupCommand;


public class CreateGroupDispatcher extends Dispatcher{

	public void execute() throws ServletException, IOException {
		
		try 
		{
			if(myRequest.getMethod() == "GET")
			{
				System.out.println("In the GET method");
				forward("JSP/CreateGroupTV.jsp");
			}
			else if(myRequest.getMethod() == "POST")
			{
			new CreateGroupCommand(myHelper).execute();
			forward("JSP/ViewCurrentGroupTV.jsp");
			}
			else
			{
				myHelper.setRequestAttribute("ERROR", "Problem with creating group. Please try again later.");
				throw new CommandException("Problem with creating group. Please try again later.");
			}
		} 
		catch (CommandException e) 
		{
			forward("JSP/Errors.jsp");
		}

		
	}

}
