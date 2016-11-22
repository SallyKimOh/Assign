import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Sally Kim
 *
 */
public class Lab6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner info = new Scanner(System.in);
		System.out.print("Number of stars: ");
		int cnt = 0;
		
		while(true){
			try {
				cnt = info.nextInt();
				if ((cnt < 1) ||(cnt > 20 )) {
					System.out.print("Enter a valid number: ");
				} else {
					for(int i = 0 ; i < cnt; i++) {
						for (int j = 0; j <= i; j++) {
							System.out.print("*");
						}
						System.out.print("\n");
					}
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please input a number.");
				System.exit(0);
			}
			
		}
		
	}

}
