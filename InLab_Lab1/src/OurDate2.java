import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class OurDate2 {
	
	private int year;	// The year
	private int month;	// The month
	private int day;	// The day
	private Scanner input;	//The scanner to be used for all three inputs
//	private Scanner input1 = new Scanner(System.in);	//The scanner to be used for all three inputs
	
	
	public OurDate2(){	// Default constructor (Jan. 1, 2000)
	
		year = 2000;
		month = 1;
		day = 1;
	}
	
	public OurDate2(int y,int m, int d) {	//Initial constructor

		
		
		
	}

	public void setYearFromUser(int y) {	//Set the year based on user input
		this.year = y;
	}

	public void setMonthFromUser(int m) {	//Set the month based on user input
		this.month = m;
	}

	public void setDayFromUser(int d) {	//Set the day based on user input
		this.day = d;
	}

	
	public void displayDate(){	// Display date in the proper format
		System.out.println(year + "/"+ month + "/"+ day);
	
	}

	public void displayDate1(){	// Display date in the proper format

		System.out.print("Enter a valid year: ");
		input = new Scanner(System.in);
		
		this.setYearFromUser(input.nextInt());
		System.out.print("Enter the month: ");
		this.setMonthFromUser(input.nextInt());
		System.out.print("Enter the day: ");
		this.setDayFromUser(input.nextInt());
	
	}

	
	
	
	public int calcDays(){	//Calculate the number of days since Jan. 1, 2000
		
		input = new Scanner(System.in);
		
		int days = input.nextInt();
		
		return days;
	}
	
	public int calcDays1(){	//Calculate the number of days since Jan. 1, 2000
		
		int totalDate = 0;
		int temp_y = 0;
		int temp_m = 0;
		int temp_d = 0;
		
		temp_y= year - 2000;
		temp_m = month;
		temp_d = day;
		
		totalDate = temp_y*10000+temp_m*100+temp_d;
		return totalDate;
	}
	
	
}
