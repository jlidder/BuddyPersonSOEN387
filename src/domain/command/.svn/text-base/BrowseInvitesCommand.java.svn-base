package domain.command;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.invite.IInvite;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class BrowseInvitesCommand extends Command
{

	public BrowseInvitesCommand(Helper helper) 
	{
		super(helper);
	}


	public void setUp() throws CommandException 
	{
		
	}

	public void process() throws CommandException 
	{
		long userId = -1;
		User user = null;
		List<IInvite> inviteList = null;
		
		try 
		{
			// get the user
			userId = (Long) helper.getSessionAttribute("userid");
			user = UserInputMapper.find(userId);

			// get the user invites
			inviteList = user.getInviteList();
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
		helper.setRequestAttribute("inviteList", inviteList);
		helper.setRequestAttribute("userId", userId);
	}

	public void tearDown() throws CommandError 
	{
		
	}

}
