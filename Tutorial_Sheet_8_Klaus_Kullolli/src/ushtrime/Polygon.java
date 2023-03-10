package ushtrime;

public class Polygon {
  private int n = 3 ;
  static int c= 0 ;
  private double side = 1 ;
  Polygon (){
	  c++;
  }
  
  Polygon(int n , double width){
	  this.n=n ; 
	  this.side= width ;
	  c++;
	  
  }
  
  public int getN() {
	  return this.n ;
  }
  public double getSide() {
	  return this.side ;
  }
  
  public double getArea() {
	  return (this.n * Math.pow(this.side, 2)) /(4*Math.tan(Math.PI/this.n)) ;
  }
  public double getPerimeter() {
	  return this.side*this.n ;
  }
  
  public  static int count() {
	  return c ;
  }
  
}
