package cst8284.speedTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void test() {

		System.out.print("geStringFromFile() method takes ");
		showTestResult(() -> WordDump.getStringFromFile());

		System.out.print("getStringBuilderFromFile() method takes ");
		showTestResult(() -> WordDump.getStringBuilderFromFile());

		System.out.print("getArrayListFromFile() method takes ");
		showTestResult(() -> WordDump.getArrayListFromFile());

		assertTrue(true);
	}

	private static <T> T showTestResult(TimeTestInterface<T> run) {
		long startTime = System.currentTimeMillis();
		T t = (T) run.methodUnderTest();
		System.out.println((float) (System.currentTimeMillis() - startTime) / 1000 + " seconds");
		return (t);
	}

}
