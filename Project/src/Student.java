import java.util.ArrayList;
import java.util.Scanner;

//This a class that contain all data needed for the program
public class Student {
  
//All data needed
  private String name ; 
  private String surname ; 
  private int id ; 
  private String email  ; 
  private String  password ; 
  private ArrayList<ExamPoints> subjects = new ArrayList<ExamPoints>()  ;
  
  
  
  //Constructor
  Student(){
  }
  
//Constructor
  Student ( int id , String name , String surname, String email , String password ){
	  this.name = name ; 
	  this.surname = surname  ; 
	  this.password =password  ; 
	  this.email = email  ; 
	  this.id = id ;
  }
  
  public int getId() {
	  return this.id ;
  }
  
  public void setId(int id){
	  this.id = id ;
  }
  
  public void setName(String name) {
	  this.name= name ; 
  }
  
  public String getName() {
	  return this.name ; 
  }
  
  public void setSurname (String surname) {
	  this.surname = surname  ;
  }
  
  public String getSurname() {
	  return this.surname ; 
  }
  
  public void setPassword(String password) {
	  this.password = password ; 
  }
  
  public String getPassword() {
	  return this.password ; 
  }
  
  public void setEmail(String email) {
	  this.email = email  ;
  }
  
  public String getEmail() {
	  return this.email ; 
  }
  
  
  //This is to add other subject for a student 
  public void addSubject(String subject) {
	  subjects.add(new ExamPoints(subject))  ;
  }
  
//This is to delete subject with specific name
  public void delSubject(String subject) {
	  for (int i = 0 ; i<subjects.size() ; i++) {
		  ExamPoints sub = subjects.get(i) ;
		  if(sub.getSubject().toLowerCase() == subject.toLowerCase() ) subjects.remove(i) ;
	  }  
  }
  
  //Used to set points for a specific subject
  public void addPoints(String subject , int points) {
	  for (int i = 0 ; i<subjects.size() ; i++) {
		  ExamPoints sub = subjects.get(i) ;
		  subject = subject.toLowerCase() ;
		  if(sub.getSubject().toLowerCase().equals(subject) ) {subjects.get(i).setPoints(points);
		  }
	  }  
  }
  
  
  
 // this method return the subject class that contain name of subject and grade if it is graded
  public ArrayList<ExamPoints> getSubjects(){
	  return this.subjects  ;
  }
  
  
  //Convert the parameters of class to string 
  //Used mostly for database
  @Override

  public String  toString() {
	  String str=null ;
	  str  = String.format("%d\n%s\n%s\n%s\n%s\n%d\n", this.id , this.name , this.surname , this.email , this.password, this.subjects.size()) ;
	  for (int i = 0 ; i< this.subjects.size() ; i++ )
	  {
		  String s1 = String.format("%s", this.subjects.get(i) ) ;
		  str = str + s1 ;
	  }
		str = str + ";\n"  ;  
	  return str ;
  }
  
  //This method convert the string to class attributes also this is used mostly for database
  public void toClass(String str) {
	  Scanner input = new Scanner (str) ; 
	  this.id = input.nextInt() ; 
	  input.nextLine() ;
	  this.name= input.nextLine();
	  this.surname = input.nextLine() ; 
	  this.email = input.nextLine() ;
	  this.password = input.nextLine(); 
	  int size = input.nextInt() ;
	  input.nextLine() ;
	  for (int i = 0 ; i<size ; i++) {
		  String sub = input.nextLine() ; 
		 
		 String arr[]  = sub.split("-") ;
		  String subject = arr[0] ;
		
		 ExamPoints exam = new ExamPoints(subject) ;
		  boolean  c = Boolean.parseBoolean(arr[1])  ; 
		  if(c || arr[1].equals("true")) {
			int point  =  Integer.parseInt(arr[2]);
			 exam = new ExamPoints(subject ,point ) ;
		  }
		  subjects.add(exam) ; 
   	  }
	  input.close();
  }
  
}
