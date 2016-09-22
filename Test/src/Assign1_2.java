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
public class Assign1_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Change is good
//		How many dollars? 3
//		How many cents? 40
//		$3.42 requires:
//		1 Toonies
//		1 Loonies
//		1 Quarters
//		1 Dimes
//		1 Nickels
//		Handle penny rounding up
		
		try {
		
		Scanner info = new Scanner(System.in);
		int dolM = 0;	//dollars
		int cM=0;		//cents
		
		int tM = 0;		//Toonies
		int lM = 0;		//Loonies
		int qM = 0;		//Quarters
		int dM = 0;		//Dimes
		int nM = 0;		//Nickels
		int pM = 0;		//Penny
		String sPanny = "0";
		
		float tot = 0;	//Total Money
		
		System.out.println("Change is good");
		System.out.print("How many dollars?");

		while (!info.hasNextInt()) {
			System.out.println("This is not Money. You have to put in the Money.");
			info.next();
			System.out.print("How many dollars?");

		}
		
		
		
//		if (info.hasNextBigInteger()) {
			dolM = info.nextInt();	// dollars

			System.out.print("\nHow many cents?");

			while (!info.hasNextInt()) {
				System.out.println("This is not cents. You have to put in the cents.");
				info.next();
				System.out.print("How many cents?");

			}
			
			
//			if (info.hasNextInt()) {
System.out.println("AAAFF");
				cM = info.nextInt();	//cents
				System.out.println(String.valueOf(cM).length());
////				System.out.println(String.valueOf(cM).lastIndexOf(0,1));
//				System.out.println(String.valueOf(cM).substring(String.valueOf(cM).length()-1,String.valueOf(cM).length()));
//				System.out.println(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1));
				
				
				if (String.valueOf(cM).length() > 1) {
					sPanny = String.valueOf(cM).substring(String.valueOf(cM).length()-1,String.valueOf(cM).length());

					if (Integer.parseInt(sPanny) <= 2 ) {
						cM = Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1)+"0");
//						System.out.println("1");
					} else if ((Integer.parseInt(sPanny) > 2 ) && ( Integer.parseInt(sPanny) <= 7 )) {
						cM = Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1)+"5");
//						System.out.println("2");
					} else if (Integer.parseInt(sPanny) > 7 ) {
						cM = Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-1)+"5")+5;
//						System.out.println("4");
					}
				
//					System.out.println(cM);
					
					if (cM > 100) {
						dolM += Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-2));

//						cM = Integer.parseInt(String.valueOf(cM).substring(String.valueOf(cM).length()-1,String.valueOf(cM).length()));
						String sCM = ""+cM;

						cM = Integer.parseInt(sCM.substring(String.valueOf(cM).length()-2,String.valueOf(cM).length()));
//						System.out.println(sCM);
//						System.out.println("CCCC=="+cM);
						
//						System.out.println("ab=="+Integer.parseInt(String.valueOf(cM).substring(1,3)));
//						System.out.println("ab1=="+Integer.parseInt(String.valueOf(cM).substring(0,String.valueOf(cM).length()-2)));

					}
					
					System.out.println("dolM =="+dolM);
					
				} else {
					if (cM <= 2 ) {
						cM = 0;
//						System.out.println("11");
					} else if ((cM > 2 ) && ( cM <= 7 )) {
						cM = 5;
//						System.out.println("22");
					} else if (cM > 7 ) {
						cM = 10;
//						System.out.println("43");
					}
				
//					System.out.println(cM);
					
				}
				System.out.println("cM==>"+cM);
				

				
				tM = dolM / 2;
				lM = dolM % 2;
				qM = cM / 25;
				dM = cM % 25 / 10;
				nM = cM % 25 % 10 /5;
				
					
				
				System.out.println("Toonies:"+ dolM/2); 
				System.out.println("Loonies:"+ dolM%2); 
				
				System.out.println("Quarters:"+ cM/25);
				System.out.println("Dimes:"+ cM%25/10);
				System.out.println("Nickels:"+ cM%25%10/5);
				System.out.println("penny:"+ cM%25%10%5);
			
				System.out.println("Toonies:"+ tM); 
				System.out.println("Loonies:"+ lM); 
				
				System.out.println("Quarters:"+ qM);
				System.out.println("Dimes:"+ dM);
				System.out.println("Nickels:"+ nM);
				
				info.close();
				
//			}			
		
		} catch (Exception e) {
			System.out.println("error==>"+e);
			
		}
	}

}
