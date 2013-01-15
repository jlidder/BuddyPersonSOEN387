package domain.model.invite.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.model.person.data.PersonTDG;

public class InviteFinder 
{
	public static final String SELECT = "SELECT  i.id, i.version, i.userid, i.groupid FROM " + InviteTDG.TABLE + " AS i WHERE i.id;";
	public static final String SELECT_WITH_USER_GROUP = "SELECT  i.id, i.version, i.userid, i.groupid FROM " + InviteTDG.TABLE + " AS i WHERE i.userid=? AND i.groupid=?;";
	public static final String SELECT_ALL = "SELECT i.id, i.version, i.userid, i.groupid FROM " + InviteTDG.TABLE + " AS i;";
	public static final String MAXID = "SELECT MAX(groupid) AS maxid FROM "+ InviteTDG.TABLE +";";
	
	public static ResultSet find(long id) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		return rs;
	}
	
	public static ResultSet find(long userid, long groupid) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_WITH_USER_GROUP);
		
		ps.setLong(1, userid);
		ps.setLong(2, groupid);
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
}
