package domain.model.person.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;


public class PersonFinder {

	public static final String SELECT = "SELECT p.id, p.version, p.username, p.password, p.role FROM " + PersonTDG.TABLE + " AS p WHERE p.id=?;";
	public static final String SELECT_ALL = "SELECT p.id, p.version, p.username, p.password, p.role FROM " + PersonTDG.TABLE + " AS p;";
	public static final String MAXID = "SELECT MAX(groupid) AS maxid FROM "+ PersonTDG.TABLE +";";
	
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
	
}
