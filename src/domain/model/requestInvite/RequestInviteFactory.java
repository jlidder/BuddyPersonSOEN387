package domain.model.requestInvite;

import java.sql.SQLException; 
import java.util.List;

import org.dsrg.soenea.domain.MapperException;

import domain.model.group.IGroup;
import domain.model.requestInvite.data.RequestInviteFinder;
import domain.model.user.IUser;

public class RequestInviteFactory 
{
	public static  RequestInvite createNew(IUser user, IGroup group) throws SQLException, MapperException{
		return createNew(RequestInviteFinder.getMaxId()+1, 1, user, group);
	}
	
	public static  RequestInvite createNew(long id, long version, IUser user, IGroup group) throws SQLException, MapperException{
		RequestInvite i = new RequestInvite(id, version, user, group);
		//UoW.getCurrent().registerNew(i);  TODO
		return i;
	}
	
	public static RequestInvite createClean(long id, long version, IUser user, IGroup group) {
		RequestInvite i = new RequestInvite(id, version, user, group);
		//UoW.getCurrent().registerClean(i);   TODO
		return i;
	}
}