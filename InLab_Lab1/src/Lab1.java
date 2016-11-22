import java.util.Scanner;

/**
 * 
 */

/**
 * @author Saeil Kim
 *
 */
public class Lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		@SuppressWarnings("resource")
		Scanner info = new Scanner(System.in);
		
		int cmt = 0;

		int tot_inch = 0;
		int feet = 0;
				
		System.out.println("This rogram, written by Saeil Kim, will convert a length in centimeters to feet and inches");
		System.out.print("Enter the number of centimeters:");
		cmt = info.nextInt();
		tot_inch = cmt * 100 / 254;
		feet = tot_inch / 12;
		System.out.println(cmt + "centimeters equals " + feet + "feet and "+(tot_inch%12)+ "inches");

		
		
	}

}
