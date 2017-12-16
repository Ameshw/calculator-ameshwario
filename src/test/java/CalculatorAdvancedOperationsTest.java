import java.util.Random;

import org.junit.Test;

import org.junit.Assert;

public class CalculatorAdvancedOperationsTest {
	
	private CalculatorAdvancedOperationsInterface advanced = new CalculatorAdvancedOperations();
	private Random random = new Random();
	
	private double random() {
		return random.nextInt(100000) - 50000;
	}
	
	@Test
	public void testLog() {
		
		System.out.println("Testing log function - basic");
		
		Assert.assertEquals(1.0, advanced.log(10), 0);
		Assert.assertEquals(2.0, advanced.log(100), 0);
		Assert.assertEquals(Double.NEGATIVE_INFINITY, advanced.log(0), 0);
		Assert.assertEquals(Double.NaN, advanced.log(-10), 0);
	
		System.out.println("Testing log function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(Math.log10(x), advanced.log(x), 0);
		}
		
	}
	
	@Test
	public void testAbsolute() {
		
		System.out.println("Testing absolute function - basic");
		
		Assert.assertEquals(10.0, advanced.absolute(10), 0);
		Assert.assertEquals(100.0, advanced.absolute(100), 0);
		Assert.assertEquals(0.0, advanced.absolute(0), 0);
		Assert.assertEquals(10.0, advanced.absolute(-10), 0);
		
		System.out.println("Testing absolute function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(Math.abs(x), advanced.absolute(x), 0);
		}
	}
	
	@Test
	public void testCube() {
		
		System.out.println("Testing cube function - basic");
		
		Assert.assertEquals(1000.0, advanced.cube(10), 0);
		Assert.assertEquals(1000000.0, advanced.cube(100), 0);
		Assert.assertEquals(0.0, advanced.cube(0), 0);
		Assert.assertEquals(-1000.0, advanced.cube(-10), 0);
		
		System.out.println("Testing cube function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(Math.pow(x, 3), advanced.cube(x), 0);
		}
	}
	
	@Test
	public void testInverse() {
		
		System.out.println("Testing inverse function - basic");
		
		Assert.assertEquals(0.1, advanced.inverse(10), 0);
		Assert.assertEquals(0.01, advanced.inverse(100), 0);
		Assert.assertEquals(Double.POSITIVE_INFINITY, advanced.inverse(0), 0);
		Assert.assertEquals(-0.1, advanced.inverse(-10), 0);
		
		System.out.println("Testing inverse function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(1.0/x, advanced.inverse(x), 0);
		}
	}
	
	@Test
	public void testSqrt() {
		
		System.out.println("Testing sqrt function - basic");
		
		Assert.assertEquals(10.0, advanced.sqrt(100), 0);
		Assert.assertEquals(100.0, advanced.sqrt(10000), 0);
		Assert.assertEquals(0.0, advanced.sqrt(0), 0);
		Assert.assertEquals(Double.NaN, advanced.sqrt(-100), 0);
		
		System.out.println("Testing sqrt function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(Math.sqrt(x), advanced.sqrt(x), 0);
		}
	}
	
	@Test
	public void testSquare() {
		
		System.out.println("Testing square function - basic");
		
		Assert.assertEquals(100.0, advanced.square(10), 0);
		Assert.assertEquals(10000.0, advanced.square(100), 0);
		Assert.assertEquals(0.0, advanced.square(0), 0);
		Assert.assertEquals(100.0, advanced.square(-10), 0);
		
		System.out.println("Testing square function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(Math.pow(x, 2), advanced.square(x), 0);
		}
	}
	
	@Test
	public void testPower() {
		
		System.out.println("Testing power function - basic");
		
		Assert.assertEquals(100.0, advanced.square(10), 0);
		Assert.assertEquals(10000.0, advanced.square(100), 0);
		Assert.assertEquals(0.0, advanced.square(0), 0);
		Assert.assertEquals(100.0, advanced.square(-10), 0);
		
		System.out.println("Testing power function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(Math.pow(x, i), advanced.power(x, i), 0);
		}
	}
	
}
