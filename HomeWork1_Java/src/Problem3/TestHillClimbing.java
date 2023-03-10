package Problem3;

import java.util.Random;
import java.util.Scanner;


//This is the main class where the Random restart and climbing hill algorithms are putted in work togather 
// by using threads 
public class TestHillClimbing {
    public static void main(String[] args) {
        double minx , maxX , miny, maxY , stepSize ;
        int nr_threads ; 
        
        //use scanner for inputs and user input all necessary variables to perform algorithms
        Scanner input  = new Scanner( System.in) ;
        System.out.print("Enter minx: "); 
        minx =input.nextDouble() ; 
        System.out.print("Enter maxX: "); 
        maxX =input.nextDouble() ; 
        System.out.print("Enter miny: "); 
        miny =input.nextDouble() ; 
        System.out.print("Enter maxY: "); 
        maxY =input.nextDouble() ; 
        System.out.print("Enter stepSize: "); 
        stepSize =input.nextDouble() ; 
        System.out.print("Enter number of threads: ");
        nr_threads = input.nextInt();
        
        //Array of thread with number = to nr_threads inputed form user 
        Thread[] threads = new Thread[nr_threads] ;
        HillClimbing randomClimbing = new HillClimbing(minx, maxX, miny, maxY, stepSize) ;
        
        
        for(int i =0 ; i< nr_threads ; i++){
                threads[i] = new Thread( ()->{
                //For each thread 2 random starting point between boundaries are randomized		
                double x = (Math.random()*(maxX - minx +1 )) + minx ;
                double y =  (Math.random()*(maxY - miny +1 )) + miny ;
                //Hill Climbing algorithm is performed
                randomClimbing.calculateBestState(x, y);
            }) ;

        }

        for(Thread th : threads){
            th.start();
        }

        for(Thread th : threads){
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(String.format("Value is approximately: %.3f for x= %.3f and y= %.03f ",randomClimbing.getState().getValue(), randomClimbing.getState().getX() , randomClimbing.getState().getY()));


    }
}
