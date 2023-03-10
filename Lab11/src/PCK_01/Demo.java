package PCK_01;

import java.util.ArrayList;

public class Demo {

	public static final int tableSize = 1000;
	public static final int pKey = 31;
	public static final int MaxLen = 10;

	public static int hash(String key, int n) {
		int res = 0;
		for (int i = 0; i < n; i++)
			res = (res + key.charAt(i));
		return res % tableSize;
	}

	public static int computeHash(String s) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i);
		}
		return hash % tableSize; // SIZE = 100 in example
	}

	public static int hash(String key) {

		int res = 0, len = Math.min(key.length(), MaxLen);
		for (int i = 0; i < len; i++)
			res = (pKey * res + key.charAt(i)) % tableSize;
		if (res < 0)
			res += tableSize; // if overflows

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Node n = new Node("Alb", 1015.5);
		System.out.println(n.hashCode());
		
		
		
		String key ;
		int hashValue;
		
		key = "AC";
		hashValue = hash(key, 2);
		System.out.println(hashValue);
		
		key = "CA";
		hashValue = hash(key, 2);
		System.out.println(hashValue);
		
		key = "BB";
		hashValue = hash(key, 2);
		System.out.println(hashValue);
		
	

/*
		String key = "dog";
		System.out.println(computeHash(key));
*/
		
/*		
		Date d = new Date(2020, 05, 26);
		System.out.println(d.hashValue());
		
		Node n = new Node("Alban", 1015.5);
		System.out.println(n.hashCode());
*/		
	
		
		
/*
		System.out.println(hash("BINFA"));
		System.out.println(hash("BINFB"));
		System.out.println(hash("NEC"));
		
		
*/
		



		
		

	}

}

class Date {
	int Year, Month, Day;

	Date(int y, int m, int d) {
		Year = y;
		Month = m;
		Day = d;
	}

	int hashValue() {
		int res = 31 * (Month + (31 * Year + Day));
		if (res < 0)
			res = -res;
		return res;
	}
}

class Node {
	String name;
	double amount;
	
	Node(String name, double amount){
		this.name=name;
		this.amount=amount;
	}
}
