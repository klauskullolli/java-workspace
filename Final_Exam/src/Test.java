import java.util.ArrayList;

public class Test <T> {

	ArrayList<T> list = new ArrayList<T>() ;
	
	private int size ;

	public Test(int size) {
		this.size = size  ;
	} 
	
	public  T getElement(){
		return list.get(list.size()-1) ;
	}
	
	public void insert (T element) {
		list.add(element) ;
	}
	
	
	public T remove() {
		T ele= list.get(list.size() - 1) ;
		this.list.remove(list.size()-1) ;
		return ele ; 
	}

	public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	} 
}
