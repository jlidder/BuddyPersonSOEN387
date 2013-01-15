package domain.model.person.mapper;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.IOutputMapper;
import org.dsrg.soenea.domain.role.IRole;

import domain.model.invite.Invite;
import domain.model.person.Person;
import domain.model.person.data.PersonTDG;


public class PersonOutputMapper implements IOutputMapper<Long, Person>
{

	public void insert(Person p) throws MapperException
	{
		
		List<IRole> roles = p.getRoles();
		long role =  roles.get(0).getId();
		
		//insert(long version, String username, String password, long role)		
		try {
			PersonTDG.insert(p.getVersion(), p.getUsername(), p.getPassword(), role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
		p.setVersion(1);
	}

	public void update(Person p) throws MapperException
	{
		List<IRole> roles = p.getRoles();
		long role =  roles.get(0).getId();
		
		//update(long id, long version, String username, String password, long role)
		 try {
			PersonTDG.update(p.getId(),p.getVersion(), p.getUsername(), p.getPassword(), role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	public void delete(Person p) throws MapperException
	{
		 try {
			PersonTDG.delete(p.getId(), p.getVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MapperException(e.getMessage());
		}
	}

	@Override
	public void cascadeInsert(Person d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeUpdate(Person d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeDelete(Person d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateInsert(Person d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUpdate(Person d) throws MapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateDelete(Person d) throws MapperException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
