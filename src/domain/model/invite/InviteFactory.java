package domain.model.invite;

import java.sql.SQLException;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.role.IRole;

import domain.model.group.IGroup;
import domain.model.invite.data.InviteFinder;
import domain.model.person.Person;
import domain.model.person.data.PersonFinder;
import domain.model.user.IUser;

public class InviteFactory 
{
	public static  Invite createNew(IUser user, IGroup group) throws SQLException, MapperException{
		return createNew(InviteFinder.getMaxId()+1, 1, user, group );
	}
	
	public static  Invite createNew(long id, long version, IUser user, IGroup group) throws SQLException, MapperException{
		Invite i = new Invite(id, version, user, group);
		//UoW.getCurrent().registerNew(i);  TODO
		return i;
	}
	
	public static Invite createClean(long id, long version, IUser user, IGroup group) {
		Invite i = new Invite(id, version, user, group);
		//UoW.getCurrent().registerClean(i);   TODO
		return i;
	}
}
