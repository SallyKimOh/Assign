import java.util.Scanner;

public abstract class BankAccount1 {
	// class should be abstract because public abstract void monthlyAccountUpdate(); is abstract method

	protected int accNumber;
	protected Person1 accHolder;
	protected double balance;

	BankAccount1() {

	}

//	BankAccount(int num, Person p, double bal) {
//
//		accNumber = num;
//		accHolder = p;
//		balance = bal;
//
//	}


	
	public String toString() {
		return accNumber + " | " + accHolder.getName() + " | " + accHolder.getPhoneNumber() + " | " + accHolder.getEmailAddress() + " | " + balance;
	}
	// define in bankaccount class 
	

	public boolean addBankAccount(){


		Scanner  input = new Scanner(System.in);

		long ph =0;
		String fName=null, lName=null, email=null;

		System.out.println("Enter Account number : ");
		accNumber = Integer.parseInt(input.nextLine());

		System.out.println("Enter first Name : ");
		fName = input.nextLine();
		System.out.println("Enterlast Name : ");
		lName = input.nextLine();

		System.out.println("Enter phone number : ");
		ph =Long.parseLong(input.nextLine());

		System.out.println("Enter email : ");
		email = input.nextLine();

		System.out.println("Enter balance : ");
		balance= Double.parseDouble(input.nextLine());

		accHolder= new Person1(fName, lName,ph, email);

		return true;
	} // if addBanking account ==true then add them to my arrayList


	public void updateBalance(double bal) {
		balance += bal;
	}


	public int getAccNumber() {
		return accNumber;
	}

	public abstract void monthlyAccountUpdate();

	public boolean readFile(Scanner bankFile) {
		if(bankFile.hasNextInt()) {
			accNumber = bankFile.nextInt();
		} else {
			System.out.println("Invalid account");
			return false;
		}
		
		String fName = bankFile.next();
		String lName = bankFile.next();
		long ph = 0;
		if(bankFile.hasNextLong()) {
			ph = bankFile.nextLong();
		}else {
			System.out.println("Invalid phone number in file");
			return false;
		}
		String email = bankFile.next();
		accHolder = new Person1(fName, lName, ph, email);
		
		if(bankFile.hasNextDouble()) {
			balance = bankFile.nextDouble();
		}else {
			System.out.println("Invalid balance in file");
			return false;
		}
		return true;
	}
	
	
} // based on account type

