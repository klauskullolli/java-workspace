

public class Solution {
	
	
	public static boolean equalCon(int[] A , int p , int q) {
		while (p<=q) {
			if(A[p]!=A[q]) return false ;
			p++ ;
		}
		
		return true ;
	}
	
	
	public static boolean isHill(int[] A , int p , int q) {
		if((p>0 && A[p-1]<A[p])&& (q<A.length-1 && A[q+1]<A[q]) ) return true ;
		else return false ;
	}
	
	
	public static boolean isValley(int[] A , int p , int q) {
		if((p>0 && A[p-1]>A[p])&& (q<A.length-1 && A[q+1]>A[q]) ) return true ;
		else return false ;
	}
	
	public static boolean isCounted(int[] A , int p , int q) {
		if(equalCon(A, p, q)&& (isHill(A, p, q) || isValley(A, p, q)) ) return true ;
		else return false ;
	}
	
	
	 public int solution(int[] A) {
	        int q = A.length-1 ;
	        int cons =0 ;
	        for (int i = q ;i>0 ; i--) {
	        	for(int j= 0 ; j<=i ; j++) {
	        		if (i==q  && equalCon(A ,j,i)  ) cons++ ;
	        		if (j==0  && equalCon(A ,j,i)  ) cons++ ;
	        		if(isCounted(A, j, i)) cons++ ;
	        	}
	        }
	        
	        
	        return cons ;
	    }
	 
	 
	public static void main(String[] args) {
		
		Solution solution = new Solution() ;
		int A[] = {2,2,3 , 4 ,3,3 , 2, 2 ,1, 1, 2,5} ;
			
		System.out.print(solution.solution(A));	
}
	
}
