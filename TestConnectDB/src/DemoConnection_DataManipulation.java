import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DemoConnection_DataManipulation {

	static Connection createConnection(String server,String user,String password){
		Connection conn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://"+server+":1433";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	static void insertData(Connection conn,String sql){
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(sql);
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void dataManipulation(Connection conn,String sql){
		Statement s;
		try {
			s = conn.createStatement();
			int n = s.executeUpdate(sql);
			System.out.println("Ther are "+n+" records affected");
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = createConnection("USERXP-6E5809C6", "sa", "narak");
		if (conn!=null) {
			System.out.println("Connection Successful");
		}
		String deleteData = "delete from DEPARTMENT where did = 100";
		String updateData = "update EMPLOYEE set name = 'jim' where name = 'new jim'";
		dataManipulation(conn, deleteData);
		dataManipulation(conn, updateData);
	}

}
