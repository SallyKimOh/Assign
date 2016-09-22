import java.io.IOException;
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
 * @Modify_date 2016. 9. 19.
 */
public class Assign1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
		
			Scanner info = new Scanner(System.in);
			int dolM = 0;	//dollars
			int cM=0;		//cents
			
			int tM = 0;		//Toonies
			int lM = 0;		//Loonies
			int qM = 0;		//Quarters
			int dM = 0;		//Dimes
			int nM = 0;		//Nickels
			String sPanny = "0";
			
			System.out.println("Change is good");
			System.out.print("How many dollars? ");
	
			String sDolM = info.nextLine();
			
			while (true) {

				try {
					dolM = Integer.parseInt(sDolM);
					if (dolM < 0 ) {
						System.out.println("- is not dollars. You have to put in the dollars.");
						System.out.print("How many dollars? ");
						sDolM = info.nextLine();
					} else {
						break;
					}
					
				} catch (Exception e1) {
					System.out.println("This is not dollars. You have to put in the dollars.");
					System.out.print("How many dollars? ");
					sDolM = info.nextLine();
					
				}

			}

			System.out.print("\nHow many cents? ");

			String sTcM = info.nextLine();
			
			while (true) {

				try {
					cM = Integer.parseInt(sTcM);
					if (cM < 0 ) {
						System.out.println("- is not cents. You have to put in the cents.");
						System.out.print("How many cents? ");
						sTcM = info.nextLine();
					} else {
						break;
					}
					
				} catch (Exception e1) {
					System.out.println("This is not cents. You have to put in the cents.");
					System.out.print("How many dollars? ");
					sTcM = info.nextLine();
					
				}

			}
			
			
			if (String.valueOf(cM).length() > 1) {
				sPanny = String.valueOf(cM).substring(String.valueOf(cM).length()-1,String.valueOf(cM).length());

				if (Integer.parseInt(sPanny) <= 2 ) {
					cM = Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1)+"0");
				} else if ((Integer.parseInt(sPanny) > 2 ) && ( Integer.parseInt(sPanny) <= 7 )) {
					cM = Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1)+"5");
				} else if (Integer.parseInt(sPanny) > 7 ) {
					cM = Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1)+"5")+5;
				}
				
					
				if (cM > 100) {
					dolM += Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-2));

					String sCM = ""+cM;

					cM = Integer.parseInt(sCM.substring(String.valueOf(cM).length()-2,String.valueOf(cM).length()));

				}
					
			} else {
				if (cM <= 2 ) {
					cM = 0;
				} else if ((cM > 2 ) && ( cM <= 7 )) {
					cM = 5;
				} else if (cM > 7 ) {
					cM = 10;
				}
				
					
			}
				    
			tM = dolM / 2;  
			lM = dolM % 2;
			qM = cM / 25;
			dM = cM % 25 / 10;
			nM = cM % 25 % 10 /5;
				
			System.out.println("$"+ dolM + "."+sTcM +" requires: \n"); 
			System.out.println("Toonies:"+ tM); 
			System.out.println("Loonies:"+ lM); 
			System.out.println("Quarters:"+ qM);
			System.out.println("Dimes:"+ dM);
			System.out.println("Nickels:"+ nM);
				
			info.close();
				
		
		} catch (Exception e) {
			System.out.println("error==>"+e);
			
		}
	}

}
