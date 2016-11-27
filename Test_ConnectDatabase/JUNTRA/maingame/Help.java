package JUNTRA.maingame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame {
	JLabel lb=new JLabel();
	ImageIcon icon=new ImageIcon("help/Help.jpg");
	JLabel data=new JLabel();
	public void createHelp(){
		setLayout(null);
		setSize(1004,541);
		lb.setBounds(0, 0, 1004, 521);
		lb.setIcon(icon);
		add(lb);
		setAlwaysOnTop(true);
		setLocation(10, 12);
		setResizable(false);
		getContentPane().setBackground(Color.black);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void readfile(){}
}
