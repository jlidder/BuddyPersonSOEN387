package domain.model.group;

import java.sql.SQLException; 
import java.util.List;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;

import domain.model.group.mapper.GroupInputMapper;
import domain.model.user.IUser;
import domain.model.group.IGroup;
import domain.model.requestInvite.IRequestInvite;


public class GroupProxy extends DomainObjectProxy<Long, Group> implements IGroup
{

	public GroupProxy(Long id)
	{
		super(id);
	}

	@Override
	public String getName() {
		return getInnerObject().getName();
	}

	@Override
	public void setName(String name) {
		getInnerObject().setName(name);
	}

	@Override
	public String getDescription() {
		
		return getInnerObject().getDescription();
	}

	@Override
	public void setDescription(String description) {
		getInnerObject().setDescription(description);
		
	}
	
	public List<IUser> getMemberList()
	{
		return getInnerObject().getMemberList();
	}
	
	public void setMemberList(List<IUser> uList)
	{
		getInnerObject().setMemberList(uList);
	}
	
	
	@Override
	public List<IRequestInvite> getRequestList() {
		return getInnerObject().getRequestList();
	}
	

	@Override
	public void setRequestList(List<IRequestInvite> requestList) {
		getInnerObject().setRequestList(requestList);
	}
	
	@Override
	protected Group getFromMapper(Long id) throws MapperException,
			DomainObjectCreationException {
		
		try 
		{
			return GroupInputMapper.find(id);
		} 
		catch (SQLException e) 
		{
			throw new MapperException(e.getMessage());
		}
	}
	
	

}
