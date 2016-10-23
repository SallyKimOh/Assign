import java.util.Scanner;

public class GivingTip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cost = 0;
		int tip = 0;
		double total = 0.0;
		
		
		Scanner info = new Scanner(System.in);
		
		System.out.print("How much does your meal cost? ");
		
		cost = info.nextInt();
		
		System.out.print("How much % do you want to give for tip? ");
		tip = info.nextInt();

		total = cost+cost*(tip*0.01);
		System.out.println("Now you will pay "+ (cost+cost*(tip*0.01)));
		System.out.println("Now you will pay "+ total);
		System.out.println(10*0.15);

		
	}

}
