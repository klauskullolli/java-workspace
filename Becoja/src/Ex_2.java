import java.util.Random;

public class Ex_2 {

	public static void main(String[] args) {
	
		double sum =0 ; 
		Random random = new Random();
		for ( int i = 0 ; i<100  ;i++  ) {
			 sum = sum + random.nextInt(21) ; 
		}
		
		System.out.format("%.2f", sum/100) ;

	}

}
