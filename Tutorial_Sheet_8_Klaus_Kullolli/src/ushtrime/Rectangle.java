package ushtrime;

public class Rectangle {
  private double width ,height ;
  
  public Rectangle() {}
  public Rectangle(double width , double height ) {
	  this.width=width  ; 
	  this.height = height ;
  }
  
  public double getArea() {
	  return this.width * this.height ;
  }
  
  public double getPerimeter() {
	  return this.width * this.height ;
  }
  
  public void setwidth(double width) {
	  this.width=width ;
  }
  
  
}
