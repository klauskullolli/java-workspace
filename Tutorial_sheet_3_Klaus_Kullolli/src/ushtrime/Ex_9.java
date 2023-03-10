package ushtrime;
import java.util.Scanner ;
public class Ex_9 {

	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		System.out.print("Enter a number:");
		int nr = input.nextInt() ;
		for (int i=1 ; i<= nr; i++) {
			for(int j=1; j<=i ; j++)
			   System.out.print("[]");
			System.out.println();
			
		}
	}

}
