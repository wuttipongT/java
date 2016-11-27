import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class MySQL2005Connection {
	static Connection crateConnection(String server,String user,String pass){
		Connection conn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://"+server+":1433";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	static Statement createStatement(Connection conn,boolean scrollable,boolean update){
		Statement statement = null;
			try {
				if (scrollable && !update) {
					statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				}else if (scrollable && update) {
					statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				}else {
					statement = conn.createStatement();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return statement;
	}
	static DatabaseMetaData getMetaData(Connection conn){
		DatabaseMetaData md = null;
		try {
			md = conn.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md;
	}
	static Vector getTables(DatabaseMetaData md){
		Vector<String> tableName = new Vector<String>();
		try {
			ResultSet rs = md.getTables(null,null,null,new String[]{"table"});
			while(rs.next()){
				tableName.add(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableName;
	}
}
