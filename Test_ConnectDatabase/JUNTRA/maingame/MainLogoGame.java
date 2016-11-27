package JUNTRA.maingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainLogoGame extends JPanel implements MouseListener,MouseMotionListener{
	Main_JuntraGame main;
	int w;
	int h;
	int x;
	int y;
	int imw=128,imh=128;
	Toolkit tk=Toolkit.getDefaultToolkit();
	Image image;
	
	JLabel button[]=new JLabel[4];
	ImageIcon icon1[]=new ImageIcon[4];
	ImageIcon icon2[]=new ImageIcon[4];
	ImageIcon icon;
	boolean checkclick[]=new boolean[4];
	JLabel tool[]=new JLabel[2];
	
	public MainLogoGame(Main_JuntraGame main) {
		this.main=main;
		w=this.main.getWidth();
		h=this.main.getHeight();
		createIcon();
		main.add(this);
	}
	public void createIcon(){
		setLayout(null);
		for(int i=0;i<icon1.length;i++){
			icon1[i]=new ImageIcon("buttongame/button"+(i+1)+".png");
			icon2[i]=new ImageIcon("buttongame/button_"+(i+1)+".png");
		}
		button[0]=new JLabel(icon1[0]);
		button[0].setBounds(250, 350, imw, imh);
	
		button[1]=new JLabel(icon1[1]);
		button[1].setBounds(650, 350, imw, imh);
		
		button[2]=new JLabel(icon1[2]);
		button[2].setBounds(350, 500, imw, imh);
		
		button[3]=new JLabel(icon1[3]);
		button[3].setBounds(550, 500, imw, imh);
		
		for(int i=0;i<button.length;i++){
			button[i].addMouseListener(this);
			button[i].addMouseMotionListener(this);
			add(button[i]);
		}
		String tooltip[]={"NEW GAME","EXIT"};

		for(int i=0;i<tool.length;i++){
			tool[i]=new JLabel(""+tooltip[i]);
			tool[i].setForeground(Color.YELLOW);
			tool[i].setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
			add(tool[i]);
		}
		tool[0].setBounds(260, 320+imw, 200,100);
		tool[1].setBounds(690, 320+imw, 200,100);
		
		setFocusable(true);
		setBounds(x, y, w, h);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		image=tk.getImage("logogame/Logo4.jpg");
		g.drawImage(image, x, y, w, h, this);
	}

	public void mouseMoved(MouseEvent e) {
		Object sorce=e.getSource();
		for(int i=0;i<button.length;i++){
			if(sorce==button[i]){
				button[i].setIcon(icon2[i]);
				break;
			}
		}
	}
	public void mouseExited(MouseEvent e) {
		Object sorce=e.getSource();
		for(int i=0;i<button.length;i++){
			if(sorce==button[i]){
				button[i].setIcon(icon1[i]);
				break;
			}
		}
	}
	public void mousePressed(MouseEvent e){
		Object sorce=e.getSource();
		if(sorce==button[0]){
			main.remove(this);
			main.createNewgame();
		}
		else if(sorce==button[1]){System.exit(0);}
		else if(sorce==button[2]){}
		else if(sorce==button[3]){}
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent arg0){}
	public void mouseReleased(MouseEvent arg0){}
	public void mouseDragged(MouseEvent arg0){}

}
