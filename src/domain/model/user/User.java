package domain.model.user;

import java.util.List;

import org.dsrg.soenea.domain.DomainObject;

import domain.model.group.IGroup;
import domain.model.invite.IInvite;
import domain.model.person.IPerson;


public class User extends DomainObject<Long> implements IUser
{

	private String firstName;
	private String lastName;
	private IPerson person;
	private IGroup group;
	private List<IInvite> inviteList;
	// TODO: private IInviteList (InviteListProxy) inviteList;
	
	public User(long id, long version, IGroup group, String fn, String ln, IPerson per, List<IInvite> inviteList)
	{
		super(id, version);
		this.group = group;
		this.firstName = fn;
		this.lastName = ln;
		this.person = per;
		this.inviteList = inviteList;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public IPerson getPerson() {
		return person;
	}

	public void setPerson(IPerson per) {
		this.person = per;
	}

	public IGroup getGroup() {
		return group;
	}

	public void setGroup(IGroup newgroup) {
		this.group = newgroup;
	}


	@Override
	public List<IInvite> getInviteList() {
		return this.inviteList;
	}


	@Override
	public void setInviteList(List<IInvite> inviteList) {
		this.inviteList = inviteList;
		
	}

	
	
}
