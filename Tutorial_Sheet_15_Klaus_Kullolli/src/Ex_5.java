import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Words implements Runnable{
	
	String path ; 
	
	Words(String path){
		this.path = path ;
	}
	
	
	@Override
	public void run() {
		try {
			String content = Files.readString(Paths.get(path));
			String []words = content.split("\\W+") ; 
			System.out.format("Number of words present in %s: %d\n" , path , words.length );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}


public class Ex_5 {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Words("klaus.txt")) ;
		Thread t2 = new Thread(new Words("ciku.txt")) ;
		Thread t3 = new Thread(new Words("student.txt")) ;
		
		
		t1.start();
		Thread.sleep(10);
		t2.start();
		t3.start();
	}

}
