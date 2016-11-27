import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DemoConnection_Insert {

	static Connection createConnection (String server,String user,String password){
		Connection conn = null;
		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://"+server+":1433";
			Class.forName(driver);
			try {
				conn = DriverManager.getConnection(url,user,password);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane jp = new JOptionPane();
		Connection conn = createConnection("USERXP-6E5809C6", "sa", "narak");
		if (conn == null)System.exit(1);
		else System.out.println("Connection Successful");
		
		//insert data , simple statement
		String insertStatement = "insert into DEPARTMENT values(100,'IT')";
		//insertData(conn,insertStatement);
		System.out.println("Finish");

	}

}
