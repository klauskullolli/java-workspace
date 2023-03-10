package ushtrime;

import java.util.Scanner;
public class Ex_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int score , max_score , nr  ; 
		String  name  , max_name ;
		System.out.print("Enter number of students: ");
		nr=input.nextInt() ;
		System.out.print("Enter name and score :  ");
		max_name=input.next() ;
		max_score = input.nextInt() ;
		for (int i=1 ; i<nr ; i++ ) {
			System.out.print("Enter name and score :  ");
			name=input.next() ;
			score = input.nextInt() ;
			if(score>max_score) {
				max_name=name ;
				max_score=score ;
			}
		}
		System.out.println(max_name+ " " + max_score);
		input.close(); 
	}

}
