package Problem1;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;



//This the main class that shows number of words in each file using threads.
public class MultithreadedSearch{
	
	//Total count of word for all files
	private  int total ;
	
	//used to save summaries 
	private ArrayList<String> sumStrings = new ArrayList<>() ;
	private WordSearch wordSearch ;
	
	//used to make synchronization
	Object object = new Object() ;
	
	//This is  method that perform countind of the word in a file using counword methode of
	// WordSearch
	public void runing(String file , String word){
		   wordSearch = new WordSearch(file, word) ; 
		   wordSearch.countword();
		   System.out.println(wordSearch.getsummary());
		   
		   //Use synchronized to prevent nondeterminism
		   synchronized (object) {
			total = total +  wordSearch.getCount() ;
			}
	}
	
	
	//Perform the same work as running but provide live track of words using countword2 of WordSeach object
	public void runing2(String file , String word){
		  
			   WordSearch wordSearch = new WordSearch(file, word) ; 
			   wordSearch.countword2();
			   synchronized (object) {
				sumStrings.add(wordSearch.getsummary()) ;   
				total = total + wordSearch.getCount() ;
			}
		}
   
    public int getTotal() {
		return total;
	}

    public ArrayList<String> getSummaries(){
    	return this.sumStrings ;
    }



	public static void main(String[] args) throws FileNotFoundException {
		//Use scanner to take inputs
         Scanner input = new Scanner(System.in) ; 
         System.out.print("Word you want to serch: "); 
         String word = input.nextLine() ; 
         System.out.print("Chose files: ");
         String[] files = input.nextLine().split(" ") ;
         System.out.print("Option -liveResult(yes/no): ");
         MultithreadedSearch multithreadedSearch = new MultithreadedSearch();
         //Number of thread is equal number of files 
         Thread [] threads = new Thread[files.length] ;
        
         //If answer is yes the program shows live result work 
         if(input.nextLine().equals("yes")){
	            System.out.println("LIVE RESULTS:");
	            for(int i =0 ; i< files.length ; i++) {
	                String file  = files[i] ;
	         	    threads[i] = new Thread(()->{
	         	    	multithreadedSearch.runing2(file, word);
	         	    }) ;
	        	}
	         
	                   	 for (Thread thread : threads) {
	        		 thread.run();
	        	 }
	        	 
	        	 for (Thread thread : threads) {
	        		 try {
						thread.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	 }
	         System.out.println("-----------------------------------------------------------------------------");
	         System.out.println("SUMMARY:");
	         for(String str : multithreadedSearch.getSummaries()) {
	        	 System.out.println(str);
	         }
	       	 System.out.println("TOTAL: " + multithreadedSearch.getTotal()+ " occurrences of keyword " + word );
         }
         
         
         //Other wise the program show just summary for each file and total count of counted words
         else {
        
	         System.out.println("SUMMARY:");
	         for(int i =0 ; i< files.length ; i++) {
	                String file  = files[i] ;
	         	    threads[i] = new Thread(()->{
	         	    	multithreadedSearch.runing(file, word);
	         	    }) ;
	        	}
	         
	                   	 for (Thread thread : threads) {
	        		 thread.run();
	        	 }
	        	 
	        	 for (Thread thread : threads) {
	        		 try {
						thread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	 }
	        	
	        	 System.out.println("TOTAL: " + multithreadedSearch.getTotal()+ " occurrences of keyword " + word );
         
         }
         

    }
}