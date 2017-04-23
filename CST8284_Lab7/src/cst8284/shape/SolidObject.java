package cst8284.shape;

public class SolidObject <T extends BasicShape> {
	
   // TODO: Use the UML diagram to create the members required

	private double depth;
	private T shape;
	
	public SolidObject(){
		
	}
	
	public SolidObject(T shape, double depth){

	    this.depth = depth;
		this.shape = shape;
		
		
	};
	
	public SolidObject(T shape) {
		depth = 1.0;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public T getShape() {
		return shape;
	}

	public void setShape(T shape) {
		this.shape = shape;
	}
	
	
	public String getName(){
		
		if (getShape() instanceof Circle) {
			return "Cylinder";
		} else if (getShape() instanceof Rectangle) {
			return "Block   ";
		} else if (getShape() instanceof Square) {
			return "Cube    ";
		} else {
			return "Solid   ";
		}
			
	}
	
	public double getVolumn(){
		return getShape().getArea()*getDepth();
	}
	
	public double getSurfaceArea(){
		return (2*getShape().getArea())+(getShape().getPerimeter()*getDepth());
	}
	
	
}
