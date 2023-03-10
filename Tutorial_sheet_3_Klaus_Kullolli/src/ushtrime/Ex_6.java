package ushtrime;

public class Ex_6 {
    
	public static void main(String[] args) {
		long sum = 0;
		int i =0   ;
		
		sum = 0 ; 
        i = 0 ; 
        for(i=0 ; i<=1000 ;i++) {
        	sum=sum+i ;
        }
        
        System.out.println(sum);
		while (i<=1000) {
			i++ ;
			sum=sum+ i ;
		}
		System.out.println(sum);
        sum = 0 ; 
        i = 0 ; 
        do {
        	 sum=sum+i ; i++ ;
        } while (i<=1000) ;
        System.out.println(sum);
	}

}
