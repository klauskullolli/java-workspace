import java.util.Scanner;

public class Camelot {
    
	
	public static void can_sit(int [][]arr) {
		int n = arr.length ; 
		
		int c= 1 ;
		for (int i=0 ; i<n ; i++) {
			for(int j = 0 ; j<n ;j++) {
				if(arr[i][j]!=arr[j][i]) {
					c=0 ;
					break ;
				}
			}
		}
		
		if(c==1) System.out.println("YES");
		else System.out.println("NO");
	}
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		int a  = input.nextInt() ;
		
		int [][] arr = new int [a][a] ;
		
		for (int i=0 ; i<a ; i++) {
			for(int j = 0 ; j<a ;j++) {
				arr[i][j] = input.nextInt() ;
			}
		}
		
		can_sit(arr) ;
		

	}

}
