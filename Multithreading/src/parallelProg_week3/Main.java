package parallelProg_week3;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown(30);
        Countdown countdown2 = new Countdown(30);

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");
//        CountdownThread t3 = new CountdownThread(countdown);
//        t3.setName("Thread 3");


        t1.start();
        t2.start();
//        t3.start();
    }
}

class Countdown {
    private int i;

    public Countdown(int value) {
        i = value;
    }

    public void doCountdown() {
        String color;


        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColors.ANSI_BLUE;
                break;
            case "Thread 2":
                color = ThreadColors.ANSI_PURPLE;
                break;
            default:
                color = ThreadColors.ANSI_GREEN;
        }

        while (i > 0) {
            synchronized (this) {
                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
                i--;
            }
           try {
                Thread.sleep((long)(50*Math.random()));
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
    