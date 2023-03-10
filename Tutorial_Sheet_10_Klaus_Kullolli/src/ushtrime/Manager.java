package ushtrime;

public class Manager extends Employee {
    private String department ;
    public Manager (String name , double salary , String department ) {
    	super(name , salary);
    	this.department = department ;
    }
    
    public String getDepartment() {
    	return this.department ;
    }
    public String toString() {
    	return "Manager name: " + super.getName() + "\nSalary: " + super.getSalary() + "\nDepartment: " + department + "\n\n";
    } 
    
}
