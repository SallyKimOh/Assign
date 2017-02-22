package test.cst8284.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import cst8284.Calculator.Complex;
import cst8284.Calculator.ComplexCalculator;

public class CalculatorTest {
	@Test
	public void testEqualsComplex() {

		Complex c = new Complex(2,2);
	
		ComplexCalculator cal = new ComplexCalculator();
		
		assertTrue(cal.equals(c));

	}


	@Test
	public void testSubtract() {

		Complex c1 = new Complex("2+3i");
		Complex c2 = new Complex("4+1i");

		Complex c3 = new Complex("2-3i");
		Complex c4 = new Complex("4+1i");
		
		ComplexCalculator cal = new ComplexCalculator();

		assertTrue(cal.subtract(c1, c2).toString().equals("-2.0 + 2.0i"));
		assertTrue(cal.subtract(c3, c4).toString().equals("-2.0 - 4.0i"));

	}
	
	@Test
	public void testMultiply() {

		Complex c1 = new Complex(2,3);
		Complex c2 = new Complex("4+1i");

		ComplexCalculator cal = new ComplexCalculator();

//		System.out.println(cal.multiply(c1, c2));
		
		assertTrue(cal.multiply(c1, c2).toString().equals("5.0 + 14.0i"));

	}
	
	@Test
	public void testDivide() {

		Complex c1 = new Complex(7,3);
		Complex c2 = new Complex(1,1);

		ComplexCalculator cal = new ComplexCalculator();

		System.out.println("div:"+cal.divide(c1, c2));
		System.out.println("div2:"+cal.divide2(c1, c2));
		
		assertFalse(cal.divide(c1, c2).toString().equals("5.0 + 14.0i"));

	}

	@Test
	public void testDivide2() {

		Complex c1 = new Complex(2,2);
		Complex c2 = new Complex(0,0);

		ComplexCalculator cal = new ComplexCalculator();

		System.out.println("div22:"+cal.divide2(c1, c2));
		
		assertTrue(cal.divide(c1, c2).toString().equals("0.0 + 0.0i"));

	}
	
	@Test
	public void testConjugate() {

		Complex c2 = new Complex("4","5i");

		ComplexCalculator cal = new ComplexCalculator();

		System.out.println(cal.conjugate(c2));
		
		assertTrue(cal.conjugate(c2).toString().equals("4.0 - 5.0i"));

	}

	@Test
	public void testPlus() {

		Complex c1 = new Complex("7+8i");
		Complex c2 = new Complex("2","3i");

		ComplexCalculator cal = new ComplexCalculator();

//		System.out.println(cal.plus(c1, c2));
		
		assertTrue(cal.plus(c1,c2).toString().equals("9.0 + 11.0i"));

	}
	
	@Test
	public void testTostring() {

		Complex c1 = new Complex("0-5i");

		System.out.println("tostring:"+c1.toString());
		
		assertTrue(c1.toString().equals("0.0 - 5.0i"));

	}
	
	@Test
	public void testGetReal() {

		Complex c = new Complex(2,9);

		System.out.println("tostring:"+c.getReal());
		
		assertTrue(c.getReal() == 2);

	}

	@Test
	public void testComplexStringString() {
		Complex c = new Complex("3","-2i");
		
		assertTrue(c.getReal() == 3);
		assertFalse(c.getImag() == 2);
	}
	
	@Test
	public void testComplexIntInt() {
		Complex c = new Complex(7,12);
		
		System.out.println(c.toString());
		assertTrue(c.toString().equals(new Complex("7+12i").toString()));
		assertTrue(c.toString().equals("7.0 + 12.0i"));
	}

	@Test
	public void testComplex() {
		Complex c = new Complex();
		Complex c1 = new Complex(2,3);
		assertFalse(c.equals(c1));
		assertNotNull(c);
		
	}
	
	@Test
	public void testComplexString() {
		Complex c = new Complex("2+3i");
		assertNotNull(c);
		
	}
	
	@Test
	public void testComplexStringArray() {

		Complex c = new Complex("2+3i");
		String[] str = {"2","3i"};
		
//		System.out.println("1==>"+c.toString());
//		System.out.println("2==>"+new Complex(str).toString());
		
		assertEquals(c.toString(), new Complex(str).toString());
	}
	
	
	
	

	
}
