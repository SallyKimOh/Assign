import java.text.DecimalFormat;

/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class ChangeMachine {
	
	
	private int dollars;
	private int cents;
	private int toonies;
	private int loonies;
	private int quarters;
	private int dimes;
	private int nickels;   

	private double reMoney;
	
	
	public ChangeMachine() {
		
		dollars = 0;
		cents = 0;
		toonies = 0;
		loonies = 0;
		quarters = 0;
		dimes = 0;
		nickels = 0; 
		
	}
	
	

	public void getAmountFromUser() {
		
		
		DecimalFormat form = new DecimalFormat("#.##");

		int dolM = dollars;	//dollars
		int cM=cents;		//cents
			
	//=================== Real Calculate start ===================================//

		int total = ((dolM*100)+cM) ;

		double d = total/100;
			
		double c = Double.parseDouble(form.format(total%100*0.01));
			
		reMoney = d+c;
			
		dolM += (cM+2)/100;
		cM = (cM+2) % 100;
			
		toonies = dolM / 2;  
		loonies = dolM % 2;
		quarters = cM / 25;
		dimes = cM % 25 / 10;
		nickels = cM % 25 % 10 /5;

		//=================== Real Calculate end ===================================//
			
	}


	public void setAmountFromUser(int d, int c) {
		this.dollars = d;
		this.cents = c;
		
	}


	
	
	
	public void display() {
		
		System.out.println("\n$"+ reMoney +" requires:"); 
		
		System.out.println(toonies + " Toonies"); 
		System.out.println(loonies + " Loonies"); 
		System.out.println(quarters + " Quarters");
		System.out.println(dimes + " Dimes");
		System.out.println(nickels + " Nickels");
			
	}

}
