package Problem3;


import java.util.ArrayList;
import java.util.Arrays;

//This is class that perform the hill climbing algorithm 
public class HillClimbing {
     
	 //Attributes necessary for hill climbing 
	
	//Final state that contain best max point of function
     private State state; 
     private double stepSize ;
     private double minx , maxX , miny, maxY ;
     private Object object = new Object() ;
      
     //In constructor boundaries are needed and stepSize 
     public HillClimbing(double minx, double maxX, double miny ,double maxY, double stepSize ){
        state = new State(0, 0) ;
        this.stepSize = stepSize ; 
        this.minx = minx ; 
        this.maxX = maxX ;
        this.miny = miny ; 
        this.maxY = maxY ;
    }


     //Hill climbing algorithm is performed  to find the max point from given starting points 
     public void calculateBestState( double x , double y ){
            State current = new State(x, y) ;
            // While is in boundaries the search
            while(x>=minx && x<=maxX && y>=miny && y<=maxY){
                
            	//ArrayList of states to check every next movement of function point according to
                ArrayList<State> states = new ArrayList<>(Arrays.asList( new State(x-stepSize , y), new State(x+stepSize , y),  new State(x, y-stepSize ),
                new State(x, y+stepSize ) , new State(x-stepSize, y-stepSize ), new State(x+stepSize, y-stepSize ),new State(x-stepSize, y+stepSize ),new State(x+stepSize, y+stepSize ) )) ;
                
                //Best state calculated from bestState function
                State best = bestState(states); 
                //check if current value larger than best state or no 
                if(best.getValue()>current.getValue()){
                    current = best ;
                    x= current.getX() ;
                    y = current.getY() ;
                }
                else {
                    break ; 
                }
            }
            
            //State of function changes is value of current is larger 
            synchronized (object){
                if(state.getValue()<current.getValue()){
                    state = current ;
                }
            } 
            
     } 
     
     

   //This one select the state with the state with the largest value that is inside the boundaries
    private  State bestState( ArrayList<State> states){
         State best  = states.get(0) ; 
         for (int i = 1 ; i<states.size() ; i++){
             if(states.get(i).getValue()>best.getValue() && states.get(i).checkBoundaries(minx, maxX, miny, maxY)){
                 best= states.get(i) ; 
             }
         }
         return best ;
     }



    public State getState() {
        return state;
    }
 

}