package ushtrime;

public class Circle {
   private  double x, y , radius ;
   
   Circle(){}
   Circle(double x , double y , double radius ){
	   this.x=x ;
	   this.y=y;
	   this.radius=radius ;
   }
   
   public double getArea() {
	   return Math.PI * Math.pow(this.radius, 2) ;
   } 
   
   public double getPerimeter() {
	   return 2* Math.PI* this.radius;
   }
   
   public boolean contains(double x, double y) {
	   if (Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2) )<=this.radius) return true;
	   else return false ;
   }
   
   public boolean contains(Circle circ) {
	   if (Math.sqrt(Math.pow((this.x -  circ.x), 2) + Math.pow((this.y - circ.y), 2) )<=Math.abs(this.radius-circ.radius)) return true;
	   else return false ;
   }
   
   public boolean overlaps(Circle circ) {
	   if (Math.sqrt(Math.pow((this.x -  circ.x), 2) + Math.pow((this.y - circ.y), 2) )<=(this.radius+circ.radius)) return true;
	   else return false ;
   }

}
