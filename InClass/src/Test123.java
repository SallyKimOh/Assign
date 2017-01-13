import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class Test123 {

	private static int count;
	
	public Test123() { 
		count = 0;
	}
	public void increment() { 
		count++; 
	}
	public void display () {
		System.out.println ("count is " + count);
	}
	
	
	public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      
//		   int firstArg = 0;
//			   
//		   if(args.length > 0) {
//			   
//			   try{
//				   firstArg = Integer.parseInt(args[0]);
//			   
//			   } catch(Exception e){
//				      System.err.println("Argument" +args[0] + "must be an integer.");
//				      System.exit(1);
//			   }
//		   System.out.println("You entered" + firstArg);
//			   
//		   }
//

//		Test123 object1 = new Test123 ();
//		Test123 object2 = new Test123 ();
//		object2.display(); // count is 0 is displayed
//		object1.display(); // count is 0 is displayed
//		object1.increment();
//		object1.display(); // count is 1 is displayed
//		object2.display(); // count is 1 is displayed
//		object2.increment();
//		object1.display(); // count is 2 is displayed
//		object2.display(); // count is 2 is displayed
//		
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter max value: ");
//		int max=input.nextInt();
//		double rand = Math.random()*max;
//		System.out.println("Random value is "+rand);

//		Scanner info = new Scanner(System.in);
//		int choice = 1;
//		double temperature  = 0.0d;
//		double calcTemp = 0.0d;
//		while (choice ==1) {
//			temperature = info.nextDouble();
//			
//			calcTemp = temperature*9/5 +32;
//			System.out.println("Converted temperature is "+ calcTemp);
//			System.out.print("Do you want to do another :");
//			choice = info.nextInt();
//			
//		}
		
		
		double rand = Math.random()*3;
		System.out.println("Random value is "+rand);		
	
	}  
	
}
