//program uses class Scanner
import java.util.Scanner;
import java.util.Stack;
/**  Displays an int number between 0 and 255 (inclusive) in its binary format
  *   @version 1
  *   @see java.lang.String
  *   @see java.util.Scanner
  */
public class DeciToBinaryStack {
	public static void main (String[] argv) {

		Scanner input = new Scanner (System.in);
		
		int number = 0;

//		get number to convert from user
		do {
			System.out.println("Enter the number to convert (0-255): ");
			number = input.nextInt();
		}  while (number< 0 || number > 255);

		Stack bi = new Stack();
		
		while(number > 1) {
			
			bi.push(number%2);
			number = number/2;
			
		}

		bi.push(number);

		while(bi.size()%4!=0) {
			bi.push(0);
		}
		
		System.out.println(bi.size());
		

		while(!bi.isEmpty()) {
			System.out.print(bi.pop());
		}
		
		
//		String a = "";
//		
//			
//		while(number > 0) {
//			
//			if (number == 1) {
//				a = "1"+a;
//				break;
//			}
//
//			a = (number%2)+a;
//			number = number/2;
//
//			
//		}
//
////		System.out.println(a);
////		System.out.println(a.length());
//		
//		while (a.length()%4 > 0) {
//		
//			a = "0"+a;
//			
//		}
//		System.out.println(a);
		
	
	} // end of main
}// end of class

 