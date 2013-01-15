package application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.application.servlet.dispatcher.Dispatcher;

public class LogoutDispatcher extends Dispatcher{


	public void execute() throws ServletException, IOException {
		
		myRequest.getSession().invalidate();
		forward("JSP/logout.jsp");		
	}

	
	
	
}
