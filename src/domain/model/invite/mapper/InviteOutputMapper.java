package domain.model.invite.mapper;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.IOutputMapper;

import domain.model.group.Group;
import domain.model.invite.IInvite;
import domain.model.invite.Invite;
import domain.model.invite.data.InviteTDG;

public class InviteOutputMapper implements IOutputMapper<Long, Invite>
{

	public void insert(Invite invite) throws MapperException
	{
		 try
		 {
			InviteTDG.insert( invite.getUser().getId(), invite.getGroup().getId() );
		} 
		 catch (SQLException e)
		 {
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	public void delete(Invite invite) throws MapperException
	{
		 try 
		 {
			InviteTDG.delete(invite.getId(), invite.getVersion());
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}
	
	public void update(Invite invite) throws MapperException
	{
		 try {
			InviteTDG.update(invite.getGroup().getId(), invite.getUser().getId(), invite.getId(), invite.getVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}



	@Override
	public void cascadeInsert(Invite d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeUpdate(Invite d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeDelete(Invite d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateInsert(Invite d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUpdate(Invite d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateDelete(Invite d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

}
