import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sally Kim
 *
 */
public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Employee emp = new Employee();
		Scanner info = new Scanner(System.in);
		
		System.out.print("What is your FirstName:");
		String fName = info.nextLine();
		
		System.out.print("What is your LastName:");
		String lName = info.nextLine();
		
		System.out.print("How much is your Salary per monthly:");
		double mSalary = info.nextInt();
		
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setMonthSalary(mSalary);
		
		emp.display();
		
		
		  
		
		
		
	}

}
