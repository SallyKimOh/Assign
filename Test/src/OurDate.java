/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class OurDate {
	
	private int month;
	private int day;
	private int year;
	
	
	public OurDate(){
		
		this(1, 1, 2000);
	}
	
	public OurDate(int m, int d, int y){
		
		month = m;
		day = d;
		year = y;
		
		
	}

	public void display(){
		System.out.println( month + "/" + + day + "/"+ year);
	}


}
