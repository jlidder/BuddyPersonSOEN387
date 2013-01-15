package domain.model.person.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.role.IRole;

import domain.model.person.Person;
import domain.model.person.PersonFactory;
import domain.model.person.data.PersonFinder;
import domain.model.role.AdminRole;
import domain.model.role.StudentRole;
import domain.model.user.IUser;
import domain.model.user.UserProxy;

public class PersonInputMapper {


		public static Person find(Long id) throws SQLException, DomainObjectNotFoundException
		{
			Person p = null;

				ResultSet rs = PersonFinder.find(id);	

				if(rs.next())
				{	
					//The constructor = User(int id, String fn, String ln, String un, String pw)
					//u = new User(rs.getInt("u.userid"), rs.getInt("u.groupid"), rs.getString("u.firstname"), rs.getString("u.lastname"), rs.getString("u.username"), rs.getString("u.password"), rs.getBoolean("u.admin"), rs.getInt("u.version"));
					p = getPerson(rs);
				}
				else
				{
					throw new DomainObjectNotFoundException("Cannot find a user with id " + id);
				}
				rs.close();

			return p;
		}

		public static List<Person> findAll() throws SQLException, DomainObjectNotFoundException
		{
			List<Person> personlist = null;

				ResultSet rs = PersonFinder.findAll();
				personlist = new ArrayList<Person>();

				//This while adds persons to the list
				while(rs.next())
				{
					personlist.add(getPerson(rs));
				}
				rs.close();

			return personlist;
		} 


		private static Person getPerson(ResultSet rs) throws SQLException, DomainObjectNotFoundException {
			//public Person(long id, String username, List<IRole> roles)
			int test = rs.getInt("p.role");
			List<IRole> role = null;
			
			if(test == 2)
			{
				role = new ArrayList<IRole>();
				StudentRole e = new StudentRole();
				role.add(e);
				
			}
			else if(test == 3)
			{
				role = new ArrayList<IRole>();
				AdminRole e = new AdminRole();
				role.add(e);
			}
			else
			{
				throw new DomainObjectNotFoundException("Error while trying to create the Person");
			}
			IUser user = new UserProxy(rs.getLong("p.id")); // TODO: use the UserFactory (create new)
			Person result = PersonFactory.createClean(
					rs.getLong("p.id"),
					rs.getLong("p.version"),
					rs.getString("p.username"),
					rs.getString("p.password"),
					role,
					user
					);

			return result;
		}
	}
	

