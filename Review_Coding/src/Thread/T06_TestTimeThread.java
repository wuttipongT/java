package Thread;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T06_TestTimeThread extends JFrame implements ActionListener{
 int n = 4;
 JButton b[] =new JButton[n];
 TimeThread timeThread[] = new TimeThread[n];
 boolean run[] = new boolean[n];
 Color defaultColor;
 T06_TestTimeThread(){
	 setLayout(new GridLayout(2,2));
	 for (int i = 0; i < b.length; i++) {
		b[i] = new JButton();
		add(b[i]);
		b[i].addActionListener(this);
	}
	 defaultColor = b[0].getBackground();
 }
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stu
		Object source = e.getSource();
		for (int i = 0; i < b.length; i++) {
			if(source == b[i]){
				if(!run[i]){
					timeThread[i] = new TimeThread(b[i]);
					timeThread[i].start();
					run[i]=!run[i];
					b[i].setBackground(defaultColor);
				}else {
					timeThread[i].setStart(false);
					run[i]=!run[i];
					b[i].setBackground(Color.gray);
				}
			}
		}
	}
	public static void main(String []args){
		T06_TestTimeThread gui = new T06_TestTimeThread();
		gui.setSize(200,200);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
