
public class Point {
	private int x;
	private int y;
	
	public Point (int xValue, int yValue) { // constructor
		x = xValue;
		y = yValue;
	}
	

	public Point (String a) { // constructor
			}
	
	public void setX( int newValue) {
		x=newValue;
	}
	
	
	public void changeX() {
		x = x+y;
	}
	
	
	public void display () {
		System.out.println ("x is " + x + " y is " + y);
	}
}
