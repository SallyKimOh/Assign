
public class Person1 {
	
	private String firstName, lastName, emailAddress;
	private long phoneNumber;
	
	public Person1(String fName, String lName, long pNum, String email) {

		firstName = fName;
		lastName = lName;
		phoneNumber = pNum; 
		emailAddress = email;

	}
	public String getName() {

		return firstName + " " + lastName;
	}

	public long getPhoneNumber() {

		return phoneNumber;
	}

		public String getEmailAddress() {

		return emailAddress;
	}

}
