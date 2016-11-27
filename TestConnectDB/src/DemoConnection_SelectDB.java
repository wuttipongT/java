import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;


public class DemoConnection_SelectDB extends JFrame{
	
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
	static ResultSet selectData(Connection conn,String sql){
		ResultSet r = null;
		Statement s = null;
		try {
			s = conn.createStatement();
			r = s.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	static void displatDataDetail(ResultSet r){
		int id = 0 ;
		String name ="";
		int count = 1;
			try {

				while (r.next()) {
					id = r.getInt("did");
					name = r.getString("name");
					System.out.println("\t"+id+"\t"+name);
				}System.out.println("\n Ther are "+count+"Racode !");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = crateConnection("yajok_server", "user1_yajok", "password");
		if (conn!=null)System.out.println("Connection Successfull!");
		String value = "select * from DEPARTMENT";
		ResultSet r = selectData(conn, value);
		if(r!=null){
			displatDataDetail(r);
		}
	}

}
