package domain.command;

import java.sql.SQLException; 
import java.util.List;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.requestInvite.IRequestInvite;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;
import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;

public class BrowseRequestsCommand extends Command{

	public BrowseRequestsCommand(Helper helper) 
	{
		super(helper);
	}


	public void setUp() throws CommandException 
	{
		
	}

	public void process() throws CommandException 
	{
		long groupId = -1;
		Group group = null;
		List<IRequestInvite> requestList = null;
		
		try 
		{
			// get the group
			groupId = (Long) helper.getSessionAttribute("groupid");
			group = GroupInputMapper.find(groupId);
			
			//get the group requests
			requestList = group.getRequestList();
		}
		catch (DomainObjectNotFoundException e) 
		{
			throw new CommandException(e.getMessage());
		} 
		catch (SQLException e) 
		{
			throw new CommandException(e.getMessage());
		}
		
		// set request attributes for the view
		helper.setRequestAttribute("requestList", requestList);
		helper.setRequestAttribute("groupId", groupId);
	}

	public void tearDown() throws CommandError 
	{
		
	}

	
}
