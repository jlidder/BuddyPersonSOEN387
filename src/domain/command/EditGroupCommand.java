package domain.command;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.dsrg.soenea.uow.UoW;

import domain.model.group.Group;
import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupOutputMapper;
import domain.model.user.mapper.UserInputMapper;



public class EditGroupCommand extends Command{
	private GroupOutputMapper gMapper;

	public EditGroupCommand(Helper helper) 
	{
		super(helper);
		gMapper = new GroupOutputMapper();
	}

	@Override
	public void setUp() throws CommandException {
		// TODO Auto-generated method stub

	}

	@Override
	public void process() throws CommandException {

		try
		{
			Group group = ((GroupProxy) UserInputMapper.find((Long)helper.getSessionAttribute("userid")).getGroup()).getInnerObject();
			group.setDescription(helper.getString("description"));
			group.setName(helper.getString("groupname"));
	
			//gMapper.update(group);
			UoW.getCurrent().registerDirty(group);
			UoW.getCurrent().commit();
			
			//This updates the version of the object set in memory.
			group.setVersion(group.getVersion()+1);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			helper.setRequestAttribute("ERROR", "Problem Editing the group. Try again later.");
			throw new CommandException("Problem Editing the group. Try again later.");
		} 

	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub

	}

}

