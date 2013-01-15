package domain.model.group;

import java.util.List;

import org.dsrg.soenea.domain.interf.IDomainObject;

import domain.model.requestInvite.IRequestInvite;
import domain.model.user.IUser;

public interface IGroup extends IDomainObject<Long>
{
	public String getName();
	
	public void setName(String name);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public List<IUser> getMemberList();
	
	public void setMemberList(List<IUser> uList);
	
	public List<IRequestInvite> getRequestList();

	public void setRequestList(List<IRequestInvite> requestList);
}
