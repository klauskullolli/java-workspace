package ushtrime;

import java.util.*;
public class Ex_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in) ;
		int  id  ;
		double amount ;
		Account a1 = new Account() ;
		ArrayList<Account> accounts = new ArrayList<Account>() ;
		for (int i =0 ; i< 10 ; i++ ) {
			accounts.add(new Account(i+1 , 100)) ;
		}
		
		
		while (true) {
			 
			System.out.print("Enter an id:") ;
			id= input.nextInt() ;
			int nr =0 ;
		for (int i = 0 ; i< 10 ; i++ ) {
			if (id == accounts.get(i).getID()) a1 = accounts.get(i) ; 
		}
		
		while (nr!=4) {
			System.out.println("Main Menu") ;
			System.out.println("1: check balance") ;
			System.out.println("2: withdraw") ;
			System.out.println("3: deposit") ;
			System.out.println("4: exit") ;
			System.out.print("Enter a choice: ") ;
			nr= input.nextInt() ;
			while(nr>4 || nr<1) {
				System.out.print("Enter one of listed numbers: ") ;
				nr= input.nextInt() ;
			}
			switch (nr ) {
			case 1: System.out.println("The balance is: " + a1.getBalance()); break ;
			case 2 : System.out.print("Enter an amount to withdraw: ") ; amount = input.nextDouble();
					a1.withdraw(amount);break ;
			case 3 : System.out.print("Enter an amount to deposit: ") ; amount = input.nextDouble();
			        a1.deposit(amount);break ;
			}
		} 
		
		}
		
	}

}
