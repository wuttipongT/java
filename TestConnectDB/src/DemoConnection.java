import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DemoConnection extends JFrame {
	DemoConnection() {
		
		Connection conn = createConnection("yajok_server","user1_yajok","password");
		if (conn != null){
			JOptionPane.showMessageDialog(this,"Connection sucessful!");
			try {
				String sql = "SELECT * FROM DEPARTMENT";
				Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = statement.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				int num = rsmd.getColumnCount();
				for (int i = 0; i < num; i++) {
					System.out.printf("%-8s\t",rsmd.getColumnName(i));
				}
				//PreparedStatement pstat = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				//DatabaseMetaData dbmd = conn.getMetaData();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else JOptionPane.showMessageDialog(this, "Connot make Connection");
		
		setSize(500,500);
		setTitle("DemoConnection");
		setLocation(500,50);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	static Connection createConnection(String server,String user,String password){
		Connection conn = null;
		
		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://"+server+":1433";
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DemoConnection();
	}

}
