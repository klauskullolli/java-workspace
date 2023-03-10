package parallelProg_week2;

public class PrintChar implements Runnable {

    private char charToPrint; // The character to print
    private int times; // The times to repeat
    private Thread prev;
    
     //Construct a task with specified character and number of times to print the character
     
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
        prev = null;
    }

    public void waitFor(Thread t){
        prev = t;
    }

    @Override       //Override the run() method to tell the system what task to perform
    	 public void run() {
    	        System.out.print(Thread.currentThread().getName()+" started. ");
    	        for (int i = 0; i < times; i++) {
    	            System.out.print(" "+charToPrint);
    	            if(i==70){
    	                try {
    	                    if(prev != null) {
    	                        prev.join();
    	                    }
    	                } catch (InterruptedException e) {
    	                    e.printStackTrace();
    	                }
    	            }
    	        }
    }
}
