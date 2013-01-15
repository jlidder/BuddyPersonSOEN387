package domain.command;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.uow.UoW;

import domain.model.group.Group;
import domain.model.group.GroupFactory;
import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.group.mapper.GroupOutputMapper;
import domain.model.invite.Invite;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

public class CreateGroupCommand extends Command{

	private GroupOutputMapper gMapper;
	
	public CreateGroupCommand(Helper helper) 
	{
		super(helper);
		gMapper = new GroupOutputMapper();
	}

	@Override
	public void setUp() throws CommandException 
	{
		
	}

	@Override
	public void process() throws CommandException {
		try
		{
			long userid = (Long)(helper.getSessionAttribute("userid"));
			User usr = UserInputMapper.find(userid);

			if(usr.getGroup().getId() != 0)
			{
				helper.setRequestAttribute("ERROR", "You are currently in a group and cannot access this page.");
				throw new CommandException("You are currently in a group and cannot access this page.");
			}


			String groupname = helper.getString("groupname");
			String groupdesc = (String) helper.getString("groupdesc");

			//****************************************************************************************
			//this doesn't check if a current group exists with the same name... should we allow this?
			//****************************************************************************************


			//long newgroupid = GroupInputMapper.getMaxId()+1;
			Group gr = GroupFactory.createNew(groupname,groupdesc);
			//gMapper.insert(gr);
			UoW.getCurrent().commit();

			//DEBUG
			System.out.println("NEW GROUP ID:" + gr.getId());

			//Setting the users group from 0 to the new groupID
			IGroup newgroup = new GroupProxy(gr.getId());
			usr.setGroup(newgroup);
			//UserOutputMapper.update(usr);
			UoW.getCurrent().registerDirty(usr);
			UoW.getCurrent().commit();


			//Removing any invites that the user may have left
			List<Invite> iList = InviteInputMapper.findAll();
			for(Invite inv: iList)
			{
				if(userid == inv.getUser().getId())
				{
					//InviteOutputMapper.delete(inv);
					UoW.getCurrent().registerDirty(inv);
					UoW.getCurrent().commit();
				}
			}
			
			// set the req attribute with the list of group users (needed for the ViewCurrentGroupTV)
			String title = "View Your Current Group";
			helper.setRequestAttribute("members", usr.getGroup().getMemberList());
			helper.setRequestAttribute("userGroup", usr.getGroup());
			helper.setRequestAttribute("title", title);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			helper.setRequestAttribute("ERROR", "Problem creating the new group. Try again later.");
			throw new CommandException("Problem creating the new group. Try again later.");
		} 
		
		
	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub

	}




}
