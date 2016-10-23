import java.util.Scanner;

/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			OurDate ourDate = new OurDate();
			System.out.print("Initial date is " );
			ourDate.display();
			
			Scanner info = new Scanner(System.in);
			
			int month = 0;
			int day = 0;
			int year = 0;
			
			System.out.print("Enter a month:");
			month = info.nextInt();
			System.out.print("Enter a day:");
			day = info.nextInt();
			System.out.print("Enter a year:");
			year = info.nextInt();

			OurDate anotherDate = new OurDate(month, day, year);
			System.out.print("Date is " );
			anotherDate.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
