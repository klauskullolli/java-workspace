package exercise;
//import java.io.*;
//import java.util.*;
public class Exercise_5 {

	public static void main(String[] args) {
		FileOperations file = new FileOperations();
		file.createFile();
		file.addText();
		file.close();
		file.printText();
		file.close();
	}

}
