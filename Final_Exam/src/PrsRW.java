import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class PrsRW extends Person {
	public void read() {
		Path path = Paths.get("prs.bin");
		try {
			byte[] fileContents =  Files.readAllBytes(path);
			 String str = new String(fileContents, StandardCharsets.UTF_8);
			 Scanner input= new Scanner(str) ;
			 int id ; 
			 String name , address ; 
			 id = input.nextInt() ; 
			 input.nextLine() ;
			 name = input.nextLine() ;
			 address = input.nextLine() ;
			 this.setId(id);
			 this.setName(name);
			 this.setAddress(address);
			 input.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write() {
		try {
			FileOutputStream out = new FileOutputStream(new File("prs.bin"));
			try {
				out.write(this.toString().getBytes());
				
				out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
