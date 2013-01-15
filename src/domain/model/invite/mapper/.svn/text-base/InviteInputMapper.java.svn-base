package domain.model.invite.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.invite.Invite;
import domain.model.invite.InviteFactory;
import domain.model.invite.data.InviteFinder;
import domain.model.user.IUser;
import domain.model.user.UserProxy;


public class InviteInputMapper {

	private static InviteIdentityMap imap = new InviteIdentityMap();
	private static boolean loadedAll = false;

	public static Invite find(long id) throws SQLException, DomainObjectNotFoundException
	{
		Invite inv = imap.get(id);

		if(inv == null)
		{

			ResultSet rs = InviteFinder.find(id);

			if(rs.next())
			{
				//inv = new Invite( rs.getLong("i.id"), rs.getLong("i.userid"), rs.getInt("i.groupid"),rs.getInt("i.version") );
				inv = getInvite(rs);
			}
			else
			{
				throw new DomainObjectNotFoundException("Cannot find a user with id " + id);
			}
			rs.close();
		}
		return inv;
	}

	private static Invite getInvite(ResultSet rs) throws SQLException {
		//Invite( long id, long userId, long groupId, int version)
		//"SELECT i.id, i.groupid, i.userid, i.version FROM "
		
		IUser user = new UserProxy(rs.getLong("i.userid"));
		IGroup group = new GroupProxy(rs.getLong("i.groupid"));
		
		Invite result = InviteFactory.createClean(
				rs.getLong("i.id"),
				rs.getInt("i.version"),
				user,
				group
				);

		//Checks to see if the invite isn't already in the identity map first...
		if(imap.get(result.getId()) == null)
			imap.put(result.getId(), result);

		return result;
	}

	/*
	public static Invite find(long userid, long groupid) throws SQLException
	{
		ResultSet rs = null;
		Invite invite = null;

		rs = InviteFinder.find( userid, groupid );
		if(rs.next())
		{
			invite = new Invite( rs.getLong("i.id"), rs.getLong("i.userid"), rs.getInt("i.groupid"),rs.getInt("i.version") );
		}
		rs.close();

		return invite;
	}
	 */

	public static List<Invite> findAll() throws SQLException
	{
		List<Invite> inviteList = null;


		if(!loadedAll)
		{
			ResultSet rs = InviteFinder.findAll();
			inviteList = new ArrayList<Invite>();

			//This while adds users to the list
			while(rs.next())
			{
				//inviteList.add( new Invite(rs.getLong("i.id"), rs.getLong("i.userid"), rs.getInt("i.groupid"),rs.getInt("i.version")) );
				inviteList.add(getInvite(rs));
			}
			rs.close();
			loadedAll = true;
		}
		else
		{
			inviteList = imap.getAll();
		}

		return inviteList;
	} 
	
	public static List<Invite> findInvitesFromGroup(long groupId) throws SQLException
	{
		List<Invite> inviteList = null;

		if(!loadedAll)
		{
			ResultSet rs = InviteFinder.findAll();
			inviteList = new ArrayList<Invite>();

			//This while adds users to the list
			while(rs.next())
			{
				//inviteList.add( new Invite(rs.getLong("i.id"), rs.getLong("i.userid"), rs.getInt("i.groupid"),rs.getInt("i.version")) );
				inviteList.add(getInvite(rs));
			}
			rs.close();
			loadedAll = true;
		}
		else
		{
			inviteList = imap.getAll();
		}

		return inviteList;
	} 

}
