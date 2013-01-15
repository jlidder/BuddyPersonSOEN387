package domain.model.group.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;

import domain.model.group.Group;
import domain.model.group.GroupFactory;
import domain.model.group.GroupProxy;
import domain.model.group.IGroup;
import domain.model.group.data.GroupFinder;
import domain.model.person.Person;
import domain.model.user.IUser;
import domain.model.user.UserProxy;
import domain.model.user.data.UserFinder;


public class GroupInputMapper {

	private static GroupIdentityMap gmap = new GroupIdentityMap();
	private static boolean loadedAll = false;

	public static Group find(long id) throws SQLException, DomainObjectNotFoundException
	{
		Group grp = gmap.get(id);

		if(grp == null)
		{

			ResultSet rs = GroupFinder.find(id);	
	
			if(rs.next())
			{
				grp = getGroup(rs);
				//System.out.println("NAME:"+rs.getString("g.name"));
				//System.out.println("Desc:"+rs.getString("g.description"));
				//System.out.println("version:"+rs.getInt("g.version"));
				//System.out.println("version from group:"+ g.getVersion());
			}
			else
			{
				throw new DomainObjectNotFoundException("Cannot find a group with id " + id);
			}
			rs.close();
		}
		return grp;
	}
	
	private static Group getGroup(ResultSet rs) throws SQLException, DomainObjectNotFoundException  
	{
		Group g = GroupFactory.createClean(rs.getLong("g.groupid"), rs.getInt("g.version"), rs.getString("g.name"), rs.getString("g.description"));
		
		if(gmap.get(g.getId()) == null)
			gmap.put(g.getId(), g);
		
		return g;
	}
	
	
	public static List<Group> findAll() throws SQLException, DomainObjectNotFoundException
	{
		List<Group> groupList = null;

		if(!loadedAll)
		{
			ResultSet rs = GroupFinder.findAll();
			groupList = new ArrayList<Group>();


			//This while adds groups to the list
			while(rs.next())
			{
				Group grp22 = getGroup(rs);
				groupList.add(grp22);
			}
			rs.close();
			loadedAll = true;
		}
		else
		{
			groupList = gmap.getAll();
		}
		
			return groupList;
		} 
	
	public static long getMaxId() throws SQLException
	{
		return GroupFinder.getMaxId();
	}
	
	public static List<IGroup> findGroupMembers(long userid) throws SQLException
	{
		ResultSet rs = GroupFinder.findGroupMembers(userid);
		List<IGroup> gList = new ArrayList<IGroup>();
		
		while(rs.next())
		{
			gList.add( new GroupProxy( rs.getLong("g.groupid")) );
		}
		
		return gList;
	}
	
	}
	
