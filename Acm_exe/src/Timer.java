import java.util.Scanner;


public class Timer {
	
	private int day=0 ;
	private int hour ; 
	private int minute ;
	private int second;
	
	public Timer(int hour , int minute , int second) {
		this.hour=hour ;
		this.minute = minute;
		this.second= second ;
	}
	
	
	public void regular_time () {
		if (this.second>=60) {
			this.minute = this.minute + this.second / 60 ;
			this.second = this.second % 60 ;
		}
		
		if (this.minute>=60) {
			this.hour = this.hour + this.minute / 60 ;
			this.minute = this.minute % 60 ;
		}
		
		if (this.hour>=24) {
			this.day = this.day +  this.hour / 24 ;
			this.hour = this.hour % 24 ;
		}
		
	}
	
	public void add_time (int sec) {
		this.second = this.second + sec ;
		this.regular_time();
		
		
	}
	
	public void add_time (int min ,   int sec) {
		this.minute = this.minute + min ;
		this.second = this.second + sec ;
		this.regular_time();
		
	}
	
	public void add_time ( int hour ,  int min ,   int sec) {
		this.hour = this.hour + hour ;
     	this.minute = this.minute + min ;
		this.second = this.second + sec ;
		this.regular_time();
		
	}
	
	public String toString() {
		String str ; 
		if (day>0) {
			str = String.format("%02d:%02d:%02d+%d days",this.hour, this.minute ,this.second , this.day ) ;
		}
		
		else {
			str = String.format("%02d:%02d:%02d",this.hour, this.minute ,this.second) ;
		}
		return str ;
	}
	
	 public static void main(String args[])
	    {
		 Scanner input = new Scanner(System.in) ;
		 String [] str = input.next().split(":") ;
		 
		 int a = Integer.parseInt(str[0]) ;
		 int b = Integer.parseInt(str[1]) ;
		 int c = Integer.parseInt(str[2]) ;
		 
		 Timer t1 = new Timer(a, b, c) ;

		 String [] str1 = input.next().split(":") ;
		 
		 if(str1.length>=3) {
			  a = Integer.parseInt(str1[0]) ;
			  b = Integer.parseInt(str1[1]) ;
			  c = Integer.parseInt(str1[2]) ;
			  t1.add_time(a, b, c);
		 }
		 
		 if(str1.length==2) {
			  a = Integer.parseInt(str1[0]) ;
			  b = Integer.parseInt(str1[1]) ;
			  t1.add_time(a, b);
		 }
		 
		 if(str1.length==1) {
			  a = Integer.parseInt(str1[0]) ;
			  t1.add_time(a);
		 }
		 
		 
		 System.out.println(t1) ;
		 
		 
		 input.close();
	    }
	
	

}
