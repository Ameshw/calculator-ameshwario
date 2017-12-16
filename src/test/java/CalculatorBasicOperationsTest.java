import java.util.Random;

import org.junit.Test;

import org.junit.Assert;

public class CalculatorBasicOperationsTest {

	private CalculatorBasicOperationsInterface basic = new CalculatorBasicOperations();
	private Random random = new Random();
	
	private double random() {
		return random.nextInt(100000) - 50000;
	}
	
	@Test
	public void testAdd() {
		
		System.out.println("Testing add function - basic");
		
		Assert.assertEquals(3.0, basic.add(1, 2), 0);
		Assert.assertEquals(0.0, basic.add(-1, 1), 0);
		Assert.assertEquals(-5.0, basic.add(5, -10), 0);
		
		System.out.println("Testing add function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(i + x, basic.add(i, x), 0);
		}
		
	}
	
	@Test
	public void testSubtract() {
		
		System.out.println("Testing subtract function - basic");
		
		Assert.assertEquals(-1.0, basic.substract(1, 2), 0);
		Assert.assertEquals(-2.0, basic.substract(-1, 1), 0);
		Assert.assertEquals(15.0, basic.substract(5, -10), 0);
		
		System.out.println("Testing subtract function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(i - x, basic.substract(i, x), 0);
		}
	
	}
	
	@Test
	public void testDivide() {
		
		System.out.println("Testing divide function - basic");
		
		Assert.assertEquals(0.5, basic.divide(1, 2), 0);
		Assert.assertEquals(-1.0, basic.divide(-1, 1), 0);
		Assert.assertEquals(-0.5, basic.divide(5, -10), 0);
		
		System.out.println("Testing divide function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(i / x, basic.divide(i, x), 0);
		}
	}
	
	@Test
	public void testMultiply() {
		
		System.out.println("Testing multiply function - basic");
		
		Assert.assertEquals(2.0, basic.multiply(1, 2), 0);
		Assert.assertEquals(-1.0, basic.multiply(-1, 1), 0);
		Assert.assertEquals(-50.0, basic.multiply(5, -10), 0);
		
		System.out.println("Testing multiply function - random");
		
		for (double i = 0; i < 50; i++) {
			double x = random();
			Assert.assertEquals(i * x, basic.multiply(i, x), 0);
		}
	}	
}
