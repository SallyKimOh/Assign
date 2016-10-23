import java.util.Scanner;

public class Date {

	
//	3.14 (Date Class ) Create a class  called Date 
//	that includes three instance variables -a month (type  int ), a day (type  int ) and a year (type  int ). 
//	Provide a constructor  that initializes  the three instance variables  
//	and assumes  that the values  provided are correct. 
//	Provide a set and a get method  for each instance variable . 
//	Provide a method  displayDate that displays the month, day and year separated by forward slashes (/). Add a main method  to the class  that demonstrates class  Date's capabilities. 
	
	private int month;
	private int day;
	private int year;
	
	public Date(int m, int d, int y){
		month = m;
		day = d;
		year = y;
	}
	
	
	public String displayDate(){
		return month+"/"+day+"/"+year;
	}
	
	
	public int getMonth() {
		return month;
	}





	public void setMonth(int month) {
		this.month = month;
	}





	public int getDay() {
		return day;
	}





	public void setDay(int day) {
		this.day = day;
	}





	public int getYear() {
		return year;
	}





	public void setYear(int year) {
		this.year = year;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter the month, day and year in the form XX XX XXXX and hit enter:");
		Date dt = new Date(stdin.nextInt(),stdin.nextInt(),stdin.nextInt());
		
		System.out.println("The Date object's state is: "+dt.getMonth()+"/"+dt.getDay()+"/"+dt.getYear());
		
		System.out.print("Enter a new year:");
		int year = stdin.nextInt();
		dt.setYear(year);
		System.out.println("The Date object's state is: "+dt.getMonth()+"/"+dt.getDay()+"/"+dt.getYear());
		System.out.print("Enter a new day:");
		int day = stdin.nextInt();
		dt.setDay(day);
		System.out.println("The Date object's state is: "+dt.getMonth()+"/"+dt.getDay()+"/"+dt.getYear());
		System.out.print("Enter a new month:");
		int month = stdin.nextInt();
		dt.setMonth(month);
		System.out.println("The Date object's state is: "+dt.getMonth()+"/"+dt.getDay()+"/"+dt.getYear());
	
	}

}
