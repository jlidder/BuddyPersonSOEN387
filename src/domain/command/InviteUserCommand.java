package domain.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.uow.UoW;

import domain.model.group.Group;
import domain.model.group.IGroup;
import domain.model.invite.IInvite;
import domain.model.invite.Invite;
import domain.model.invite.InviteFactory;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

public class InviteUserCommand extends Command
{
	private boolean post;

	public InviteUserCommand(Helper helper,  boolean isPost) 
	{
		super(helper);
		post = isPost;
	}

	public void setUp() throws CommandException 
	{
	}

	@SuppressWarnings("null")
	public void process() throws CommandException
	{
		User invitingUser = null;
		long userid = -1;
		long groupid = -1;
		List<User> userList = null;
		List<User> finalUserList = new ArrayList<User>();
	
		try 
		{
			// get the inviting user
			userid = (Long) helper.getSessionAttribute("userid");
			invitingUser = UserInputMapper.find(userid);
			
			
			// if "POST" then try to invite user.
			if (post) 
			{
				inviteUser(invitingUser);
			}
			
			
			// get the inviting user group id
			groupid = invitingUser.getGroup().getId();
			
			// get a list of all users 
			userList = UserInputMapper.findAll();
			
			// filter out users already in a group and those already invited to this group
			for(User u: userList)
			{
				if( u.getGroup() == null || u.getGroup().getId() == 0 )
				{
					List<IInvite> userInvites = u.getInviteList();
					
					boolean alreadyInvited = false;
					
					for(IInvite i: userInvites)
					{
						if(i.getGroup().getId() == groupid)
						{
							alreadyInvited = true;
							break;
						}
					}
					
					if(!alreadyInvited)
					{
						finalUserList.add(u);
					}
				}
			}
			

		} 
		catch (Exception e) 
		{		
			e.printStackTrace();
			throw new CommandException(e.getMessage());			
		}
				
		// set attributes to pass to the view
		helper.setRequestAttribute("groupId", groupid);
		helper.setRequestAttribute("userList", finalUserList);
		
	}

	
	private void inviteUser(User invitingUser) throws SQLException, MapperException, InstantiationException, IllegalAccessException
	{
		User user = invitingUser;
		User invitedUser = null;
		IGroup invitingGroup = null;
		long userid = -1;
		long groupid = -1;
		long invitedUserId = -1;
		long invitedUserVersion = -1;
		
		// get the inviting user group
		invitingGroup = user.getGroup();
		
		// get the invitedUser
		invitedUserId = helper.getLong("userId");
		invitedUserVersion = helper.getLong("userversionForInvitation");
		invitedUser = UserInputMapper.find(invitedUserId);
		invitedUser.setVersion(invitedUserVersion);
		
		// Invite to group
		Invite invite = InviteFactory.createNew(invitedUser, invitingGroup);
		invitedUser.getInviteList().add(invite);
		
		UoW.getCurrent().commit();
	
	}
	
	public void tearDown() throws CommandError 
	{
		
	}

}
