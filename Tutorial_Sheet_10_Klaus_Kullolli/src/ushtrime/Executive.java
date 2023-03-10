package ushtrime;

public class Executive extends  Manager{
	 private String title ;
	 public Executive (String name, double salary , String department , String title ) {
		 super(name, salary , department);
		 this.title = title ;
	 } 
	 
	 public  String getTitle (){
		 return this.title ;
	 }
	 public String toString() {
	    	return "Executive name : " + super.getName() + "\nSalary: " + super.getSalary() + "\nDepartment: " + super.getDepartment() + "title: "+ title  + "\n\n" ;
	    } 
}
