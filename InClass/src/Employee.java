/**
 * 
 */

/**
 * @author ssang_000
 *
 */
public class Employee {

	
	private String firstName;	//FirstName

	private String lastName;	//LastName
	
	private double monthSalary;	//Monthly Salary
	
	
	public Employee(){		// Default Constractor and Class Member initialized
		firstName = new String();
		lastName = new String();
		monthSalary = 0.0;
		
	}
	
	public Employee(String fName, String lName, double salary) {
		
		firstName = fName;
		lastName = lName;
		monthSalary = salary;
	}

		

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public double getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(double mSalary) {
		this.monthSalary = mSalary;
	}

	public void display() {
	
		System.out.println("Name :" + firstName + " " +lastName+", Salary:"+monthSalary);
	}
	
	
}
