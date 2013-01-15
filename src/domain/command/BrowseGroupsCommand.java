package domain.command;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class BrowseGroupsCommand extends Command{

	public BrowseGroupsCommand(Helper helper) {
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
		List<Group> gList = GroupInputMapper.findAll();		
		List<User> uList = UserInputMapper.findAll();
		String title = "Browse Groups";

		helper.setRequestAttribute("groups", gList);
		helper.setRequestAttribute("users", uList);
		helper.setRequestAttribute("title", title);
		}
		catch (SQLException e) 
		{
			throw new CommandException(e);
			//e.printStackTrace();
		} catch (DomainObjectNotFoundException e) {
			// TODO Auto-generated catch block
			throw new CommandException(e);
		}
	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub
		
	}

	
	
}
