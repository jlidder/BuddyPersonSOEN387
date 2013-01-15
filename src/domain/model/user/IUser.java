package domain.model.user;

import java.util.List;

import org.dsrg.soenea.domain.interf.IDomainObject;

import domain.model.group.IGroup;
import domain.model.invite.IInvite;
import domain.model.person.IPerson;

public interface IUser extends IDomainObject<Long>
{
	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public IPerson getPerson();

	public void setPerson(IPerson per);

	public IGroup getGroup();

	public void setGroup(IGroup group);
	
	public List<IInvite> getInviteList();
	
	public void setInviteList(List<IInvite> inviteList);
}
