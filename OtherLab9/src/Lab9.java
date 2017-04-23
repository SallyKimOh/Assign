import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Lab9 {
	
	
	public static void main(String [] args) {
	
	boolean done = false;
	Scanner input = new Scanner(System.in);
	char choice;
		Bank1 bank = new Bank1();
	//
	
	
	while(!done) {
	System.out.println("****************");
	System.out.println("BANKING SYSTEM");
	System.out.println("****************");
	System.out.println("a - Add new bank account \nd - display information of a single accoun                          t \nu - Update account" + "\nm - Run monthly update \ne - Enter details from a file \np - Print all accounts \np - Quit \nEnter your option: ");
	
	choice = input.nextLine().charAt(0);
	
	
	if(choice == 'a' || choice =='A')
		bank.addAccount();
	else if(choice == 'd' || choice =='D')
	bank.displayAccount();
	else if(choice == 'u' || choice =='U')
		bank.updateAccount();
	else if(choice == 'm' || choice =='M')
		bank.monthlyUpdate();
	else if(choice == 'e' || choice == 'E')
		bank.readFromFile();
	else if(choice == 'p' || choice=='P')
		bank.printAccountDetails();
	else if(choice == 'q' || choice =='Q') {
		System.out.println("Goodbye have a nice day");
		done =true;

	
	}
	
	else
		System.out.println("Invalid option.. try again");		
		
	}

}
}