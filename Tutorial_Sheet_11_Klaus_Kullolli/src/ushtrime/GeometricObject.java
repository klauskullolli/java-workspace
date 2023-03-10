package ushtrime;

public abstract class GeometricObject {
	private String color;
	private boolean filled;
	
	public GeometricObject() {}
	public GeometricObject (String color ,boolean filled ) {
		this.color = color ;
		this.filled = filled ;
	}
	public String getColor() { 
		return color;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract String name();

	public abstract void howToColor();	
	
	
	
}
