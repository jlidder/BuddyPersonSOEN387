package domain.model.person.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsrg.soenea.service.logging.SQLLogger;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class PersonTDG {

	public static final String BASE_NAME = "person";
	public static final String TABLE = BASE_NAME;
	public static final String UPDATE = "UPDATE " + TABLE + " AS p SET p.version=p.version+1, p.username=?, p.password=?, p.role=? WHERE p.id=? AND p.version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE id=? AND version=?;";
	public static final String INSERT = "INSERT INTO " + TABLE + " (version,username,password,role) VALUES (?,?,?,?);";
	public static final String MAXID = "SELECT MAX(id) FROM " + TABLE;
	
	public static String CREATE_SQL = 
			 "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
					 "id INT NOT NULL AUTO_INCREMENT," +
					 "version INT," +
					 "username VARCHAR(50) UNIQUE," + 
					 "password VARCHAR(50)," +
					 "role INT," +
					 "PRIMARY KEY (id)," +
					 "FOREIGN KEY (role) REFERENCES roles(id)" +
			 ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	
	public static String DROP_SQL = 
			"DROP TABLE " + TABLE + ";";
	
	public static void createTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), CREATE_SQL);
	}
	
	public static void dropTable() throws SQLException {
		SQLLogger.processUpdate(DbRegistry.getDbConnection().createStatement(), DROP_SQL);
	}
	

	public static int insert(long version, String username, String password, long role) throws SQLException 
	{
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, 1);	
		ps.setString(2, username);
		ps.setString(3, password);
		ps.setLong(4, role);
		
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}

	public static int update(long id, long version, String username, String password, long role) throws SQLException
	{
		//p.version=p.version+1, p.username=?, p.password=?, p.role=? WHERE p.id=? AND p.version=?;"
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setLong(3, role);
		ps.setLong(4, id);	
		ps.setLong(5, version);
		
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
