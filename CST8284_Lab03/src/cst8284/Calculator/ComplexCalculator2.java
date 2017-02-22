package cst8284.Calculator;

public class ComplexCalculator2 {
	
	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex2 c;
	
	public ComplexCalculator2(Complex2 c1, Complex2 c2){
		
		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /, @");
		char mathOp = op.nextLine().charAt(0);
		
		switch (mathOp){
		   case '+':
		      c = plus(c1, c2);
		      break;
		   case '-':
			  //TODO: Call the method for the subtraction of two complex numbers here
		      c = subtract(c1, c2);
		      break;
		   case '*':
			  //TODO: Call the method for the multiplication of two complex numbers here
		      c = multiply(c1, c2);
		      break;
		   case '/':
		      //TODO: Call the method for the division of two complex numbers here
		      c = divide(c1, c2);
		      break;
		   case '@':
			  //TODO: Call the method for the multiplication of two complex numbers here
			  c = multiplication(c1, c2);
			  break;
		   default:
			  System.out.println("Unknown operation requested");
		}
		
	}

	public ComplexCalculator2(int c1, int c2){
		
		System.out.println("Do you wish to perform to modulus?  Enter %");
		char mathOp = op.nextLine().charAt(0);
		
		switch (mathOp){
		   case '%':
			  //TODO: Call the method for the modulus of two complex numbers here
			  c = modulus(c1, c2);
			  break;
		   default:
			  System.out.println("Unknown operation requested");
		}
		
	}
	
	
	private Complex2 plus(Complex2 c1, Complex2 c2){
		double real = c1.getReal() + c2.getReal();
		double imag = c1.getImag() + c2.getImag();
		
		return(new Complex2(real, imag));
	}

   //TODO Uncomment the following block of code and write code to perform the appropriate
   // math operations, as outlined in the appendix.  See the plus() method above for help.
	
	private Complex2 subtract(Complex2 c1, Complex2 c2){
		return (new Complex2(c1.getReal()-c2.getReal(),c1.getImag()-c2.getImag()));
	}
	
	private Complex2 multiply(Complex2 c1, Complex2 c2){
		double real = (c1.getReal() * c2.getReal())-(c1.getImag() * c2.getImag());
		double imag = (c1.getReal()*c2.getImag()) + (c2.getReal()*c1.getReal());
		
		return(new Complex2(real, imag));

	}
	
	//after check=====
	private Complex2 divide(Complex2 c1, Complex2 c2){		
	 //TODO: check for possible division by 0 and output an error message to the screen
	 //return a constructor with value 0 + 0i);
		double div = Math.pow(c2.getReal(),2) + Math.pow(c2.getImag(), 2);
		double real,imag;
		if (div == 0.0) {
			real = 0;imag = 0;
		} else {	
			real = ((c1.getReal() * c2.getReal())+(c1.getImag() * c2.getImag()))/div;
			imag = ((c2.getReal() * c1.getImag())-(c1.getReal() * c2.getImag()))/div;
		}
//		double real = ((c1.getReal() * c2.getReal())+(c1.getImag() * c2.getImag()))/(c2.getReal()*c2.getReal() + c2.getImag()*c2.getImag());
//		double imag = ((c2.getReal() * c1.getImag())-(c1.getReal() * c2.getImag()))/(c2.getReal()*c2.getReal() + c2.getImag()*c2.getImag());
		
		return(new Complex2(real, imag));
	} 


	private Complex2 multiplication(Complex2 c1, Complex2 c2){		
		 //TODO: check for possible division by 0 and output an error message to the screen
		 //return a constructor with value 0 + 0i);
		double div = c2.getReal() * c2.getReal() - c2.getImag()*c2.getImag();
		System.out.println(div);
		double real,imag;

		if (div == 0.0) {
			real = 0;imag = 0;
		} else {
			real = ((c1.getReal() * c2.getReal())+(c1.getImag() * c2.getImag()))/div;
			imag = ((c1.getReal() * c2.getImag())-(c1.getImag() * c2.getImag()))/div;
		}
		c = new Complex2(real, imag);
		System.out.println(c.toString());
		return conjugate();
	} 

	
	
	public Complex2 conjugate(){
		return new Complex2(c.getReal(), -c.getImag());
	}
	

	private Complex2 modulus(int num1,int num2){
		
		return new Complex2(num1%num2);
//		return new Complex(String.valueOf(Math.sqrt(c.getReal()*c.getReal() + c.getImag()*c.getImag())));
	}
	
	
	//TODO: write a getter called getComplexResult() that returns the Complex number stored in this class
	public Complex2 getComplexResult(){
		return c;
	}

//TODO: write a method called toString() that returns the string value of the Complex number generated
//above and stored in this class, i.e. it must return a String in the form "a + Bi" or "a - Bi" 
//depending on whether B is positive or negative.  For example, it wouldn't make much sense to write
//the output of a calculation as 3.0 +-2.0i; you should write it as 3.0 - 2.0i.  So be certain you
//code addresses the problem of writing the output correctly if B is a negative number

	public String toString(){
		if (c.toString().matches(".*-.*")) {
			return c.toString().replace("+ -", "- ");
		}
		return c.toString();
		
	}

}
