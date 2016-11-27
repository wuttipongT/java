package JButton;

import javax.swing.JButton;
import javax.swing.JFrame;

import JFrame.MyFrame_1;

public class MyButton_1 extends MyFrame_1{
	JButton b;
	private MyButton_1() {
		setLayout(null);
		b = new JButton("Clik Me");
		b.setBounds(50,20,150,50);
		add(b);
		setSize(250,400);
		setLocation(500,50);
		setTitle("My_Button");
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyButton_1();
	}

}
