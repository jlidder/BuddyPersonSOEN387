package domain.command;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.dsrg.soenea.uow.UoW;

import domain.model.invite.IInvite;
import domain.model.invite.Invite;
import domain.model.invite.InviteProxy;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.invite.mapper.InviteOutputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;
import domain.model.user.mapper.UserOutputMapper;

public class AcceptDeclineInviteCommand extends Command
{
	private InviteOutputMapper ioM;
	
	public AcceptDeclineInviteCommand(Helper helper)
	{
		super(helper);
		ioM = new InviteOutputMapper();
	}

	public void setUp() throws CommandException 
	{
		
	}

	public void process() throws CommandException 
	{
		String accept = helper.getString("accepted");
		long inviteid = helper.getLong("inviteid");
		int inviteversion = helper.getInt("inviteversion");	
		
		try
		{
			User user = UserInputMapper.find((Long) helper.getSessionAttribute("userid"));
			List<IInvite> inviteList = user.getInviteList();
		
			if(accept.equalsIgnoreCase("true"))
			{	
				// invite accepted			
				for(IInvite invite: inviteList)
				{						
					if(invite.getId()==inviteid)
					{
						user.setGroup(invite.getGroup());
						user.getGroup().getMemberList().add(user);
					}
					
					Invite inviteToRemove = InviteInputMapper.find(invite.getId());
					//ioM.delete(inviteToRemove);
					UoW.getCurrent();
					UoW.getCurrent().registerRemoved( inviteToRemove );
					
					System.out.println("NEW GROUP:"+user.getGroup().getId());
					
					//UserOutputMapper.update(user);
					UoW.getCurrent().registerDirty(user);
					//UoW.getCurrent().commit();
					
				}

				UoW.getCurrent().commit();
				
				user.setInviteList(null);
				
				// Setting the session group variable so that the menu shows accordingly
				helper.setSessionAttribute("usergroup", user.getGroup().getId());
				
				// request attributes for ViewCurrentGroup
				helper.setRequestAttribute("members", user.getGroup().getMemberList());
				helper.setRequestAttribute("userGroup", user.getGroup());				
			}
			else
			{
				// invite declined				
				int invToRemove = -1;
				
				for(IInvite invite: inviteList)
				{
					invToRemove++;
					
					if(invite.getId()==inviteid)
					{
						Invite inviteToRemove = InviteInputMapper.find(invite.getId());
						//ioM.delete(inviteToRemove);
						UoW.getCurrent();
						UoW.getCurrent().registerRemoved( inviteToRemove );
						UoW.getCurrent().commit();
						
						break;
					}
				}
				
				if(invToRemove >= 0)
				{
					inviteList.remove(invToRemove);
				}
				
				helper.setRequestAttribute("inviteList", user.getInviteList());
				helper.setRequestAttribute("userGroup", user.getGroup());	
				
				throw new CommandException("Invite Declined");
			}
		}
		catch (Exception e)
		{
			throw new CommandException(e.getMessage());
		} 
		
	}

	public void tearDown() throws CommandError 
	{
		
	}

}
