import java.util.Scanner;

public class SavingsAccount1 extends BankAccount1{
private double interestRate, minBalance;

public String toString() {
	return super.toString() +  " | " + interestRate + " | " + minBalance ;
}

public boolean addBankAccount() {
	super.addBankAccount();
	Scanner input = new Scanner(System.in);
	System.out.println("Enter interest rate :");
	interestRate = input.nextDouble();
	System.out.println("Enter minimum balance : ");
	minBalance = input.nextDouble();
	
	return true;
}


	@Override
	public void monthlyAccountUpdate() {
		
		// TODO Auto-generated method stub
		if(minBalance > balance)
			System.out.println(".....Insufficient funds for interest addition");
		else {
			balance += interestRate*balance;
	}


}
	public boolean readFile(Scanner bankFile) {
		boolean isOK = super.readFile(bankFile);

		if(!isOK) 
			return false;

		if(bankFile.hasNextDouble()) {
			interestRate = bankFile.nextDouble();
			if(interestRate < 0) {
				System.out.println("Invalid interest rate");
				return false;
			}
		}else {
			System.out.println("Invalid data");
			return false;
		}
		
		if(bankFile.hasNextDouble()) {
			minBalance = bankFile.nextDouble();
			if(minBalance < 0) {
				System.out.println("Invalid minimum Balance");
				return false;
			}
		}else {
			System.out.println("Invalid data");
			return false;
		}


		return true;
	}
	
}
