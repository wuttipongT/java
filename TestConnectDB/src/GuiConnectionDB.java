import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class GuiConnectionDB extends JFrame {

	public GuiConnectionDB() {
		// TODO Auto-generated constructor stub
		initComponents();
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
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
	static ResultSetMetaData crateResultSetMetaData(Connection conn,ResultSet r,String sql){
		Statement s = null;
		ResultSetMetaData rsmd = null;
		try {
			s = conn.createStatement();
			r = s.executeQuery(sql);
			rsmd = r.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsmd;
	}
	static ResultSet createResultSet(Connection conn ,String sql){
		ResultSet r = null;
		Statement statement = null;
		try {
			statement = conn.createStatement();
			r = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	void initComponents(){
		Connection conn = createConnection("USERXP-6E5809C6", "sa", "narak");
	//	if(conn != null)//System.out.println("Connection Successfull!!");
		String sql = "select * from DEPARTMENT";
		
		String columName [] = {"did"};
		Object data [][] = {{"100","it"},{"200","s"}};
		
		JTable dataTable = new JTable();
		ResultSet r = createResultSet(conn, sql);
		
		ResultSetMetaData rsmd = crateResultSetMetaData(conn, r, sql);
		int index = 0;
		try {
			ResultSetMetaData rsdm = r.getMetaData();
			dataTable.setModel((TableModel) rsmd);
			add(dataTable);
			int numberOfColum = rsmd.getColumnCount();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GuiConnectionDB();
	}

}
