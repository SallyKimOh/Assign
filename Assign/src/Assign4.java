import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Sae il Kim  
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 11. 18.
 *
 * @Modify_User
 * @Modify_date 2016. 11. 18.
 */

public class Assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		
			Scanner input = new Scanner(System.in);
			
			System.out.print("How many tries does a player get? ");
			int limit = input.nextInt();
	
			while(limit < 1 || limit >20){
				System.out.println("Please enter a number between 1 and 20 ");
				System.out.print("How many tries does a player get? ");
				limit = input.nextInt();
			} 
			
			System.out.print("How many letters in the code? ");
			int letterCnt = input.nextInt();
				
			while(letterCnt < 1 || letterCnt >20){
				System.out.println("Please enter a number between 1 and 20 ");
				System.out.print("How many letters in the code? ");
				letterCnt = input.nextInt();
			}
			  
			
			
			CodeBreaker4 cb = new CodeBreaker4(limit,letterCnt);
			for (int i = 1; i<= limit; i++) {
	//			cb.getGuess(i);
	//			cb.checkGuess(i);
	//			if (cb.done())	break;
				if (cb.done())	break;
				else cb.getGuess(i);
				if (cb.done())	break;
				else cb.checkGuess(i);
			
			}
			cb.display();
		} catch (InputMismatchException e) {
			System.out.println("Please enter a number.");
		} catch (Exception ex) {
			System.out.println("Unexpected Error. Please try again.");
		}

	}

}
