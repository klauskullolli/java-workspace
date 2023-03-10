package Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//This is a class needed to make search of a specific word in a given file 
public class WordSearch {
    private String file;
    private String word;
    private int count;

    //Constructor 
    WordSearch(String file, String word) {
        this.file = file;
        this.word = word;
        count = 0;
    }

    
    //This countword function is function that count number of the words but just final calculation are
    // shown .
    public void countword() {
    	
    		 File f = new File(this.file);
    	        Scanner inputFile;
    	        try {
    	            inputFile = new Scanner(f);
    	            while (inputFile.hasNext()) {
    	                if (word.equals(inputFile.next())) {
    	                    count++;
    	                }
    	            }
    	        } catch (FileNotFoundException e) {
    	            e.printStackTrace();
    	        }
       
    }

    public int getCount() {
        return count;
    }
   
    //Function needed to return a formated string of final result after search
    public String getsummary() {
    	String str= String.format("%s: %d occurrences", this.file , this.count) ; 
        return str;
    }
    
    
    //This is a function similar to count but this one provide live tracing 
    // so give info for each line that  contain the word and a particular number if contain more than 1 
    public void countword2() {
            int line = 1;
            File f = new File(this.file);
            Scanner inputFile;
            try {
                inputFile = new Scanner(f);
                while (inputFile.hasNextLine()) {
                    String[] words = inputFile.nextLine().split(" ");
                    int line_count = Collections.frequency(Arrays.asList(words), this.word);
                 
                    //Print is made only if a line contain word 
                    if(line_count>0) {
    	                System.out.println(file + ": " + line_count + " occurrences at line " + line);
  
    	                count += line_count;
                    }
                    line++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }
    
    

}
