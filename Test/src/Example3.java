

public class Example3{
	
	public static void main (String [ ] args) {
		
		Point point1 = new Point(4, 7);
		Point point2 = new Point(3, 1);
		Point point3 = new Point("A");
		
//		Time t2 = new Time("A",11);
		
		point1.display() ;
		point2.display();
		
		int newXValue = 12;
		point1.setX(newXValue);
		
		point2.changeX();
		point1.display();
		point2.display();
		
		char t1 = 'A';
		char t2 = 69;
		
		System.out.println('A');
		System.out.println(t2);
		System.out.println(t1+1);
		System.out.println(t1);
		System.out.println(65);
	
	}
}