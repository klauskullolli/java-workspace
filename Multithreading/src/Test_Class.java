import java.util.ArrayList;
import java.util.Scanner;





public class Test_Class {
    
	public static int last = 10 ;
	
	public static void main(String[] args) {
	
		int threads  ;
		Calculate calculate = new Calculate() ;
		Scanner inputScanner = new Scanner(System.in) ;
		threads = inputScanner.nextInt() ;
		Thread[] ths = new Thread[threads] ;
		
		int iter = last / threads ;
		int remain = last% threads ;
		
		for (int i =0 ; i<threads ; i++)
		{    int start ,end ;
			 start = i*iter +1  ;
			if(i==threads-1) {
				end = i*iter + iter + remain ;			}
			else {
				end = i*iter + iter ;
			}
			
			ths[i] = new Thread(() -> {
				calculate.calculate_sum(start, end);
			}) ;
		}
		
		for (Thread e : ths) {
			e.start();
		}
	
		
		for (Thread e : ths) {
			try {
				e.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		System.out.println(calculate.getSum());
	}

}
