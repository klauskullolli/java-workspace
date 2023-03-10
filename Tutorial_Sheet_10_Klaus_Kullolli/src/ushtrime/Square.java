package ushtrime;

public class Square extends Rectangle {
  public Square() {}
  
  public Square(double side) {
	  super(side , side) ;
  }
  
  public Square(double side , String color , boolean filled) {
	  super(side , side, color , filled) ;
  }
  
  public double getSide() {
	  return super.length ; 
  }
  
  public void setWidth( double side) {
	  super.width = side ; 
  }
  
  public void setLength( double side) {
	  super.length = side ; 
  }
  
  public String toString() {
	  return "A Square with side = " + super.length + ", which is a subclass of " + super.toString() ;
  }
}
