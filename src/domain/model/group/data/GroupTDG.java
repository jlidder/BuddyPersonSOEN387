package domain.model.group.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dsrg.soenea.service.SoenEAConnection;
import org.dsrg.soenea.service.logging.SQLLogger;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class GroupTDG 
{
	public static final String BASE_NAME = "groups";
	public static final String TABLE = BASE_NAME;
	public static final String UPDATE = "UPDATE " + TABLE + " AS g set g.version=g.version+1, g.name=?, g.description=? WHERE g.groupid=? AND g.version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE groupid=? AND version=?;";
	public static final String INSERT = "INSERT INTO " + TABLE + " (version,name,description) VALUES (?,?,?);";

	public static String CREATE_SQL = 
			 "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
					 "groupid INT NOT NULL AUTO_INCREMENT," +
					 "version INT," +
					 "name VARCHAR(50)," +
					 "description VARCHAR(200)," +
					 "PRIMARY KEY (groupid)" +
			 ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	
	public static String DROP_SQL = 
			"DROP TABLE " + TABLE + ";";
	
	public static void createTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), CREATE_SQL);
	}
	
	public static void dropTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), DROP_SQL);
	}
	

	public static int insert(String name, String description) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		
		ps.setInt(1, 1);//version always inserted @ 1
		ps.setString(2, name);
		ps.setString(3, description);	
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}
	
	public static int update(long groupid, String name, String description, long version) throws SQLException 
	{
			PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setLong(3, groupid);	
			ps.setLong(4, version);
			int count = ps.executeUpdate();
			ps.close();
			
			return count;			 
	}
	
	public static int delete(long groupid, long version) throws SQLException
	{
			PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
			
			//DEBUG
			System.out.println("Version:"+version);
			System.out.println("group in tdg:"+groupid);
			
			ps.setLong(1, groupid);
			ps.setLong(2, version);
			int count = ps.executeUpdate();
			ps.close();
			
			return count;		
	}
}
