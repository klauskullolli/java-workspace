package Question2;


import java.util.Scanner;



import ArrayQueue.ArrayQueue;
import LinkedQueue.Queue;

public class Solver {

	public static void main(String[] args) {

		// queue is needed to perform other action of exercise
		Queue<String>  q1 = new ArrayQueue<>();



		Scanner input = new Scanner(System.in) ;
		
		
		int a ;
		
		
		while (true) {
			
			//input number to see what action is needed to be done in the queue
			a = input.nextInt() ;
			try {
				
				
				// with number 1 we just add into the queue 
				if(a==1) q1.enqueue(input.next());
				else if (a==0){
					System.out.println(q1.first());
					
				}
				
				//with number -1 we remove from the queue
				else if(a==-1) {
					q1.dequeue() ;
				}
				
				// break the loop and print the queue 
				else if (a==-2) {
					System.out.println(q1);
					break ;
				}
			}
			
			// if something went wrong 
			catch (Exception e) {
				System.out.println("Error in input");
			}
		}
         
		input.close();


	}

}
