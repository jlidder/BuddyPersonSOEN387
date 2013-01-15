package domain.model.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;


import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.person.IPerson;
import domain.model.person.PersonProxy;
import domain.model.user.IUser;
import domain.model.user.User;
import domain.model.user.UserFactory;
import domain.model.user.UserProxy;
import domain.model.user.data.UserFinder;

public class UserInputMapper {

	private static UserIdentityMap umap = new UserIdentityMap();
	private static boolean loadedAll = false;


	public static User find(Long id) throws SQLException, DomainObjectNotFoundException
	{
		User u = umap.get(id);

		if(u == null)
		{
			ResultSet rs = UserFinder.find(id);	

			if(rs.next())
			{	
				//The constructor = User(int id, String fn, String ln, String un, String pw)
				//u = new User(rs.getInt("u.userid"), rs.getInt("u.groupid"), rs.getString("u.firstname"), rs.getString("u.lastname"), rs.getString("u.username"), rs.getString("u.password"), rs.getBoolean("u.admin"), rs.getInt("u.version"));
				u = getUser(rs);
			}
			else
			{
				throw new DomainObjectNotFoundException("Cannot find a user with id " + id);
			}
			rs.close();

		}

		return u;
	}

	public static List<User> findAll() throws SQLException
	{
		List<User> userlist = null;

		if(!loadedAll)
		{

			ResultSet rs = UserFinder.findAll();
			userlist = new ArrayList<User>();
			//User u = null;

			//This while adds users to the list
			while(rs.next())
			{
				//u = new User(rs.getInt("u.userid"), rs.getInt("u.groupid"), rs.getString("u.firstname"), rs.getString("u.lastname"), rs.getString("u.username"), rs.getString("u.password"), rs.getBoolean("u.admin"), rs.getInt("u.version"));	
				//userlist.add(u);
				userlist.add(getUser(rs));
			}
			rs.close();
			loadedAll = true;
		}
		else
		{
			userlist = umap.getAll();
		}

		return userlist;
	} 

	// TODO: make sure this is not inefficient (e.g. it might be better to pull all the records from DB at once)
	public static List<IUser> findGroupMembers(long groupid) throws SQLException
	{
		ResultSet rs = UserFinder.findGroupMembers(groupid);
		List<IUser> uList = new ArrayList<IUser>();
		
		while(rs.next())
		{
			uList.add( new UserProxy( rs.getLong("u.userid")) );
		}
		
		return uList;
	}

	private static User getUser(ResultSet rs) throws SQLException {
		//public User(long id, long gid, String fn, String ln, int per, long version)
		
		IPerson per = new PersonProxy(rs.getLong("u.person"));
		IGroup gr = new GroupProxy(rs.getLong("u.groupid"));
		
		User result = UserFactory.createClean(
				rs.getLong("u.userid"),
				rs.getLong("u.version"),
				gr,
				rs.getString("u.firstname"),
				rs.getString("u.lastname"),
				per
				
				);

		//Checks to see if the person isn't already in the identity map first...
		if(umap.get(result.getId()) == null)
			umap.put(result.getId(), result);

		return result;
	}
	

}