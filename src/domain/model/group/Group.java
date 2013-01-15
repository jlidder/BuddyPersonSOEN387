package domain.model.group;

import java.util.List;

import org.dsrg.soenea.domain.DomainObject;

import domain.model.requestInvite.IRequestInvite;
import domain.model.user.IUser;

public class Group extends DomainObject<Long> implements IGroup
{
	private String name;
	private String description;
	private List<IUser> memberList;
	private List<IRequestInvite> requestList;
	
	public Group(long id, long version, String name, String desc, List<IUser> userList, List<IRequestInvite> requestList)
	{
		super(id, version);
		this.name = name;
		this.description = desc;
		this.memberList = userList;
		this.requestList = requestList;
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<IUser> getMemberList()
	{
		return this.memberList;
	}
	
	public void setMemberList(List<IUser> uList)
	{
		this.memberList = uList;
	}
	
	@Override
	public List<IRequestInvite> getRequestList() {
		return this.requestList;
	}
	
	@Override
	public void setRequestList(List<IRequestInvite> requestList) {
		this.requestList = requestList;
		
	}
}
