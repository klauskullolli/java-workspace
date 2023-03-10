
public class Ex_4 {
	
	public static int x = 0  ; 
	
	public static synchronized void increment() {
		x++;
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		int  num[] = {2,4,6,8,10,12,14,16,18,20} ;
		
		double start = System.currentTimeMillis() ;
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i : num) {
					System.out.println("square: " + Math.pow(i, 2) );
					increment() ; 
				}
			}
		}) ;
		
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i : num) {
					System.out.println("cube: " + Math.pow(i, 3) );
					increment() ; 
				}
			}
		}) ;

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i : num) {
					System.out.println("sin: " + Math.sin(i) );
					increment() ; 
				}
			}
		}) ;
		
		
		
		//Thread.sleep(100);
		
		t1.start();
		Thread.sleep(100);
		t2.start();
		t3.start() ;
		
		t1.join();
		t2.join();
		t3.join();

		double end = System.currentTimeMillis() ;
		
		System.out.println("It took: " +  (end - start)/1000.0 + " seconds");
		System.out.println("Count is: " + x);
	}

}
