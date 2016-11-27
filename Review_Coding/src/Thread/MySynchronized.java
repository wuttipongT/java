package Thread;
class CountNumber{
	int num ;
	public synchronized void count(String thread){
		for (int i = 0; i < 5; i++) {
			System.out.println(thread +":"+num++);
		}
		try{Thread.sleep(100);}
		catch(InterruptedException e){}
	}
}
public class MySynchronized extends Thread {

	CountNumber c;
	MySynchronized(CountNumber c , String n){
		super(n);
		this.c = c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNumber cnt = new CountNumber();
		new MySynchronized(cnt, "A").start();
		new MySynchronized(cnt, "B").start();
	}
	public void run(){
		c.count(getName());
	}

}
