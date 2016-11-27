import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;



public class TestInsert extends JFrame implements ActionListener {

	JButton ok , Cancel;
	JTextField id,name,lastname,email;
	JLabel label;
	public TestInsert(){
		SetFrame();
		setLayout(null);
		
		label = new JLabel("ID");
		label.setBounds(5, 10, 40, 20);
		add (label);
	
		id = new JTextField();
		id.setBounds(90, 10, 200, 20);
		add(id);
		
		label = new JLabel("Name");
		label.setBounds(4, 40, 40, 20);
		add(label);
		
		name = new JTextField();
		name.setBounds(90, 40, 200, 20);
		add(name);
		
		label =  new JLabel("lastname");
		label.setBounds(5,70,60,20);
		add(label);
		
		lastname = new JTextField();
		lastname.setBounds(90, 70, 200, 20);
		add(lastname);
		
		label = new JLabel("email");
		label.setBounds(5, 100, 60, 20);
		add(label);
		
		email = new JTextField();
		email.setBounds(90, 100, 200, 20);
		add(email);
		
		ok = new JButton("Save");
		ok.setBounds(90, 150, 70, 20);
		add(ok);
		ok.addActionListener(this);
		
		Cancel = new JButton("Cancel");
		Cancel.setBounds(180, 150, 80, 20);
		add(Cancel);
		
	}
	public  void SetFrame(){
		setSize(400,300);
		setTitle("Insert Data");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void SaveDataToDatabase(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=dbstudent.mdb;}";
			Connection conn = DriverManager.getConnection(URL,"10.0.1600","BANG-GAAN-NAA");
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO tbstudent(id,name,lastname,email) VALUES('"+id.getText()+"','"+name.getText()+"','"+lastname.getText()+"','"+email.getText()+"')";			
			stat.executeUpdate(sql);				 
			JOptionPane.showMessageDialog(this, "Save data Success");
			stat.close();
			conn.close();

			id.setText("");
			name.setText("");
			lastname.setText("");
			email.setText("");
			
			//id.setFocusable(isCursorSet());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "ERROR plase check data!!!");
			return;
		} catch (SQLException e) {
			 e.printStackTrace();
			JOptionPane.showMessageDialog(this, "ERROR plase check data!!!");
			return;
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ok ) {
			SaveDataToDatabase();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestInsert();
	}

}
