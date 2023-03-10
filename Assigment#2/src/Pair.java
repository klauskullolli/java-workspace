
// this is a class that make easier point b of Question 4 to solve 
//can access directly  a min and a max number 
public class Pair {
	
		int max_height ; 
		int min_height; 
		
		public Pair(int a , int b) {
			max_height=a ;
			min_height=b ;
		}
		
		@Override
		public String toString() {
		
		return String.format("Max_Height=%d Min_Height=%d\n",this.max_height , this.min_height ) ;
		}
		
}
