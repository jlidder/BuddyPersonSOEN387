package domain.model.user.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsrg.soenea.service.logging.SQLLogger;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class UserTDG 
{
	public static final String BASE_NAME = "users";
	public static final String TABLE = BASE_NAME;
	public static final String UPDATE = "UPDATE " + TABLE + " AS u SET u.version=u.version+1, u.groupid=?, u.firstname=?, u.lastname=?,u.person=? WHERE u.userid=? AND u.version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE userid=? AND version=?;";
	public static final String INSERT = "INSERT INTO " + TABLE + " (version,groupid,firstname,lastname,person) VALUES (?,?,?,?,?);";
	public static final String MAXID = "SELECT MAX(userid) FROM " + TABLE;
	
	public static String CREATE_SQL = 
			 "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
					 "userid INT NOT NULL AUTO_INCREMENT," +
					 "version INT," +
					 "groupid INT NOT NULL," +
					 "firstname VARCHAR(50)," + 
					 "lastname VARCHAR(50)," +
					 "person INT," +
					 "PRIMARY KEY (userid)," +
					 "FOREIGN KEY (person) REFERENCES person(id)" +
			 ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	
	public static String DROP_SQL = 
			"DROP TABLE " + TABLE + ";";
	
	public static void createTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), CREATE_SQL);
	}
	
	public static void dropTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), DROP_SQL);
	}
	
	/*
	 * Returns userid key generated from DB.
	 */
	public static int insert(long groupid, String firstname, String lastname, long person) throws SQLException 
	{
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setInt(1, 1);//version always inserted @ 1
		ps.setLong(2, groupid);	
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.setLong(5, person);
	
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}

	public static int update(long userid, long version, long groupid, String firstname, String lastname, long person) throws SQLException
	{

		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		// AS u SET u.version=u.version+1, u.groupid=?, u.firstname=?, u.lastname=?,u.person=? WHERE u.userid=? AND u.version=?;"
		ps.setLong(1, groupid);	
		ps.setString(2, firstname);
		ps.setString(3, lastname);
		ps.setLong(4, person);
		ps.setLong(5, userid);
		ps.setLong(6, version);
		
		int count = ps.executeUpdate();
		ps.close();
		
		return count;	
		
	}

	public static int delete(long userid, long version) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
		
		ps.setLong(1, userid);
		ps.setLong(2, version);
		int count = ps.executeUpdate();
		ps.close();
		
		return count;		
	}

	public static long getMaxID() throws SQLException
	{	
		long maxID = 0;
		Statement statement = DbRegistry.getDbConnection().createStatement();
		statement.execute(MAXID);    
		ResultSet rs = statement.getResultSet(); 
		
		if (rs.next()) 
			  maxID = rs.getLong(1);
		
		return maxID;
	}
	
}
