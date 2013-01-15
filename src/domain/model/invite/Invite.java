package domain.model.invite;

import org.dsrg.soenea.domain.DomainObject;

import domain.model.group.IGroup;
import domain.model.user.IUser;

public class Invite extends DomainObject<Long> implements IInvite
{
	private IUser user;
	private IGroup group;

	// Constructor
	public Invite( long id, long version, IUser user, IGroup group) 
	{
		super(id, version);
		this.user = user;
		this.group = group;
	}
	
	// getters/setters
	public IUser getUser()
	{
		return user;
	}
	
	public IGroup getGroup()
	{
		return group;
	}
	
	public void setUser(IUser user)
	{
		this.user = user;
	}
	
	public void setGroup(IGroup group)
	{
		this.group = group;
	}

}
