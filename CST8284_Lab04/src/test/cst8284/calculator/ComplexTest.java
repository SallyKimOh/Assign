package test.cst8284.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import cst8284.Calculator.Complex;

public class ComplexTest {
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
