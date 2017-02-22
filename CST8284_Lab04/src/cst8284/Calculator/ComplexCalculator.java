package cst8284.Calculator;

public class ComplexCalculator {
	
	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex c;
	private String errorMsg = "";
	
	public ComplexCalculator(Complex c1, Complex c2){
		
		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /");
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
//		      c = divide(c1, c2);
		      c = divide2(c1, c2);
		      break;
		   default:
			  System.out.println("Unknown operation requested");
		}
		
	}
	
	public ComplexCalculator(){
		
	}
	
	public boolean equals(Complex c) {
		if (c.getReal() == c.getImag()) return true;
		else return false;			
	}
	
	public Complex plus(Complex c1, Complex c2){
		double real = c1.getReal() + c2.getReal();
		double imag = c1.getImag() + c2.getImag();
		
		return(new Complex(real, imag));
	}

	
	public Complex subtract(Complex c1, Complex c2){
		return (new Complex(c1.getReal()-c2.getReal(),c1.getImag()-c2.getImag()));
	}
	
	public Complex multiply(Complex c1, Complex c2){
		double real = (c1.getReal() * c2.getReal())-(c1.getImag() * c2.getImag());
		double imag = (c1.getReal()*c2.getImag()) + (c2.getReal()*c1.getImag());
		
		return(new Complex(real, imag));

	}
	
	public Complex divide(Complex c1, Complex c2){		
	 //TODO: check for possible division by 0 and output an error message to the screen
	 //return a constructor with value 0 + 0i);
		double div = Math.pow(c2.getReal(),2) + Math.pow(c2.getImag(), 2);
		double real,imag;
		if (div == 0.0) {
			real = 0;imag = 0;
			errorMsg = "Divide-by-zero error detected";
		} else {	
			real = ((c1.getReal() * c2.getReal())+(c1.getImag() * c2.getImag()))/div;
			imag = ((c2.getReal() * c1.getImag())-(c1.getReal() * c2.getImag()))/div;
		}
		return(new Complex(real, imag));
	} 


	public Complex divide2(Complex c1, Complex c2){		

		Complex c3 = multiply(c1,conjugate(c2));

		double denom = multiply(c2,conjugate(c2)).getReal();
		if (denom == 0.0) {
			c3.setReal(0);
			c3.setImag(0);
			errorMsg = "Divide-by-zero error detected";
			return (new Complex(0, 0));
		} else {
			return (new Complex(c3.getReal()/denom, c3.getImag()/denom));
			
		}
			
	} 

	
	
	public Complex conjugate(Complex c2){
		return new Complex(c2.getReal(), -c2.getImag());
	}
	
	
	public Complex getComplexResult(){
		return c;
	}


	public String toString(){
		if (c.toString().matches(".*-.*")) {
			return c.toString().replace("+ -", "- ");
		}
		return errorMsg + "\n"+c.toString();
		
	}

}
