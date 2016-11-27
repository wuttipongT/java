package Thread;

public class MyThread_3 {
	MyThread_3(){
		Thread t = new Thread(){
			public void run(){
				int count = 0;
				while (count != 10){
					System.out.println("This is in a Thread :"+(count++));
					try{Thread.sleep(100);}
					catch (InterruptedException e){}
				}
			}
		};
		t.start();
		System.out.println("I am doing something here!");
	}
	public static void main(String[] args) {
		new MyThread_3();
	}
}
