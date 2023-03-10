package PCK_01;

public class test {
	
	public static void main(String[] args) {
		
		/*	
		Student n = new Student();
		System.out.println(n);
		System.out.println(n.hashCode());
		*/
		//int array[][] = new int[3][3] ;
		//System.out.print(array[1][1]);
		
	}

}


class Student{
	
	String name;
	String surname;
	float average;
	public Student() {
	}
	
	public Student(String name, String surname, float average) {
		name=this.name;
		surname=this.surname;
		average=this.average;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", average=" + average + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(average);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}


	
}