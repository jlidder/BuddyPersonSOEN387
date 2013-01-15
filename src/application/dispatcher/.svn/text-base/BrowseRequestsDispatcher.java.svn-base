package application.dispatcher;

import java.io.IOException; 
import javax.servlet.ServletException;
import org.dsrg.soenea.domain.command.CommandException;
import domain.command.BrowseRequestsCommand;
import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;


public class BrowseRequestsDispatcher extends Dispatcher{

	public void execute() throws ServletException, IOException 
	{
		try 
		{
			new BrowseRequestsCommand(myHelper).execute();
			forward("JSP/BrowseRequestsTV.jsp");
		}
		catch (CommandException e)
		{
			forward("JSP/Errors.jsp");
			//e.printStackTrace();
		}
	}
	
}
