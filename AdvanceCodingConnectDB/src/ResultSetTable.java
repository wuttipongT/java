import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
public class ResultSetTable extends JFrame implements ActionListener {

	JTable dataTable;
	JComboBox tableList;
	Connection conn;
	DatabaseMetaData md;
	Statement statement;
	ResultSetTable(){
		makeConnection();
		initComponents();
		initFrame();
	}
	private void makeConnection(){
		conn = MySQL2005Connection.crateConnection("YAJOK_SERVER","user1_yajok","password");
		if(conn != null) System.out.println("connection success");
		statement = MySQL2005Connection.createStatement(conn,true,true);
		md = MySQL2005Connection.getMetaData(conn);
	}
	void initComponents(){
		Vector<String> table = MySQL2005Connection.getTables(md); //ดู table ทั้งหมดใน database
		tableList = new JComboBox(table); //แสดงชื่อ table ที่ได้ใน combobox
		tableList.addActionListener(this);
		add(tableList, BorderLayout.NORTH);
		dataTable = new JTable();
		JScrollPane pane = new JScrollPane(dataTable);
		add(pane, BorderLayout.CENTER);
	}
	void initFrame(){
		setSize(400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== tableList){ // เมื่อเปลี่ยน table ที่ต้องการแสดงข้อมูล
			String currentTable = (String)tableList.getSelectedItem();
			String query = "select * from "+ currentTable; // เพื่อดูข้อมูลใน table ที่เลือก
			try {
				ResultSet rs = statement.executeQuery(query);
				ResultSetTableModel model = new ResultSetTableModel(rs);
				dataTable.setModel(model); //กำหนด model ให้กับ JTable
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new ResultSetTable();
	}
}