package Thread;

public class MyThread_1 extends Thread {
	MyThread_1(){
		Thread t = new MyThread_1();
		t.start();
		System.out.println("I'm doing something here");
	}
	public void run() {
		int count=0;
		while(count <=10){
			System.out.println("This is in a thread : "+ (count++));
			try {Thread.sleep(100);}
		catch (InterruptedException e) {}
		}
	}
	public static void main(String[] args) {
		new MyThread_1();
	}
}
