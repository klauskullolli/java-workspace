import java.util.Scanner;


//Class that contain all needed info for a professor
public class Professor {
	private String  name ; 
	private String surname ; 
	private String email ; 
	private String password ;
	private String subject ;
	private int id ;
	
	
	//Constructor
	Professor(){
		
	}
	
	//Constructor
	Professor(int id , String name , String surname  , String email, String password  ){
		this.id = id ; 
		this.name=name ; 
		this.surname = surname ; 
		this.email = email ;
		this.password = password ; 
	}
	
	public String getName() {
		return this.name ; 
	}
	
	public void setName(String name) {
		this.name = name ;
	}
	
	public String getSurname() {
		return this.surname ;
	}
	
	
	public void setSurname(String surname) {
		this.surname= surname; 
	}
	
	public String getEmail() {
		return this.email ; 
	}
	
	public void setEmail(String email) {
		this.email = email ; 
	}
	
	public String getPassword() {
		return this.password ;
	}
	
	public void setPassword(String password ) {
		this.password = password ;
	}
	
	public int getId() {
		return this.id ;
	}
	
	public void setId(int id) {
		this.id =id ;
	}
	
	public String getSubject() {
		return this.subject;
	} 
	
	public void setSubject(String subject) {
		this.subject = subject ; 
	}
	
	
	//method used to convent all class into string needed later for database saving of data
	@Override
	public String toString() {
		String str = null ; 
		str = String.format("%d\n%s\n%s\n%s\n%s\n%s\n;\n",this.id ,this.name , this.surname , this.email , this.password, this.subject  ) ;
		return str ;
	}
	
	
	//Method used to covert directly form string  to class object needed  later for passing attributes from database direct to class object
	public void toClass(String str) {
		  Scanner input = new Scanner (str) ; 
		  this.id = input.nextInt() ; 
		  input.nextLine() ;
		  this.name= input.nextLine();
		  this.surname = input.nextLine() ; 
		  this.email = input.nextLine() ;
		  this.password = input.nextLine()  ; 
		  this.subject = input.nextLine() ;
		  input.close();
	}
	
}
