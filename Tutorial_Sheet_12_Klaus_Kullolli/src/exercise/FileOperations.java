package exercise;

import java.io.*;
import java.util.*;
public class FileOperations {
    
	private File file ;
	private PrintWriter output  ;
	private Scanner input ;
	public FileOperations() {} 
	
	void createFile()  {
		String filename ; 
		input = new Scanner(System.in) ;
		System.out.print("Enter the path with file name(e.g. D:\\filename.txt): ") ;
		filename = input.nextLine() ; 
		
		try {
			this.file = new File(filename) ;
			if (file.createNewFile()) 
				 System.out.println("The file is created!");
			else System.out.println("The file already exist!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	void  addText()  {
		input = new Scanner(System.in) ;
		String txt ;
		System.out.print("Enter the text: ") ;
		txt = input.nextLine() ;
		input.close();
		try {
			this.output = new PrintWriter(this.file);
			this.output.println(txt);
			System.out.println("Text added to the file!") ;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
        
	}
	
	
	void close() {
		this.input.close();
		this.output.close();
	}
	
	void printText()  {
		try {
			this.input = new Scanner(file) ;
			while(input.hasNext()) {
				System.out.println(input.next());
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
