import java.util.Scanner;

public class ChequingAccount1 extends BankAccount1 {

	private double fee;

	public String toString() {
		return super.toString() + "|" + fee;
	}


	public boolean addBankAccount()  {
		super.addBankAccount();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter fee : ");
		fee = input.nextDouble();
		return true;
	}

	public void monthlyAccountUpdate() {
		if(fee > balance)
			System.out.println(".....Insufficient funds for fee withdrawal");
		else
			balance -= fee;
	}

	public boolean readFile(Scanner bankFile) {
		boolean isOK = super.readFile(bankFile);

		if(!isOK) 
			return false;

		if(bankFile.hasNextDouble()) {
			fee = bankFile.nextDouble();
			if(fee < 0) {
				System.out.println("Invalid fee");
				return false;
			}
		}else {
			System.out.println("Invalid data");
			return false;
		}


		return true;
	}


}


