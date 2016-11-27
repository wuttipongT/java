package Thread;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JButton;

public class TimeThread extends Thread {
	boolean start;
	String currentTime;
	JButton b;
	SimpleDateFormat format = new SimpleDateFormat("hh : mm : ss");
	TimeThread(JButton b){
		start = true ;
		this.b = b;
	}
	void setStart(boolean start){
		this.start = start;
	}
	public void run(){
		while (start){
			Date d = new Date();
			currentTime = format.format(d).toString();
			b.setText(currentTime);
		}
	}
}
