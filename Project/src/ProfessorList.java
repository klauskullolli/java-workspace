import java.util.ArrayList;
import java.util.Scanner;

//Class needed to keep professor object arranged in list
public class ProfessorList {
	
	//This is an array list to hold professors objects 
	private ArrayList<Professor> professors  = new ArrayList<Professor>() ;
	
	
	
	
	//Return professor at specific index
	public Professor getProfessor(int index) {
		return this.professors.get(index) ;
	}
	
	// Used to add professor 
	public void addProfessor(Professor professor ) {
		professor.setId(this.professors.size() + 1);
		this.professors.add(professor) ;
	}
	
	//Remove professor at specific index 
	public void removeProfessor(int id ) {
		for(int i=0 ; i<this.professors.size()  ; i++) {
			if(this.professors.get(i).getId() == id) this.professors.remove(i) ; 
		}
	} 
	
	//return array list of professor objects
	public  ArrayList<Professor> getPorfessorList(){
		return this.professors  ;
	}
	
	
	//method used to convent all class into string needed later for database saving of data
	@Override	
	  public String  toString() {
		  String str=null ;
		  str = String.format("%d\n", this.professors.size()) ; 
		  for(int i = 0 ; i<this.professors.size() ; i++) {
			  str  = str + String.format("%s", this.professors.get(i)) ;
		  }
		  return str ;
	  }
		
	//Method used to covert directly form string  to class object needed  later for passing attributes from database direct to class object
	 public void toClass(String str) {
			Scanner input = new Scanner (str) ; 
			int size  = input.nextInt() ; 
			Professor professor ;
			str = str.substring(2, str.length()) ;
			String [] list = str.split(";\n") ;
			for (int i = 0   ; i<size  ; i++) {
				professor =  new Professor() ;
				professor.toClass(list[i]);
				this.addProfessor(professor);
			}
			
			input.close();
		}
		
		
}  