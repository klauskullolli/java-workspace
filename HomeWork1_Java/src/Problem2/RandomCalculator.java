package Problem2;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//This is the class that handle the work of calculating 
public class RandomCalculator {

    private int firstChoice ; 
    private int secondChoice;
    //Looks needed to synchronize the part where choices are incremented
    private Lock lock1 = new ReentrantLock() ;
    private Lock lock2 = new ReentrantLock() ;
    private Random random = new Random() ;

   //Constructor
    RandomCalculator(){
        firstChoice = 0 ;
        secondChoice =0 ;
    }

   
    //This is a function that repeat a random generation for a given interval of number and 
    // increment choices according to random number generated 
    public void randomChoice (int start , int end) {
           for (int i=start ; i<end ; i++){
               int rand = random.nextInt(2) ;
               if(rand==0){
                   lock1.lock();
                   firstChoice++ ;
                   lock1.unlock();
               }
               else{
                   lock2.lock();
                   secondChoice++;
                   lock2.unlock();
               }
           }
    }


    public int getFirstChoice() {
        return firstChoice;
    }



    public int getSecondChoice() {
        return secondChoice;
    }



}