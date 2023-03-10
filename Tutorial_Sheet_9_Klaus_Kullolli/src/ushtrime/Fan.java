package ushtrime;

public class Fan {
  enum Speed{  SLOW , MEDIUM , FAST }  ;
  static enum Status{  ON ,OFF }  ;
  static int nr;
  private int speed = 1 ;
  private boolean status = false ;
  private double radius= 5 ;
  private String color ="blu" ;
  
  Fan(){
	  nr++ ;
  }
  
  Fan(Speed s , Status st , double radius , String color){
	  nr++ ;
	  switch (s) {
	  case SLOW : this.speed=1 ; break;
	  case MEDIUM :  this.speed=2 ; break; 
	  case FAST :  this.speed=3 ; break; 
	  default : this.speed=1 ; break;
	  }
	  
	  switch (st) {
	  case ON : this.status=true ; break;
	  case OFF :  this.status=false ; break; 
	  default : this.status=true ; 
	  }
	  this.radius= radius ;
	  this.color = color ;
  }
  
  public int getSpeed() {
	  return this.speed ;
  } 
  
  public boolean getStatus() {
	  return this.status ;
  }
  
  public double getRadius() {
	  return this.radius ;
  }
  
  public String getColor() {
	  return this.color ;
  }
  
  public void ToString() {
	  if(this.status) {
		  System.out.format("Fan #%d\n", nr) ;
		  System.out.println("\t speed : " +this.speed );
		  System.out.println("\t color : " +this.color );
		  System.out.println("\t radius : " +this.radius );
		  System.out.println("\t Fan is ON" );
	  }
	  else {
		  System.out.format("Fan #%d\n", nr) ;
		  System.out.println("\t color : " +this.color );
		  System.out.println("\t radius : " + this.radius );
		  System.out.println("\t Fan is OFF" );
	  }
	  
	  
  }
}
