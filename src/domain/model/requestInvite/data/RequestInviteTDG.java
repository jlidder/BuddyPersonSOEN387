package domain.model.requestInvite.data;

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.SoenEAConnection;
import org.dsrg.soenea.service.logging.SQLLogger;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class RequestInviteTDG {

	public static final String BASE_NAME = "requestInvite";
	public static final String TABLE = BASE_NAME;
	public static final String UPDATE = "UPDATE " + TABLE + " AS i set i.version=i.version+1, i.groupid=?, i.userid=? WHERE i.groupid=? AND i.userid=? AND i.version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE version=? AND userid=? AND groupid=?;";
	public static final String INSERT = "INSERT INTO " + TABLE + " (version,userid,groupid) VALUES (?,?,?);";

	public static String CREATE_SQL = 
			 "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
					 "version INT," +	
					 "userid INT," +
					 "groupid INT," +
					 "PRIMARY KEY (userid, groupid)," +
					 "FOREIGN KEY (userid) REFERENCES users(userid)," +
					 "FOREIGN KEY (groupid) REFERENCES groups(groupid)" +
			 ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	
	public static String DROP_SQL = 
			"DROP TABLE " + TABLE + ";";
	
	public static void createTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), CREATE_SQL);
	}
	
	public static void dropTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), DROP_SQL);
	}
	
	public static int insert(long userid, long groupid) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		
		ps.setInt(1, 1);//version always inserted @ 1
		ps.setLong(2, userid);
		ps.setLong(3, groupid);	 //groupid is the group that the user WISHES to enter
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}

	public static int delete(long version, long userid, long groupid) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
		
		ps.setLong(1, version);
		ps.setLong(2, userid);
		ps.setLong(3, groupid);
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}
	
}
