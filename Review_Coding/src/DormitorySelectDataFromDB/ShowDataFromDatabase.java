package DormitorySelectDataFromDB;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowDataFromDatabase extends JFrame{

	Connection conn;
	Statement statement;
	DatabaseMetaData dbmd;
	ShowDataFromDatabase(){
		makeConnection();
		initComponents();
		
		//AttibuteTableModel
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void makeConnection(){
		conn = MySQLServerConnection.crateConnection("yajok_server", "user2_yajok", "password");
		if(conn != null)System.out.println("Connection Successfull!");
		statement = MySQLServerConnection.createStatement(conn, true, false);
		dbmd = MySQLServerConnection.getMetaData(conn);
	}
	void initComponents(){
		JTable dataTable = new JTable();
		String sql = "select * from CHECKIN";
		String value = "select room,typeRoom,name,statusDMTR from CHECKIN where room = '101'";
		try {
			
			ResultSet rs = statement.executeQuery(value);
			AttibuteTableModel model = new AttibuteTableModel(rs);
			
			dataTable.setModel(model);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane pane = new JScrollPane(dataTable);
		add(pane,BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ShowDataFromDatabase();
	}

}
