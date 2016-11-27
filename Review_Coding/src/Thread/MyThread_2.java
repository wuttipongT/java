package Thread;

public class MyThread_2 implements Runnable {

	MyThread_2(){
		Thread t = new Thread(this);
		t.start();
		System.out.println("I am doing something here!");
	}
	public void run() {
		// TODO Auto-generated method stub
		int count = 0;
		while (count <= 10){
			System.out.println("This in a Thread :"+(count++));
			try {Thread.sleep(100);}
			catch (InterruptedException e){}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread_2();
	}

}
