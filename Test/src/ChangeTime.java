import java.util.Scanner;

public class ChangeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner info = new Scanner(System.in);
		
		int hour;
		int min;
		int sec;
		
		int total_min = 0;
		
		
		System.out.print("How long hour do you want to get? ");
		hour = info.nextInt();
		System.out.print("How long minute do you want to get? ");
		min = info.nextInt();
		
		sec = hour * 3600 + min * 60;
		
		total_min = hour * 60 + min;
		
		System.out.println("Now you can spend " +sec + " second.");
		System.out.println("The decimal is " + total_min/60.00);
		
		
//		System.out.println(90/60.0);

	}

}
