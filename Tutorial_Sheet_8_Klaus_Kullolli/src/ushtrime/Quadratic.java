package ushtrime;

public class Quadratic {
   private double a , b , c ;
   
   Quadratic (double a, double b, double c){
	   this.a=a;
	   this.b=b; 
	   this.c=c ;
   }
   
   private double discriminant = b*b - 4*a*c ;
    
   
   public double getDiscriminant() {
	   return this.discriminant ;
   }
   
   public double getRoot1() {
	   if (this.discriminant> 0 ) return (-b+ Math.sqrt(this.discriminant))/2*a ;
	   else if (this.discriminant== 0 ) return -b/2*a ;
	   else return 0 ;
   } 
   
   public double getRoot2() {
	   if (this.discriminant> 0 ) return (-b- Math.sqrt(this.discriminant))/2*a ;
	   else if (this.discriminant== 0 ) return -b/2*a ;
	   else return 0 ;
   } 
   
 
}
