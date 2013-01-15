package domain.model.user;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.role.IRole;

import domain.model.group.IGroup;
import domain.model.invite.IInvite;
import domain.model.invite.UserInviteListProxy;
import domain.model.person.IPerson;
import domain.model.user.data.UserFinder;


public class UserFactory 
{
	public static User createNew(long id, IGroup group, String firstname, String lastname, IPerson person) throws SQLException, MapperException{
		List<IInvite> inviteList = new UserInviteListProxy(id);
		User u = new User(id, 1, group, firstname, lastname, person, inviteList);
		//UoW.getCurrent().registerNew(u);  TODO
		return u;
	}
	
	public static User createClean(long id, long version, IGroup group, String firstname, String lastname, IPerson person) {
		List<IInvite> inviteList = new UserInviteListProxy(id);
		User u = new User(id, version, group, firstname, lastname, person,inviteList);
		//UoW.getCurrent().registerClean(u);   TODO
		return u;
	}
}
