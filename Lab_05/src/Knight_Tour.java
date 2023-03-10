

class Knight_Tour{
   
	//Function needed to check if movement is out of array
    static boolean isSafe(int i, int j, int board[][])
    {   
    	//Use exceptions to check if is out of border movement
    	try {
        	if (board[i][j] == -1) return true ;
        	return false ;
        }
        catch (Exception e) {
    		return false  ;
    	}
    }
 
 
    // Display solution if chess board is fully completed
   
    static boolean knight_move(int a , int b, int n)
    { 
        int board[][] = new int[n][n];
 
        //Fill the board with a specific negative number to check if knight can pass or no in this cell
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
            	board[x][y] = -1;
        
        // This 2 arrays are needed to perform all types of movement of a knight in a chess board 
        int x_direct[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int y_direct[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
 
       //Stating movement is 0 
        board[a][b] = 0;
 
      // Check if a solution is found 
        if (!solveBoard(0, 0, 1, board, x_direct, y_direct ,n)) {
            System.out.println("Solution does not exist");
            return false;
        }
        else
        	 for (int i = 0; i < n; i++) {
                 for (int j = 0; j < n; j++)
                     System.out.print(board[i][j] + " ");
                 System.out.println();
             }
 
        return true;
    }
    
    
    // This the back tracking algorithm that tries all the ways how to fill the board    
    // But entirely this back tracking algorithm is very slow because for every cell in board are 8 different movement options
    // so for the worst case there are 8^64 + (and more ) movement and tries
    // most of the time algorithm take a lot of time and load cpu processing lot.
  
    static boolean solveBoard(int x, int y, int movei,
                               int board[][], int x_direct[],
                               int y_direct[] , int n)
    {
        int x1, y1;
        
        //Case of termination the recursion 
        if (movei == n * n)
            return true;
 
       
        for (int i= 0; i < 8; i++) {
            x1 = x + x_direct[i];
            y1 = y + y_direct[i];
            if (isSafe(x1, y1, board)) {
            	board[x1][y1] = movei;
            	
            	//continue till is find a solution
                if (solveBoard(x1, y1, movei + 1,
                		board, x_direct, y_direct ,n))
                    return true;
                else
                	board[x1][y1]
                        = -1; // backtracking if any of case is not fulfilled  
            }
        }
 
        return false;
    }
 
   
    public static void main(String args[])
    {
       // Just call the function here to show completion of the board 
    	knight_move(0 , 0 ,8);
    }
}
