import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class ChangeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inputDol = 0;  
		int inputCent = 0;
		
		
		Scanner info = new Scanner(System.in);
		ChangeMachine chM = new ChangeMachine();
		
		System.out.print("Input the Dollars: ");
		inputDol = info.nextInt();
		
		System.out.print("Input the Cents: ");
		inputCent = info.nextInt();
		
		chM.setAmountFromUser(inputDol, inputCent);
		
		chM.getAmountFromUser();
		chM.display();

	}

}
