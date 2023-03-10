package parallelProg_week2;

public class ThreadsExample1 {

    public static void main(String[] args) throws InterruptedException {
        // Create tasks
        PrintChar printA = new PrintChar('a', 100);
        PrintChar printB = new PrintChar('b', 100);
        PrintNum print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);


//        thread1.setPriority(Thread.MIN_PRIORITY);
//        thread2.setPriority(Thread.MAX_PRIORITY);
//        thread3.setPriority(Thread.NORM_PRIORITY);

        
//        printB.waitFor(thread1);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        
//        thread1.run();
//        thread2.run();
//        thread3.run();
        
        
//      //make sure that thread 1, 2, 3 have completed their execution
//        //and then print MAIN-DONE
        thread1.join();
        thread2.join();
        thread3.join();
//
//        System.out.print("MAIN-DONE");

    }
}
