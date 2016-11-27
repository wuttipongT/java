package Thread;

import javax.swing.JButton;

public class SimpleThread extends Thread implements Runnable{

	private int countDown = 5;
	private int threadNumber;
	private static int threadCount = 0;
	public SimpleThread(){
		threadNumber = ++threadCount;
		System.out.println("Create Thread : "+threadNumber);
	}
	public void run(){
		while(true){
			System.out.println("Thread :"+threadNumber);
			if(--countDown == 0)return;
			try{sleep(1000);}
			catch(InterruptedException e){}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread myThread[] = new Thread[5];
		SimpleThread t[] = new SimpleThread[5];
		for (int i = 0; i < 5; i++) {
			t[i] = new SimpleThread();
			myThread[i] = new Thread(t[i]);
			myThread[i].start();
			JButton b[] =new  JButton[4];
		}
	}

}
