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

public class AgeCalculator3 {

	private OurDate todayDate;	// The "current" date
	
	private OurDate birthDate;	// The person's birthdate
	
	private String personName;	// The person's name
	
	private String message;		// The message to be displayed
	
	public AgeCalculator3(){		// Default constructor (call both OurDate default constructors)

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
		int tMonth = 0;

		String stTemp = String.valueOf(todayDate.calcDays());
		String stDay = stTemp.substring(stTemp.length()-2, stTemp.length());
		String sbTemp = String.valueOf(birthDate.calcDays());
		String sbDay = sbTemp.substring(sbTemp.length()-2, sbTemp.length());

		System.out.println("stDay:"+stDay);
		System.out.println("sbDay:"+sbDay);
		System.out.println("sbTemp:"+sbTemp);
		
//		tYear = (todayDate.calcDays() - birthDate.calcDays())/365;
		tYear = (Integer.parseInt(stTemp.substring(0,stTemp.length()-2))-Integer.parseInt(sbTemp.substring(0,sbTemp.length()-2)))/365;
		System.out.println("AA==>"+tYear);
		message = personName;
		
		if ((tYear >=0) && (tYear < 2)) {
	//		tMonth = ((todayDate.calcDays() - birthDate.calcDays())%365)/30;
//			tYear = (birthDate.calcDays()-todayDate.calcDays())/30;
			tMonth = (Integer.parseInt(stTemp.substring(0,stTemp.length()-2))-Integer.parseInt(sbTemp.substring(0,sbTemp.length()-2)))/30;
			System.out.println(tMonth);
			switch (tMonth) {
				case 0: 
					if ((Integer.parseInt(stTemp.substring(0,stTemp.length()-2))-Integer.parseInt(sbTemp.substring(0,sbTemp.length()-2))%30) == 0) 
						message += " was born today"; 	
					else 
						if (stDay == sbDay)
							message += " is less than a month old"; 
						else 
							message += " is 1 month old";
//						break;
//						message += " is less than a month old"; 
					break;
				case 1: 
					if (stDay == sbDay) {
						message += " is less than a month old"; 
						System.out.println("==1");
						
					} else if (Integer.parseInt(stDay) - Integer.parseInt(sbDay) > 1) { 
						message += " is "+(Integer.parseInt(stDay) - Integer.parseInt(sbDay))+" months old";
						System.out.println("==3" + (Integer.parseInt(stDay) - Integer.parseInt(sbDay)));
						System.out.println("==3" + (Integer.parseInt(stDay)));
						System.out.println("==3" +Integer.parseInt(sbDay));
						System.out.println("==3");
					} else {
						
						message += " is 1 month old";
						System.out.println("==2");
					}
					break;
				default:
					message += " is "+tMonth+" months old";
					break;
			}
		} else if (tYear < 0) {
			message +=" is not born yet";
			
		} else {
			message += " is "+tYear+" years old";
		}
		
	}


	public void displayResults(){	// Display the message

		System.out.print("Today date: ");
		todayDate.displayDate();
		System.out.print("Birth date: ");
		birthDate.displayDate();

		System.out.println(message);
		
		
	}

	

}
