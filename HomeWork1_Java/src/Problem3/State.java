package Problem3;


//This is state of an equation specified in this class
public class State {
    
	
	//State contain variables and result form variables according to equation 
    private double x;
    private double y;
    private double value;
    
    
    //Constructor
    public State(double x, double y) {
        this.x = x;
        this.y = y;
        this.value = State.objectiveFunction(x, y);
    }
    
    
    //Function at which max point is going to be found
    public static double objectiveFunction(double x, double y) {
        return 50 + 20*x*y - 3*x*x*y - 2*x*y*y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // This function is needed to check is point is out of specified boundaries 
    public boolean checkBoundaries(double minx, double maxX, double miny ,double maxY){
        
        return x>=minx && x<=maxX && y>=miny && y<=maxY ;
    }
}
