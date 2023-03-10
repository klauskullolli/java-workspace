package ushtrime;

public class Instructor extends Person  {
	private String school ;
	private double pay; 
	
	public Instructor (String name , String address , String school , double pay ) {
		super(name, address) ;
		this.school =school ;
		this.pay = pay ; 
	}
	
	 public void setSchool(String school) {
		 this.school= school ;
	 }
	 
	 public String getSchool() {
		 return this.school ;
	 }
	 
	 public double  getPay() {
		 return this.pay   ;
	 }
	 
	 public void  setPay(double pay) {
		this.pay = pay   ;
	 }
	 
	 
	 public String toString() {
		 return "Instructor name: " + super.getName()  + "\nInstructor address: " +  super.getAddress() + 
				 "\nUniversity: "+ school+ "\nSalary: " + pay +"\n" ;
 	 }
}
