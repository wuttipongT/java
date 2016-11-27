package Thread;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T11_AnoyingBeep extends JFrame implements ActionListener {

	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Timer timer;
	JButton b = new JButton();
	T11_AnoyingBeep(){
		b.addActionListener(this);
		add(b);
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer = new Timer();
		//timer.schedule(new remin)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class RemindTask extends TimerTask{
	int numWarningBeeps = 3;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(numWarningBeeps >0){
			//toolkit.b
		}
	}
	
}
