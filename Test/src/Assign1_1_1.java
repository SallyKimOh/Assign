import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sae il Kim
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 9. 19.
 *
 * @Modify_User
 * @Modify_date 2016. 9. 24.
 */
public class Assign1_1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DecimalFormat form = new DecimalFormat("#.##");

		Scanner info = new Scanner(System.in);
		
		try {
		
			int dolM = 0;	//dollars
			int cM=0;		//cents
			
			int tM = 0;		//Toonies
			int lM = 0;		//Loonies
			int qM = 0;		//Quarters
			int dM = 0;		//Dimes
			int nM = 0;		//Nickels
			
			
			System.out.println("Change is good");
			
			//=================== Exception start ===================================//

			while (true) {

				try {
					System.out.print("How many dollars? ");
					dolM = info.nextInt();
					System.out.print("How many cents? ");
					cM = info.nextInt();
					if ((dolM < 0 ) || (cM < 0 )) {
						System.out.println("This is not real Money. Can you put in the Money again?");
					} else {
						break;
					}
					
				} catch (InputMismatchException e1) {
					System.out.println("This is not real Money.  You have to put in the number for Money.");
					info.close();
					return;
				}

			}
			
			//=================== Exception end ===================================//
			
			
			
			//=================== Real Calculate start ===================================//

			int total = ((dolM*100)+cM) ;

			double d = total/100;
			
			double c = Double.parseDouble(form.format(total%100*0.01));
			
			double reMoney = d+c;
			
			dolM += (cM+2)/100;
			cM = (cM+2) % 100;
			
			tM = dolM / 2;  
			lM = dolM % 2;
			qM = cM / 25;
			dM = cM % 25 / 10;
			nM = cM % 25 % 10 /5;


//			if (total%100 > 9) {
//				System.out.println("\n$"+ total/100+"."+form.format(total%100) +" requires:"); 
//			} else {
				System.out.println("\n$"+ reMoney +" requires:"); 
//			}
			
			System.out.println(tM + " Toonies"); 
			System.out.println(lM + " Loonies"); 
			System.out.println(qM + " Quarters");
			System.out.println(dM + " Dimes");
			System.out.println(nM + " Nickels");
			
			
			//=================== Real Calculate end ===================================//
			
			
		
		} catch (Exception e) {
			System.out.println("It happens the critical problem.");
			info.close();
		
		}
	}

}
