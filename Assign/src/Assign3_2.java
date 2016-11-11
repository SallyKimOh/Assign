/** 
 * @author Sae il Kim    
 * @course CST8110  
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 10. 29.
 *
 * @Modify_User
 * @Modify_date 2016. 10. 29.
 */

public class Assign3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CodeBreaker cb = new CodeBreaker();
		for (int i = 1; i<= 6; i++) {
			cb.getGuess(i);
//			cb.checkGuess();
			
			if (cb.done()) {
				break;
//			} else {	
			
//				if (i == 6) {
//					System.out.println("You lose");
//				}
			}	
		}
		cb.display();

	}

}
