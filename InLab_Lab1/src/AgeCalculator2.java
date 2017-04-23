import java.util.Scanner;

/**
 * @author Sally Kim
 *
 */
public class AgeCalculator2 {

	private OurDate todayDate;	// The "current" date
	
	private OurDate birthDate;	// The person's birthdate
	
	private String personName;	// The person's name
	
	private String message;		// The message to be displayed
	
	public AgeCalculator2(){		// Default constructor (call both OurDate default constructors)

		todayDate = new OurDate();
		birthDate = new OurDate();
		
	}
	
//	public void enterData(){	//Enter today's and birth dates, and person name
//
////
////		System.out.println("Enter today's date: ");
////		System.out.print("Enter a valid year: ");
////		todayDate.setYearFromUser(todayDate.calcDays());
////		System.out.print("Enter the month: ");
////		todayDate.setMonthFromUser(todayDate.calcDays());
////		System.out.print("Enter the day: ");
////		todayDate.setDayFromUser(todayDate.calcDays());
////
////		System.out.println("Enter birth date: ");
////		System.out.print("Enter a valid year: ");
////		birthDate.setYearFromUser(birthDate.calcDays());
////		System.out.print("Enter the month: ");
////		birthDate.setMonthFromUser(birthDate.calcDays());
////		
////		System.out.print("Enter the day: ");
////		birthDate.setDayFromUser(birthDate.calcDays());
////		System.out.print("Enter person's name: ");
////		
////		Scanner scan = new Scanner(System.in);
////		personName = scan.nextLine();
////		
//////		System.out.println(birthDate-todayDate);
////		
//		
//		  
//		}
//	
	public void enterData1(){	//Enter today's and birth dates, and person name


//		System.out.println("\nEnter today's date: ");
//		todayDate.displayDate1();
//
//		System.out.println("Enter birth date: ");
//		birthDate.displayDate1();
//
//		System.out.print("\nEnter person's name: ");
//		
//		Scanner scan = new Scanner(System.in);
//		personName = scan.nextLine();
//		
//		System.out.println(todayDate.calcDays1());
//		System.out.println(birthDate.calcDays1());
////		System.out.println("==>"+(birthDate.calcDays1()-todayDate.calcDays1()));
//		
//	
		
		}
	
	public void calculateMessage(){	// Calculate the correct message
		
//		int ty = todayDate.calcDays1()/10000;
//		int tm = (todayDate.calcDays1()%10000)/100;
//		int td = (todayDate.calcDays1()%10000)%100;
//		int by = birthDate.calcDays1()/10000;
//		int bm = (birthDate.calcDays1()%10000)/100;
//		int bd = (birthDate.calcDays1()%10000)%100;
//		
////		System.out.println("==>"+(ty-by));
////		System.out.println("==>"+(tm-bm));
////		System.out.println("==>"+(td-bd));
//		
//		System.out.println("\nToday date: "+(todayDate.calcDays1()/10000+2000)+"/"+(todayDate.calcDays1()%10000/100)+"/"+(todayDate.calcDays1()%10000%100));
//		System.out.println("Birth date: "+(birthDate.calcDays1()/10000+2000)+"/"+(birthDate.calcDays1()%10000/100)+"/"+(birthDate.calcDays1()%10000%100));
//		
//		System.out.print(personName);
//
//		Today date: 2016/10/7
//		Birth date: 2228/3/22
//		James Tiberius Kirk is not born y		
		
		
		
	}
	
	

}
