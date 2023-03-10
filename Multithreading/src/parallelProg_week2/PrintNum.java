package parallelProg_week2;

public class PrintNum implements Runnable {

    private int lastNum;

    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    public void run() {
    	System.out.print(Thread.currentThread().getName()+" started. ");
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
            if(i==80){
                try {
                    Thread.sleep(5000);  //sleep 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
     }
}
