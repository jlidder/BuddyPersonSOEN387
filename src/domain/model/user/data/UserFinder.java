package domain.model.user.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.person.data.PersonTDG;

public class UserFinder 
{
	public static final String SELECT = "SELECT u.userid, u.version, u.groupid, u.firstname, u.lastname, u.person FROM " + UserTDG.TABLE + " AS u WHERE u.userid=?;";
	public static final String SELECT_ALL = "SELECT u.userid, u.version, u.groupid, u.firstname, u.lastname, u.person FROM " + UserTDG.TABLE + " AS u;";
	public static final String SELECT_GROUP_MEMBERS = "SELECT u.userid FROM " + UserTDG.TABLE + " AS u WHERE u.groupid=?;";
	public static final String MAXID = "SELECT MAX(groupid) AS maxid FROM "+ UserTDG.TABLE +";";
	
	public static ResultSet find(Long id) throws SQLException
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

	public static ResultSet findGroupMembers(long groupid) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_GROUP_MEMBERS);
		ps.setLong(1, groupid);
		ResultSet rs = ps.executeQuery();
		return rs;		
	}

}
