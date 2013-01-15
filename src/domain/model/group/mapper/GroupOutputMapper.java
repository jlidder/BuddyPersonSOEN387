package domain.model.group.mapper;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.IOutputMapper;

import domain.model.group.Group;
import domain.model.group.IGroup;
import domain.model.group.data.GroupTDG;

public class GroupOutputMapper implements IOutputMapper<Long, Group>
{

	public void insert(Group g) throws MapperException 
	{
		long checker;
		try 
		{
			checker = GroupTDG.insert(g.getName(), g.getDescription());
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		//g.setId(checker);//set reference to the new ID in DB
	}

	//Later on we will need to make sure that when a group is deleted, all users have their Group variables set to null.
	public void delete(Group g) throws MapperException 
	{
		try 
		{
			GroupTDG.delete(g.getId(),g.getVersion());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	public void update(IGroup g) throws MapperException 
	{
		update((Group) g);
	}
	
	public void update(Group g) throws MapperException 
	{
		try 
		{
			GroupTDG.update(g.getId(), g.getName(), g.getDescription(),g.getVersion());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	@Override
	public void cascadeInsert(Group d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeUpdate(Group d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeDelete(Group d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateInsert(Group d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUpdate(Group d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateDelete(Group d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

}
