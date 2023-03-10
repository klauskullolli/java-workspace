package Problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// This is the main class where the program is executed
public class PropabilityEstimation {
    public static void main(String[] args) {
    	
    	//use for input the scanner object
        Scanner input  = new Scanner(System.in);
        
        //Create a list of string from split first line input because all necessary input are given 
        // within the first line 
        String[] str  = input.nextLine().split(" ") ;
        
        //These are choices input from user 
        ArrayList <String> patterns = new ArrayList<>(Arrays.asList(str[0] , str[1])) ;
        int repetation = Integer.parseInt(str[2]) ;
        int nr_thread = Integer.parseInt(str[3]) ;
        
        //Thread arrays as thread number inputed by user 
        Thread[] threads = new Thread[nr_thread] ;
        
        
        // These are iteration that each thread will cover 
        int iteration = repetation/ nr_thread ; 
        
        //If if the devision has reminder one of thread has to cover additional iteration
        // by adding the reminder
        int remainer = repetation % nr_thread  ;
        RandomCalculator rCalculator = new RandomCalculator() ;
       
        //Word specification for each thread
        for( int i = 0 ; i<nr_thread ; i++ ){
            int start = i* iteration ; 
            int end ; 
            if (i==nr_thread-1)  end = i*iteration + iteration + remainer ;
            else end = i*iteration + iteration ;

            threads[i] = new Thread(() ->{
                rCalculator.randomChoice(start, end);
            }) ;
        }
        

        for( Thread t : threads){
           t.start();
        }

        for( Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }
          //Probabilities of random choices
         float prop1  =  (float) rCalculator.getFirstChoice()/ repetation ;
         float prop2  =  (float) rCalculator.getSecondChoice()/ repetation ;
          
         System.out.println(String.format("Estimated values with %d random experiments with %d threads", repetation , nr_thread));
         System.out.println(String.format("The propability that %s appears first is %f", patterns.get(0) , prop1));
         System.out.println(String.format("The propability that %s appears first is %f", patterns.get(1) , prop2));
           

    }
}