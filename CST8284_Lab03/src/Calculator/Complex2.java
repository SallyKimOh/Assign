package Calculator;

public class Complex2 {
	private double real = 0;
	private double imag = 0;
	private int mod = 0;
	
	// Complex constructor that takes in a single string, e.g. 2-4i
	public Complex2(String cStr){
		this(cStr.split("(?=\\+)|(?=\\-)"));  // splits cStr at + or - into an array of two strings
	}
	
	// Complex constructor that takes in an array of two strings, e.g. cStr[0]="2", cStr[1]="-4i"
	public Complex2(String[] cStr){
		//TODO: chain the input from this constructor to the next constructor
		this(cStr[0],cStr[1]);
	}

	// Complex constructor that takes two separate strings as parameters, e.g. "2" and "-4i"
	public Complex2(String r, String i){
		//TODO: chain the input from this constructor to the next constructor
		// Note that this constructor needs to strip the 'i' from the string storing 
		// the imaginary number; it must pass only an integer to the next constructor, 
		// otherwise an error results
		this(Integer.parseInt(r),Integer.parseInt(i.substring(0, i.lastIndexOf("i"))));
		
	}
	
	// Complex constructor that takes in two ints as parameters, e.g. 2 and -4
	public Complex2(int r, int i){
		//TODO: chain the input from this constructor to the next constructor
		this((double)r,(double)i);
	}
	
	// Complex constructor that takes in two ints and stores them as floats, e.g. as 2.0 and -4.0
	public Complex2(double r, double i){
		this.setReal(r);
		this.setImag(i);
	}
	
	//default Complex constructor; required, but not used.  DO NOT ALTER
	public Complex2(){
	}

	public Complex2(int num) {
		this.setMod(num);
	}
	//TODO: Write a getter called getReal() that returns the real value of the Complex number
	public double getReal() {
		return real;
	}

	//TODO: Write a setter called setReal() that sets this class's real value equal to the parameter passed to the method
	public void setReal(double real) {
		this.real = real;
	}

	//TODO: Write a getter called getImag() that returns the imaginary value of the Complex number
	public double getImag() {
		return imag;
	}

	//TODO: Write a setter called setImag() that sets this class's imaginary value equal to the parameter passed to the method
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	

	//TODO: Write a getter called getComplex() that returns the Complex number itself
//	public double getComplex(){
//		return real+imag;
//	}
//	public String getComplex(){
//		return real +" + "+ imag +"i";
//	}

	public int getMod() {
		return mod;
	}

	public void setMod(int mod) {
		this.mod = mod;
	}

	public Complex2 getComplex(){
		return this;
	}
    //TODO: Write a method toString() that returns a string in the form "a + Bi" for this Complex number
	@Override
	public String toString() {
		return real +" + "+ imag +"i";
	}

	
	
	

}
