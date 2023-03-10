

class Square implements Runnable{
	
	int []  num ;   
	Square(int [] num ) throws InterruptedException{
		this.num =  num  ; 
		Thread.sleep(100);
	}
	
	@Override
	public void run() {
		for (int i : num) {
			System.out.println("square: " + Math.pow(i, 2) );
		}
	}
	
	
}



class Cube implements Runnable{
	
	int []  num ;   
	Cube(int [] num ) throws InterruptedException{
		this.num =  num  ; 
		Thread.sleep(100);
	}
	
	@Override
	public void run() {
		for (int i : num) {
			System.out.println("cube: " + Math.pow(i, 3) );
		}
	}
	
	
}


class Sin implements Runnable{
	
	int []  num ;   
	Sin(int [] num ) throws InterruptedException{
		this.num =  num  ; 
		Thread.sleep(100);
	}
	
	@Override
	public void run() {
		for (int i : num) {
			System.out.println("sin: " + Math.sin(i) );
		}
	}
	
	
}



public class Ex_2 {

	public static void main(String[] args) throws InterruptedException {
		
		double start = System.currentTimeMillis() ;
		int num[] = {2,4,6,8,10,12,14,16,18,20} ;
		
		Thread  t1 =  new Thread(new Square(num)) ; 
		t1.start();
		t1.join();
		
		t1 = new Thread(new Cube(num)) ; 
		t1.start();
		t1.join();
		
		t1 = new Thread(new Sin(num)) ; 
		t1.start();
		t1.join();
		
		
		double end = System.currentTimeMillis() ;
		System.out.println("It took: " +  (end - start)/1000.0 + " seconds");
	}

}
