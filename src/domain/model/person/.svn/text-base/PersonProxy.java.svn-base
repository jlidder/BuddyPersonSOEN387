

package domain.model.person;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;
import org.dsrg.soenea.domain.role.IRole;

import domain.model.person.mapper.PersonInputMapper;
import domain.model.user.IUser;

public class PersonProxy extends DomainObjectProxy<Long, Person> implements IPerson
{

	public PersonProxy(Long id) 
	{
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getInnerObject().getUsername();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getInnerObject().getPassword();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		getInnerObject().setUsername(username);
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		getInnerObject().setPassword(password);
		
	}

	@Override
	public List<IRole> getRoles() {
		// TODO Auto-generated method stub
		return getInnerObject().getRoles();
	}

	@Override
	public void setRoles(List<IRole> roles) {
		// TODO Auto-generated method stub
		getInnerObject().setRoles(roles);
		
	}

	@Override
	public boolean hasRole(Class<? extends IRole> role) {
		// TODO Auto-generated method stub
		return getInnerObject().hasRole(role);
	}

	@Override
	public boolean hasChangedPassword() {
		// TODO Auto-generated method stub
		return getInnerObject().hasChangedPassword();
	}

	@Override
	public void setUser(IUser user) {
		// TODO Auto-generated method stub
		getInnerObject().setUser(user);
	}

	@Override
	public IUser getUser() {
		// TODO Auto-generated method stub
		return getInnerObject().getUser();
	}

	@Override
	protected Person getFromMapper(Long id) throws MapperException,
			DomainObjectCreationException 
	{
		// TODO Auto-generated method stub
		Person p = null;
		try
		{
			p = PersonInputMapper.find(id);
		} 
		catch (SQLException e) 
		{
			throw new MapperException(e.getMessage());
		}
		
		return p;
	}
	
}
