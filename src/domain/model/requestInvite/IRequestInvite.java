package domain.model.requestInvite;

import org.dsrg.soenea.domain.interf.IDomainObject;

import domain.model.group.IGroup;
import domain.model.user.IUser;

public interface IRequestInvite extends IDomainObject<Long>
{
	public IUser getUser();
	
	public IGroup getGroup();
	
	public void setUser(IUser user);
	
	public void setGroup(IGroup group);
}
