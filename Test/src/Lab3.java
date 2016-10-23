import java.util.Scanner;

/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class Lab3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Initial date is 1/1/2000");
		Scanner info = new Scanner(System.in);
		
		int month = 0;
		int day = 0;
		int year = 0;
		
		System.out.print("Enter a month:");
		month = info.nextInt();
		System.out.print("\nEnter a day:");
		day = info.nextInt();
		System.out.print("\nEnter a year:");
		year = info.nextInt();
		System.out.println("Date is " + month + "/"+ day +"/"+ year);
		
		

	}

}
