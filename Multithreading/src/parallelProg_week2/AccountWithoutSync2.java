package parallelProg_week2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync2 {
	
	public static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//create and launch 100 threads
		for(int i=0; i<100; i++) {
			executor.execute(new AddAPennyTask());
		}
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {
			
		}
		
		System.out.print("What is final balance? " + account.getBalance());
	}
	
//add a penny to the account
private static class AddAPennyTask implements Runnable{
	public void run() {
		try {
			account.deposit(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//an inner class
public static class Account{
	private int balance = 0;
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) throws InterruptedException {
		int newBalance = balance + amount;   // ANOMALY - two threads might be executing this instruction in the same time
		//Thread.sleep(10);  //to make the anomaly even more evident
		balance = newBalance;
	}
  }
}