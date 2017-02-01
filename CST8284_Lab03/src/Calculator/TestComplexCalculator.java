package Calculator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TestComplexCalculator {
	
   private static Scanner input = new Scanner(System.in);
   private static int choice = 0;
   private static ComplexCalculator calc;
   private static int seq = 0; //input date sequence;
   private static String[] orderName = {"first","second"};	
   
   
   //Code execution starts here
   public static void main(String[] args) {

      System.out.println("Welcome to the Complex Calculator\n");
      
      while(true){   //loop until 'Q' entered by user, below
    	 Complex c1 = TestComplexCalculator.getComplexNumber();  // read in the 1st complex number
    	 Complex c2 = TestComplexCalculator.getComplexNumber();  // read in the 2nd complex number
    	 calc = new ComplexCalculator(c1, c2);                   // perform the calculation
         System.out.println("The result is: " + calc.toString());  // output the result

         System.out.println ("Do you wish to continue? Enter Q to quit or anything else to continue");
         if (input.next().toUpperCase().charAt(0)=='Q') {
        	 System.out.println("Thank you. See you next time");
        	 break;
         // press 'Q' to quit, otherwise loop
         }
      }
   }
   
   // Static method requests and returns a complex number from user
   private static Complex getComplexNumber(){
	   
   	   choice = TestComplexCalculator.displayTypeInputMenu();

   	   input.nextLine();
//       System.out.print("Enter a complex number ");
       System.out.print("Enter the "+orderName[seq++%2]+" complex number ");
//       System.out.print("Enter the "+((seq++%2)==0?"first":"second")+" complex number ");
       
       switch(choice){
       
          case 1:								      //Single string input
         	 System.out.println("as a single string, e.g. 4-3i");
        	 String strComplex = input.next();
        	 
        	 //============== validation check start ======================//
     	     Pattern pattern = Pattern.compile("^[0-9i{1}|-|+|-]*$");
        	 while(!pattern.matcher(strComplex).matches()) {
              	 System.out.println("Invalid String");
               	 System.out.println("as a single string, e.g. 4-3i");
               	 strComplex = input.next();
        	 }
           	 //============== validation check start ======================//
        	 
    	     return(new Complex(strComplex.trim()));         //Call 1-String constructor
    	     
          case 2:								      // Two string input
         	 System.out.println("as two separate strings, with a space in between, e.g. 4 -3i");
        	 String strReal = input.next(), strImag = input.next();

        	 //============== validation check start ======================//
     	     pattern = Pattern.compile("^[0-9i{1}|-|+|-]*$");
     	     while(!pattern.matcher(strImag).matches()) {
             	 System.out.println("Invalid String");
              	 System.out.println("2nd string is the imaginary string, e.g. 3i");
              	 strImag = input.next();
     	     }
        	 //============== validation check end ======================//
        	 
        	 return(new Complex(strReal, strImag));  //Call 2-String constructor
    	     
          case 3:									 // Two int input
         	 while(true) {
             	 System.out.println("as two integers, where the 2nd int is the imaginary number, e.g. 4 3");
             	 while(!input.hasNextInt()) {
	         		 System.out.println("Input data is not matched. Try again");
	             	 System.out.println("as two integers, where the 2nd int is the imaginary number, e.g. 4 3");
	         		 input.next();
             	 }
             	 int iReal = input.nextInt(), iImag = input.nextInt();
        	     return(new Complex(iReal, iImag));      //Call 2-integer constructor
         	 }
         	 
          default:
        	 System.out.println("Bad input choice; exiting\n");
        	 System.exit(0);
        	 return(new Complex());    //not used, but required: JVM expects a Complex return type
       }

   /*
    
       switch(choice){
       
          case 1:								      //Single string input
         	 System.out.println("as a single string, e.g. 4-3i");
        	 String strComplex = input.next();
    	     return(new Complex(strComplex));         //Call 1-String constructor
    	     
          case 2:								      // Two string input
         	 System.out.println("as two separate strings, with a space in between, e.g. 4 -3i");
        	 String strReal = input.next(), strImag = input.next();
    	     return(new Complex(strReal, strImag));  //Call 2-String constructor
    	     
          case 3:									 // Two int input
         	 System.out.println("as two integers, where the 2nd int is the imaginary number, e.g. 4 3");
        	 int iReal = input.nextInt(), iImag = input.nextInt();
    	     return(new Complex(iReal, iImag));      //Call 2-integer constructor
    	     
          default:
        	 System.out.println("Bad input choice; exiting\n");
        	 System.exit(0);
        	 return(new Complex());    //not used, but required: JVM expects a Complex return type
       }
    
     
     
    */
   
   
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
