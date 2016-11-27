package JUNTRA.maingame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowScore extends JFrame{
	JLabel lb=new JLabel();
	ImageIcon icon=new ImageIcon("images/score3.jpg");
	JTextArea lb2=new JTextArea();
	ReadAndWriteFile read=new ReadAndWriteFile();
	public ShowScore() {
		setLayout(null);
		setSize(1004,541);
		lb.setBounds(0, 0, 1020, 527);
		lb.setIcon(icon);
		lb2.setBounds(160, 100, 600, 330);
		lb2.setOpaque(true);
		lb2.setFont(new Font(Font.SERIF,Font.BOLD,25));
		lb2.setForeground(new Color(109,41,41));
		lb2.setBackground(new Color(10,10,7,30));
		read.readFile(lb2);//อ่านข้อมูล
		lb.add(lb2);
		add(lb);
		setAlwaysOnTop(true);
		setLocation(10, 12);
		setResizable(false);
		getContentPane().setBackground(Color.black);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}