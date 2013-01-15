package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;
import org.dsrg.soenea.domain.command.CommandException;

import domain.command.ViewCurrentGroupCommand;


public class ViewCurrentGroupDispatcher extends Dispatcher{

	@Override
	public void execute() throws ServletException, IOException {
		
		
		try 
		{
			new ViewCurrentGroupCommand(myHelper).execute();
			forward("JSP/ViewCurrentGroupTV.jsp");
		} 
		catch (CommandException e) 
		{
			forward("JSP/Errors.jsp");
			//e.printStackTrace();
		}
		
		
		
	}

	
	
	
}
