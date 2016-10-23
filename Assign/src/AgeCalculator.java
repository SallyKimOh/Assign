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

public class AgeCalculator {

	private OurDate todayDate;	// The "current" date
	
	private OurDate birthDate;	// The person's birthdate
	
	private String personName;	// The person's name
	
	private String message;		// The message to be displayed
	
	public AgeCalculator(){		// Default constructor (call both OurDate default constructors)

		todayDate = new OurDate();
		birthDate = new OurDate();
		
	}

	
	public void enterData(){	//Enter today's and birth dates, and person name


		System.out.println("Enter today's date: ");
		System.out.print("Enter a valid year: ");
		todayDate.setYearFromUser();
		System.out.print("Enter the month: ");
		todayDate.setMonthFromUser();
		System.out.print("Enter the day: ");
		todayDate.setDayFromUser();

		System.out.println("\nEnter birth date: ");
		System.out.print("Enter a valid year: ");
		birthDate.setYearFromUser();
		System.out.print("Enter the month: ");
		birthDate.setMonthFromUser();
		
		System.out.print("Enter the day: ");
		birthDate.setDayFromUser();
		System.out.println("\nEnter person's name: ");
		
		Scanner scan = new Scanner(System.in);
		personName = scan.nextLine();
		
		}

	
	public void calculateMessage(){	// Calculate the correct message

		int tYear = 0;

		String stTemp = String.valueOf(todayDate.calcDays());
		int ntDay = Integer.parseInt(stTemp.substring(0,stTemp.length()-2));
		int ntMonth = Integer.parseInt(stTemp.substring(stTemp.length()-2, stTemp.length()));
		String sbTemp = String.valueOf(birthDate.calcDays());
		int nbDay = Integer.parseInt(sbTemp.substring(0,sbTemp.length()-2));
		int nbMonth = Integer.parseInt(sbTemp.substring(sbTemp.length()-2, sbTemp.length()));
		
		int gapDay = ntDay - nbDay;	//Gap of Days
		
		int m_days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		message = personName;
		
		tYear =  gapDay/365;
		
		int realDays = 0;		//real each months total days
		
		int tempMonth = ntMonth;
		
		if (ntMonth < nbMonth) {
			tempMonth = 12 + ntMonth;
		}
		
		int j = 0;
		for (int i = nbMonth-1; i < tempMonth -1; i++) {
			realDays+=m_days[i];
			j++;
		}
		
		if (tYear >=2 ) {		// over and equal 2 years
			message += " is "+tYear+" years old";
			
		} else {
			
			if ((tYear >= 0) &&(j > 2)) { // between less 2 years and more 2 months
				if ((gapDay%365) < realDays) {
					message += " is "+(tYear * 12 +(j-1))+" month(s) old";
				} else {
					message += " is "+(tYear * 12 +(j))+" month(s) old";
				}

			} else if ((tYear == 0) && (j <= 2) && ((gapDay/7) >= 2)) { // between 2 months and 2 weeks
				message += " is "+(gapDay/7)+" week(s) old";

			} else if ((tYear == 0) && ((gapDay/7) < 2) &&(gapDay > 0)) { // under 2 weeks
				message += " is "+gapDay+" day(s) old";

			} else if (gapDay == 0) {	//today was born
				message += " was born today"; 	
				
			} else if (gapDay < 0 ) {	//not yet
				message +=" is not born yet";
				
			}
		}
	}


	public void displayResults(){	// Display the message

		System.out.print("\nToday date: ");
		todayDate.displayDate();
		System.out.print("Birth date: ");
		birthDate.displayDate();

		System.out.println(message);
		
		
	}

	

}
