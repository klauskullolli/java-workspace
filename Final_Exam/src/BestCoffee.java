import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;



public class BestCoffee implements GandCoffee {
   
	ArrayList <Items> items = new ArrayList<Items> () ; 
	double total=0  ; 
	private PrintWriter output  ;
	
	@Override
	public void createfile() {
		try {
		output = new PrintWriter("store.txt") ;}
		catch (Exception e) {
			System.out.println("Check the path and file name again");
		}
	}

	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public void addiItem() {
		Scanner input = new Scanner(System.in) ;
		Items item = new Items() ;
		double price ; 
		String name ; 
	//	System.out.print("Item and Price : ");
	//	name = input.next() ; 
	//	price = input.nextDouble();
		while(true) {
			System.out.print("Item and Price : ");
			name = input.next() ; 
			
			if(name.charAt(0)=='q') break ;
			else {
				price = input.nextDouble();
				item.setName(name);
				item.setPrice(price);
				items.add(item) ;
			}
			
			
		}	
		
		input.close();
	}

	@Override
	public void printItems() {
		
		for (int i = 0 ; i< this.items.size() ; i++) {
			output.println(this.items.get(i));
		}
		
	}

	@Override
	public void total() {
		double total= 0  ; 
		for (int i = 0 ; i< this.items.size() ; i++) {
		total = total + this.items.get(i).getPrice();
		}
		total = total + 0.2*total ; 
		System.out.println("TOTAL:" + total  );
		this.total = total ;
	}

	@Override
	public void close() {
		output.close();
		
	}
	
	public String toString() {
		String str = new String() ; 
		
		str = "Items you bought:\n" ;
		for (int i = 0 ; i< this.items.size() ; i++)
		{
			str = str + String.format("%s", this.items.get(i)) ;
		}
		return str;
	}
	
   
}
