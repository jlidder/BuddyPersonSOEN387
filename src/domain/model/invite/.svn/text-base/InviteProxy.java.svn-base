package domain.model.invite;

import java.sql.SQLException;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;

import domain.model.group.IGroup;
import domain.model.invite.mapper.InviteInputMapper;
import domain.model.user.IUser;

public class InviteProxy extends DomainObjectProxy<Long, Invite> implements IInvite
{

	protected InviteProxy(Long id) 
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
	protected Invite getFromMapper(Long id) throws MapperException,
			DomainObjectCreationException 
	{
		Invite inv = null;
		try
	    {
			InviteInputMapper.find(id);
		} 
		 catch (SQLException e) 
		{
			throw new MapperException(e.getMessage());
		}
		 
		 return inv;
	}
	
	

}
