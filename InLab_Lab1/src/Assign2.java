
/**
 * @author Sae il Kim
 * @course CST8110
 * @section 320
 * @Lab_professor Wei Gong
 * 
 * @Create_User
 * @Create_date 2016. 10. 19.
 *
 * @Modify_User
 * @Modify_date 2016. 10. 20.
 */

public class Assign2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		
			AgeCalculator ac = new AgeCalculator();
			ac.enterData();
			ac.calculateMessage();
			ac.displayResults();
		} catch (Exception e) {
			System.out.println("You have to input exact numbers.");
			
		}
	
		
	}

}
