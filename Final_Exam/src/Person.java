
public abstract class Person {
	private int id; 
	private String  name ;
	private String address ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
	
	public abstract void  write()  ; 
	
	public abstract void read() ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		String str =  String.format("%d\n%s\n%s\n",id ,name , address ) ;
		return str;
	}
	
	
	
}
