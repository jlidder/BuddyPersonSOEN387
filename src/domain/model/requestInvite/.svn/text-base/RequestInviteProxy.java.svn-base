package domain.model.requestInvite;

import java.sql.SQLException; 

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;

import domain.model.group.IGroup;
import domain.model.requestInvite.mapper.RequestInviteInputMapper;
import domain.model.user.IUser;

public class RequestInviteProxy extends DomainObjectProxy<Long, RequestInvite> implements IRequestInvite
{

	protected RequestInviteProxy(Long id) 
	{
		super(id);
	}

	@Override
	public IUser getUser() {
		return getInnerObject().getUser();
	}

	@Override
	public IGroup getGroup() {
		return getInnerObject().getGroup();
	}

	@Override
	public void setUser(IUser user) {
		getInnerObject().setUser(user);
	}

	@Override
	public void setGroup(IGroup group) {
		getInnerObject().setGroup(group);
		
	}

	@Override
	protected RequestInvite getFromMapper(Long id) throws MapperException,
			DomainObjectCreationException 
	{
		RequestInvite inv = null;
		try
	    {
			RequestInviteInputMapper.find(id);
		} 
		 catch (SQLException e) 
		 {
			throw new MapperException(e.getMessage());
		}
		 
		 return inv;
	}
	
	

}

