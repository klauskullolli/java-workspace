package ushtrime;

public class Person {

	private String   name ; 
	
	private double salary  ;
	
	// create constructor 
	public Person (String name   , double salary) {
		this.name = name  ; 
		this.salary = salary ;
	}
	
	// method return name 
	public String getName() {
		return name  ;
	}
	
	// method return salary  
	public double getSalary() {
		return this.salary  ;
	}
	
	public String toString() {
		return "Person name : " + name + "\nSalary : " +  salary ; 
	}
	
}


