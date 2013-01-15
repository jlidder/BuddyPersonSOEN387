package domain.model.user;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;

import domain.model.group.IGroup;
import domain.model.invite.IInvite;
import domain.model.person.IPerson;
import domain.model.user.mapper.UserInputMapper;

public class UserProxy extends DomainObjectProxy<Long, User> implements IUser
{

	public UserProxy(Long id) 
	{
		super(id);
	}

	public String getFirstName() 
	{
		return getInnerObject().getFirstName();
	}

	public void setFirstName(String firstName) 
	{
		getInnerObject().setFirstName(firstName);
	}

	public String getLastName() 
	{
		return getInnerObject().getLastName();
	}

	public void setLastName(String lastName)
	{
		getInnerObject().setLastName(lastName);
	}

	public IPerson getPerson() 
	{
		return getInnerObject().getPerson();
	}

	public void setPerson(IPerson per) 
	{
		getInnerObject().setPerson(per);
	}

	public IGroup getGroup()
	{	
		return getInnerObject().getGroup();
	}

	public void setGroup(IGroup group) 
	{
		getInnerObject().setGroup(group);		
	}

	@Override
	public List<IInvite> getInviteList() {
		return getInnerObject().getInviteList();
	}

	@Override
	public void setInviteList(List<IInvite> inviteList) {
		getInnerObject().setInviteList(inviteList);
		
	}
	
	protected User getFromMapper(Long id) throws MapperException,
	DomainObjectCreationException 
	{
	User u = null;
	try 
	{
		u = UserInputMapper.find(id);
	} 
	catch (SQLException e) 
	{
		throw new MapperException(e.getMessage());
	}
	return u;
	}
}
