package domain.model.group.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.user.data.UserTDG;

public class GroupFinder 
{
	public static final String SELECT = "SELECT g.groupid, g.version, g.name, g.description FROM " + GroupTDG.TABLE + " AS g WHERE g.groupid=?;";
	public static final String SELECT_ALL = "SELECT g.groupid, g.version, g.name, g.description FROM " + GroupTDG.TABLE + " AS g;";
	public static final String SELECT_MEMBERS_GROUP = "SELECT g.groupid FROM " + GroupTDG.TABLE + " AS g WHERE g.userid=?;";
	public static final String MAXID = "SELECT MAX(groupid) AS maxid from groups;";
	
	public static ResultSet find(long id) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		return rs;	
	}

	public static ResultSet findAll() throws SQLException
	{
			PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
		
			return rs;	
	}
	
	public static long getMaxId() throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(MAXID);
		ResultSet rs = ps.executeQuery();
	
		long maxid = -1;
		if(rs.next())
		{
			maxid = rs.getLong("maxid");
		}
		return maxid;
	}
	
	public static ResultSet findGroupMembers(long userid) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_MEMBERS_GROUP);
		ps.setLong(1, userid);
		ResultSet rs = ps.executeQuery();
		return rs;		
	}

}
