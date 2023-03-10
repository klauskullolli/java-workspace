import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculate  {
  
	private float sum ;
	Lock lock = new ReentrantLock() ;
	public Calculate() {
	
		sum =0 ; 
		
	}
	
	public void calculate_sum (int start , int end) {
		int psum = 0 ; 
		for (int i= start ; i<=end ; i++) {
			psum = psum + i ;
		}
		
		    lock.lock();
			
			sum = sum + psum ;
			lock.unlock();
			
		
		
	}

	public float getSum() {
		return sum;
	}

	
}
