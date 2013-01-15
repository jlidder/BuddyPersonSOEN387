package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.BrowseGroupsCommand;
import domain.command.EditGroupCommand;
import domain.command.ViewCurrentGroupCommand;

public class EditGroupDispatcher extends Dispatcher {

	public void execute() throws ServletException, IOException {

		try 
		{
			if(myRequest.getMethod() == "GET")
			{
				new BrowseGroupsCommand(myHelper).execute();
				forward("JSP/EditGroupTV.jsp");
			}
			else if(myRequest.getMethod() == "POST")
			{
				new EditGroupCommand(myHelper).execute();
				new ViewCurrentGroupCommand(myHelper).execute();
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
