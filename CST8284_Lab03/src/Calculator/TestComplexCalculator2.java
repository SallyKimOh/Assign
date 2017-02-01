package Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestComplexCalculator2 {
	
   private static Scanner input = new Scanner(System.in);
   private static int choice = 0;
   private static ComplexCalculator2 calc;
   private static int seq = 0; //input date sequence;
   private static String[] orderName = {"first","second"};	
   
   
   //Code execution starts here
   public static void main(String[] args) {

      System.out.println("Welcome to the Complex Calculator\n");
      
      while(true){   //loop until 'Q' entered by user, below
    	 Complex2 c1 = TestComplexCalculator2.getComplexNumber();  // read in the 1st complex number
    	 Complex2 c2 = TestComplexCalculator2.getComplexNumber();  // read in the 2nd complex number
    	 calc = new ComplexCalculator2(c1, c2);                   // perform the calculation
         System.out.println("The result is: " + calc.toString());  // output the result

         System.out.println ("Do you wish to continue? Enter Q to quit or enter B to show the bonus or anything else to continue");
         seq = 0;
         
         char simple = input.next().toUpperCase().charAt(0);

         if (simple=='Q') {
        	 System.out.println("Thank you. See you next time");
        	 break;
         // press 'Q' to quit, otherwise loop
         } else if (simple=='B') {
        	 int mod = TestComplexCalculator2.getNumber();
             System.out.println("The result is: " + mod);  // output the result
         // press 'Q' to quit, otherwise loop
         }
         
         
         if (input.next().toUpperCase().charAt(0)=='Q') {
        	 System.out.println("Thank you. See you next time");
        	 break;
         // press 'Q' to quit, otherwise loop
         } else if (input.next().toUpperCase().charAt(0)=='B') {
        	 int mod = TestComplexCalculator2.getNumber();
             System.out.println("The result is: " + mod);  // output the result
         // press 'Q' to quit, otherwise loop
         }
      }
   }
   
   // Static method requests and returns a complex number from user
   private static Complex2 getComplexNumber(){
	   
   	   choice = TestComplexCalculator2.displayTypeInputMenu();

   	   input.nextLine();
//       System.out.print("Enter a complex number ");
       System.out.print("Enter the "+orderName[seq++]+" complex number ");
       
       switch(choice){
       
          case 1:								      //Single string input
         	 System.out.println("as a single string, e.g. 4-3i");
        	 String strComplex = input.next();
    	     return(new Complex2(strComplex));         //Call 1-String constructor
    	     
          case 2:								      // Two string input
         	 System.out.println("as two separate strings, with a space in between, e.g. 4 -3i");
        	 String strReal = input.next(), strImag = input.next();
    	     return(new Complex2(strReal, strImag));  //Call 2-String constructor
    	     
          case 3:									 // Two int input
         	 while(true) {
	         	 try {
	             	 System.out.println("as two integers, where the 2nd int is the imaginary number, e.g. 4 3");
	             	int iReal = input.nextInt(), iImag = input.nextInt();
	        	     return(new Complex2(iReal, iImag));      //Call 2-integer constructor
	         	 } catch (InputMismatchException e) {
	         		 System.out.println("Input data is not matched. Try again");
	             	 input.next();
	         	 }
         	 }
         	 
//        	 int iReal = input.nextInt(), iImag = input.nextInt();
//    	     return(new Complex(iReal, iImag));      //Call 2-integer constructor
    	     
          default:
        	 System.out.println("Bad input choice; exiting\n");
        	 System.exit(0);
        	 return(new Complex2());    //not used, but required: JVM expects a Complex return type
       }
   }

   
   private static int getNumber(){
	   
       System.out.print("Enter the two integers, e.g. 4 3 number ");
       
   	 do {
       	 try {
           	int num1 = input.nextInt();
           	int num2 = input.nextInt();
           	while(num2 < 1) {
                System.out.print("Enter the Second number. It must bigger than 0 ");
                num2 = input.nextInt();
           	}
           	 calc = new ComplexCalculator2(num1,num2);
           	 calc.getComplexResult().getMod();
      	     return calc.getComplexResult().getMod();
       	 } catch (InputMismatchException e) {
       		 System.out.println("Input data is not matched. Try again");
           	 input.next();
           	 
       	 }
   	 } while(true);
         	 
   }
   
 
   
   //Standard menu method; prompts user to enter input type for Complex constructor
   private static int displayTypeInputMenu(){
      System.out.printf("%s\n\t%s\n\t%s\n\t%s", 
    	"Enter the format of the complex number to be entered:", 
  		"1. A single string",
        "2. 2 strings",
        "3. 2 integer values\n");
      return(input.nextInt());
   }
   
}
