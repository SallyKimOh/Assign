import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class Lab5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Polish notation calculator");
			System.out.print("Please enter an operation:");
			Scanner stdin = new Scanner(System.in);

			String operation = "";;
			double firstNum = 0.0;
			double secondNum = 0.0;

			double calc = 0.0;
	
			while(true) {
				operation = stdin.nextLine();
				if ((!operation.equals("*"))&&(!operation.equals("/"))&&(!operation.equals("%"))&&(!operation.equals("+"))&&(!operation.equals("-"))) {
					System.out.print("Please enter a valid operation:");
				} else {
					break;
				}
			}
			
			System.out.print("First number: ");
			firstNum = stdin.nextDouble();
			
//			while(firstNum <= 0) {
//				System.out.print("Please pick a non-zero number:");
//				firstNum = stdin.nextDouble();
//			}
			System.out.print("Second number: ");
			secondNum = stdin.nextDouble();
			if (operation.equals("%")||operation.equals("/")) {
				while(secondNum == 0) {
					System.out.print("Please pick a non-zero number:");
					secondNum = stdin.nextDouble();
				}
				
			}
			switch (operation) {
				case "*": 
					calc = (firstNum*secondNum);
					break;
				case "/": 
					calc = (firstNum / secondNum);
					break;
				case "%": 
					calc = (firstNum % secondNum);
					break;
				case "+": 
					calc = (firstNum + secondNum);
					break;
				case "-": 
					calc = (firstNum - secondNum);
					break;
			}
		
			System.out.println(firstNum +" "+operation+" " + secondNum + " = " + calc);
		
		} catch (InputMismatchException e) {
			System.out.println("Have to input non-zero number.\n Could you start again.");
		}
		
		
	}

}
