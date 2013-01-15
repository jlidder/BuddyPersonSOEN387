package domain.model.requestInvite.mapper;

import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.requestInvite.RequestInvite;
import domain.model.requestInvite.RequestInviteFactory;
import domain.model.requestInvite.data.RequestInviteFinder;
import domain.model.requestInvite.mapper.RequestInviteIdentityMap;
import domain.model.user.IUser;
import domain.model.user.UserProxy;


public class RequestInviteInputMapper {

	private static RequestInviteIdentityMap imap = new RequestInviteIdentityMap();
	private static boolean loadedAll = false;

	public static RequestInvite find(long id) throws SQLException, DomainObjectNotFoundException
	{
		RequestInvite inv = imap.get(id);

		if(inv == null)
		{

			ResultSet rs = RequestInviteFinder.find(id);

			if(rs.next())
			{
				//inv = new Invite( rs.getLong("i.id"), rs.getLong("i.userid"), rs.getInt("i.groupid"),rs.getInt("i.version") );
				inv = getRequestInvite(rs);
			}
			else
			{
				throw new DomainObjectNotFoundException("Cannot find a user with id " + id);
			}
			rs.close();
		}
		return inv;
	}

	private static RequestInvite getRequestInvite(ResultSet rs) throws SQLException {

		
		IUser user = new UserProxy(rs.getLong("i.userid"));
		IGroup group = new GroupProxy(rs.getLong("i.groupid")); //this is the group the user is requesting to be in
		
		RequestInvite result = RequestInviteFactory.createClean(
				rs.getLong("i.id"),
				rs.getLong("i.version"),
				user,
				group
				);

		//Checks to see if the invite isn't already in the identity map first...
		if(imap.get(result.getId()) == null)
			imap.put(result.getId(), result);

		return result;
	}

	public static List<RequestInvite> findAll() throws SQLException
	{
		List<RequestInvite> requestInviteList = null;


		if(!loadedAll)
		{
			ResultSet rs = RequestInviteFinder.findAll();
			requestInviteList = new ArrayList<RequestInvite>();

			//This while adds users to the list
			while(rs.next())
			{
				//inviteList.add( new Invite(rs.getLong("i.id"), rs.getLong("i.userid"), rs.getInt("i.groupid"),rs.getInt("i.version")) );
				requestInviteList.add(getRequestInvite(rs));
			}
			rs.close();
			loadedAll = true;
		}
		else
		{
			requestInviteList = imap.getAll();
		}

		return requestInviteList;
	} 

	
}
