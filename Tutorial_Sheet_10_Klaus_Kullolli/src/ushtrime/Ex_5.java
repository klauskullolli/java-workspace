package ushtrime;

public class Ex_5 {

	public static void main(String[] args) {
		Employee[] emp = new Employee[3];
		emp[0] = new Employee("Alex", 20000);
		emp[1] = new Manager("Valmir" ,30000 , "Human Resources"  ) ;
		emp[2] = new Executive("Denjon" ,50000 , "Finance" , "CEO" ) ; 
		System.out.print(emp[0]) ;
		System.out.print(emp[1]) ;
		System.out.print(emp[2]) ;
	}

}
