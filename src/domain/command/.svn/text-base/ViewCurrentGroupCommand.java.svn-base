package domain.command;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.group.Group;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.user.IUser;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class ViewCurrentGroupCommand extends Command{

	public ViewCurrentGroupCommand(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws CommandException {
		// TODO Auto-generated method stub

	}

	@Override
	public void process() throws CommandException {
		try
		{
			List<User> uList = UserInputMapper.findAll();	
			String title = "View Your Current Group";
			
			// get user, group, and group members
			long userid = (Long) helper.getSessionAttribute("userid");
			User currentUser  = UserInputMapper.find(userid);
			IGroup userGroup = currentUser.getGroup();	
			List<IUser> groupMembers = userGroup.getMemberList();
			
			helper.setRequestAttribute("userGroup", userGroup);
			helper.setRequestAttribute("members", groupMembers);
			helper.setRequestAttribute("title", title);
		}
		catch (SQLException e)
		{
			throw new CommandException(e.getMessage());
		} 
		catch (DomainObjectNotFoundException e) 
		{
			throw new CommandException(e.getMessage());
			//e.printStackTrace();
		}

	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub

	}

}
