import java.util.Scanner;

/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class Time {

	public static int g_iVal=100;

	private int hours;
	
	private int minutes;
	
	private int seconds;
	
	public int testHours = 0;

	public Time(){}
	
	
	public Time(String a){
		
		System.out.println("String");
	}
	
	public Time(int b){
		
		System.out.println("int");
	}
	
	
	public Time(int v_hours, int v_min, int v_sec) {
		hours = v_hours;
		minutes = v_min;
		seconds = v_sec;
	}
	public Time(Time v_time) {

		hours = v_time.hours;
		minutes = v_time.minutes;
		seconds = v_time.seconds;
	}
	
	
	public void inputHours( ) {
		Scanner keyboard= new Scanner (System.in);
		System.out.println("Enter the hours(0-23): ");
		hours = keyboard.nextInt();
	}// end inputHours
	
	public void inputMinutes( ) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter the minutes (0-59): ");
		minutes = keyboard.nextInt();
	}// end inputMinutes
	
	public void inputSeconds( ) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter the seconds (0-59): ");
		seconds = keyboard.nextInt();
	}// end inputSeconds
	
	public void display() {
		System.out.println (hours + ":" + minutes + ":" + seconds);
	}// end of display
	
	
	private int calcTotalSeconds() {
		 return ((hours*60+minutes)*60+seconds);
	}// end calcTotalSeconds
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time time1 = new Time();
//		time1.inputHours ();
//		time1.inputMinutes ();
//		time1.inputSeconds();
		time1.display();

		Time time2 = new Time();
		time2.inputHours ();
		time2.inputMinutes ();
		time2.inputSeconds();
		time2.display();
		
		
		System.out.println("The total time in seconds is "+time1.calcTotalSeconds());
		System.out.println("The total time in seconds is "+time2.calcTotalSeconds());
		System.out.println("The difference in their time is "+(time2.calcTotalSeconds() -time1.calcTotalSeconds()));
	}

}
