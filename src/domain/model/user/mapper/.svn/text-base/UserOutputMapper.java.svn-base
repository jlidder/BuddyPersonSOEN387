package domain.model.user.mapper;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.IOutputMapper;

import domain.model.group.Group;
import domain.model.user.User;
import domain.model.user.data.UserTDG;

public class UserOutputMapper implements IOutputMapper<Long, User>
{

	public void insert(User u) throws MapperException 
	{
		int checker;
		try 
		{
			checker = UserTDG.insert(u.getGroup().getId(),u.getFirstName(), u.getLastName(), u.getPerson().getId());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
		u.setVersion(1);
		//u.setId(checker);//set reference to the new ID in DB
	}

	public void update(User u) throws MapperException
	{
		//update(long userid, long version, long groupid, String firstname, String lastname, int person)
		try
		{
			UserTDG.update(u.getId(),u.getVersion(),u.getGroup().getId(), u.getFirstName(), u.getLastName(), u.getPerson().getId());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	public void delete(User u) throws MapperException
	{
		try
		{
			UserTDG.delete(u.getId(), u.getVersion());
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	@Override
	public void cascadeInsert(User d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeUpdate(User d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeDelete(User d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateInsert(User d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUpdate(User d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateDelete(User d) throws MapperException {
		// TODO Auto-generated method stub
		
	}
	
}
