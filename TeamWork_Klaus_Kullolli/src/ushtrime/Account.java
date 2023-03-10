package ushtrime;

import java.util.Date;

public class Account {
   private int ID ;
   private  double balance ;
   private Date dateCreated = new Date() ;
   Account(){}
   Account( int ID , double balance){
	   this.ID= ID ;
	   this.balance=balance ;
   }
   
   public int getID() {
	   return this.ID ;
   } 
   
   public double getBalance() {
	  //System.out.println("The balance is: " + this.balance);
	   return this.balance ;
	   
   }
   
   public void setId(int id) {
	   this.ID= id ;
   }
   
   
   
   public Date getDateCreated() {
	   return this.dateCreated ;
   }
   
   public void withdraw( double amount) {
	   this.balance=this.balance-amount ;
   }
   
   public void deposit(double amount) {
	   this.balance=this.balance+amount ;}
   
}
