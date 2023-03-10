package ushtrime;

public class Faculty extends Person {

	private String degree  ; 
	private double hour ;
	
	public Faculty( String name , double salary , String degree , double hour  ) {
		super(name , salary) ;
		this.degree = degree ; 
		this.hour= hour ; 
	}
	
	
	
}
