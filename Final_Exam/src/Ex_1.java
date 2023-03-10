
public class Ex_1 {

	public static void main(String[] args) {
		BestCoffee file = new BestCoffee() ;
		file.createfile();
		file.addiItem(); 
		file.printItems();
		System.out.print(file);
		file.close();
		
		double [] myList = new double[12]; 
		double max  =  myList[0] ; 
		
		for (int i = 0 ; i< myList.length ; i++) {
			if(max< myList[i]) 
				max= myList[i] ; 
		}
	}

}
