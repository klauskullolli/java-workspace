
public class Ex_3 {

	public static void main(String[] args) throws InterruptedException {
		int num[] = {2,4,6,8,10,12,14,16,18,20} ;
		
		double start = System.currentTimeMillis() ;
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i : num) {
					System.out.println("square: " + Math.pow(i, 2) );
				}
			}
		}) ;
		
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i : num) {
					System.out.println("cube: " + Math.pow(i, 3) );
				}
			}
		}) ;

		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i : num) {
					System.out.println("sin: " + Math.sin(i) );
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
		
	}
	
}
