package Thread;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class L1_MovingCircle extends JFrame implements Runnable {

	int i = 0;
	int x = 0, y = 70, fw = 300 , fh = 200;
	Thread t = new Thread(this);
	int step = 5;
	L1_MovingCircle(){
		setTitle("MovingCircle");
		setBackground(Color.black);
		setForeground(Color.red);
		t.start();
		setSize(fw,fh);
		setVisible(true);
	}
	public void paint(Graphics g){
		super.paintComponents(g);
		g.fillOval(x, y, 90, 90);
		x += step;
		if(x<0||x>fw-90)step = -step;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{Thread.sleep(100);}
			catch(Exception e){}
			repaint();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new L1_MovingCircle();
	}

}
