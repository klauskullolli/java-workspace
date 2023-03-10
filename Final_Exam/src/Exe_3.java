
public class Exe_3 {

	public static void main(String args[]){
    	try {
    		Test<String> stringTest = new Test<String>(2);
    		stringTest.insert("test 1");
    		stringTest.insert("test 2");
    		System.out.println("The string element is :"+ stringTest.getElement());
    		
    		Test<Integer> integerTest = new Test<Integer>(2);
    		integerTest.insert(14);
    		integerTest.insert(15);
    		System.out.println("The integer element is :"+ integerTest.getElement());
    		System.out.println("The removed element is:" + integerTest.remove());
    		System.out.println("The integer element is :"+ integerTest.getElement());

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
