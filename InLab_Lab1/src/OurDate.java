import java.util.Scanner;

/**
 * @author Sae il Kim
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 10. 19.
 *
 * @Modify_User
 * @Modify_date 2016. 10. 20.
 */

public class OurDate {
	
	private int year;	// The year
	private int month;	// The month
	private int day;	// The day
	private Scanner input = new Scanner(System.in);	//The scanner to be used for all three inputs
	
	
	public OurDate(){	// Default constructor (Jan. 1, 2000)
		this(2000,1, 1);
	}
	
	public OurDate(int y,int m, int d) {	//Initial constructor
		year = y;
		month = m;
		day = d;
		
		
	}

	public void setYearFromUser() {	//Set the year based on user input
		this.year = input.nextInt();
	}

	public void setMonthFromUser() {	//Set the month based on user input
		this.month = input.nextInt();
	}

	public void setDayFromUser() {	//Set the day based on user input
		this.day = input.nextInt();
	}

	
	public void displayDate(){	// Display date in the proper format
		System.out.println(year + "/"+ month + "/"+ day);
	
	}

	public int calcDays(){	//Calculate the number of days since Jan. 1, 2000
		
		int days = 0;

		int m_days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int mTotal = 0;
		
		for (int i = 0; i < month-1; i++){
			mTotal += m_days[i];
		}

		days = Math.abs(year* 365) + mTotal + day;
		
		String sDays= days + String.format("%02d",month);
		
		days = Integer.parseInt(sDays);
		return days;
	}
	
}
