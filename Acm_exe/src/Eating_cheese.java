import java.util.Scanner;

public class Eating_cheese {
    
	static void cheese_way( int n, int m)
    {
        int top = 0,
            bottom = n - 1,
            left = 0,
            right = m - 1;
  
        while (true)
        {
            if (left > right)
                break;
     
            for (int i = left; i <= right; i++)
            	System.out.println( (i+1) + " " + (top+1));
           
               
            top++;
     
            if (top > bottom)
                break;
     
            for (int i = top; i <= bottom; i++)
            	System.out.println( (right+1) + " " + (i+1));
            	
            right--;
            
            
            if (left > right)
                break;
     
            for (int i = right; i >= left; i--)
            	System.out.println( (i+1) + " " + (bottom+1));
            

            bottom--;
     
            
            if (top > bottom)
                break;
     
            
            for (int i = bottom; i >= top; i--)
            	System.out.println( (left+1) + " " + (i+1));
            	
            left++;
        }
    }
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		int n = input.nextInt() ;
		int m= input.nextInt() ;
		cheese_way(n, m);
		input.close();

	}

}
