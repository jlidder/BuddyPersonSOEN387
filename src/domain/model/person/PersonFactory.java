package domain.model.person;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.role.IRole;
import org.dsrg.soenea.uow.UoW;

import domain.model.person.data.PersonFinder;
import domain.model.user.IUser;

public class PersonFactory 
{
	public static  Person createNew(long id, String username, String password, List<IRole> roles, IUser user) throws SQLException, MapperException{
		Person p = new Person(id, 1, username, password, roles, user);
		//UoW.getCurrent().registerNew(p);  TODO
		return p;
	}
	
	public static Person createClean(long id, long version, String username, String password, List<IRole> roles, IUser user) {
		Person p = new Person(id, version, username, password, roles, user);
		//UoW.getCurrent().registerClean(p);   TODO
		return p;
	}
}
