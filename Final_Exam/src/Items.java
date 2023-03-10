
public class Items {
	private String name ;
	private double price  ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		String string = String.format("%s %.2f", this.name , this.price) ;
		return string ; 
	}
	
}
