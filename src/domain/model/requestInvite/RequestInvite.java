package domain.model.requestInvite;

import org.dsrg.soenea.domain.DomainObject; 

import domain.model.group.IGroup;
import domain.model.requestInvite.IRequestInvite;
import domain.model.user.IUser;

public class RequestInvite extends DomainObject<Long> implements IRequestInvite
{
	private IUser user;
	private IGroup group;

	// Constructor
	public RequestInvite( long id, long version, IUser user, IGroup group) 
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



