package domain.model.invite;

import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.proxy.ListProxy;

import domain.model.invite.mapper.InviteInputMapper;

public class UserInviteListProxy extends ListProxy<IInvite>
{
	private long userId;
	
	public UserInviteListProxy(long userId)
	{
		super();
		this.userId = userId;
	}
	
	@Override
	protected List<IInvite> getActualList() throws Exception 
	{
		List<Invite> allInvites = InviteInputMapper.findAll();
		List<IInvite> userInvites = new ArrayList<IInvite>();
		
		for(Invite invite: allInvites)
		{
			if(invite.getUser().getId() == this.userId)
			{
				userInvites.add(invite);
			}
		}
		
		return userInvites;		
	}

}
