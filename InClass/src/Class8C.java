import java.util.Scanner;

public class Class8C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner info = new Scanner(System.in);
		
//		Start TemperatureCalculator
//		WHILE user wants to continue (Choice == ‘1’)
//		PUT Enter temperature
//		GET Temperature
//		CalcTemp  Temperature* 9 / 5 + 32
//		PUT “Converted temperature is” CalcTemp
//		PUT Do you want to do another
//		GET Choice
//		ENDWHILE
//		End TemperatureCalculator
		
		String choice = "Y";
		float cTemp;
		float calcTemp;
		
		while (choice.equals("Y")) {
			System.out.print("Enter the Temperature :");
			cTemp = info.nextFloat();

			if (cTemp > 200 || cTemp < -50) {
				System.out.println("Invalid - reenter");
			} else {
			
				calcTemp = cTemp * 9.0f/5.0f + 32;
				System.out.println("Converted temperature is " + calcTemp);
			}
			
			if (cTemp == 0) {
				System.out.println("freezing point");
				
			}else if (cTemp == 100) {
				System.out.println("boiling point");
					
			}else if (cTemp == 200) {
				System.out.println("very hot day!!");
			}else if (cTemp == -50) {
				System.out.println("very cold day!!");
			}else if (cTemp == -20) {
				System.out.println("cold winter day");
			
			}
			System.out.print("Do you want to do another?(Yes:Y No:N) ");
			choice = info.next().toUpperCase();
			
		}
			
		
		
		
		
	}

}
