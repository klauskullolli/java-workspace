
public class Ex_1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0 ; i< 10 ; i++) 
					System.out.println("Thread 1 : "  + "a");
			}
		}) ;
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0 ; i< 10 ; i++) 
					System.out.println("Thread 2 : "  + "b");
			}
		}) ;
		
		
		Thread t3 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0 ; i< 10 ; i++) 
					System.out.println("Thread 3 : "  + "1");
			}
		}) ;
		t1.start();
		//Thread.sleep(10);
		t2.start();
	//	Thread.sleep(10);
		t3.start();
		//Thread.sleep(10);
		t1.join();
		t2.join();
		t3.join();
	}

}
