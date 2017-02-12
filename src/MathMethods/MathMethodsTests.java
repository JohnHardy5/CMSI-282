/*
 * Written by: John Hardy
 */

package MathMethods;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathMethodsTests {

	@Test
	public void testFactorial() {
		assertEquals(MathMethods.factorial(0), 1L);
		assertEquals(MathMethods.factorial(1), 1L);
		assertEquals(MathMethods.factorial(5), 120L);
		assertEquals(MathMethods.factorial(10), 3628800L);
		assertEquals(MathMethods.factorial(20), 2432902008176640000L);
	}
	
	@Test
	public void testFibonacci() {
		assertEquals(MathMethods.fibonacci(0), 0L);
		assertEquals(MathMethods.fibonacci(1), 1L);
		assertEquals(MathMethods.fibonacci(2), 1L);
		assertEquals(MathMethods.fibonacci(10), 55L);
		assertEquals(MathMethods.fibonacci(50), 12586269025L);
	}

	@Test
	public void testGcd() {
		assertEquals(MathMethods.gcd(0, 0), 0L);
		assertEquals(MathMethods.gcd(1, 1), 1L);
		assertEquals(MathMethods.gcd(100, 10), 10L);
		assertEquals(MathMethods.gcd(18, 57), 3L);
		assertEquals(MathMethods.gcd(12, 5), 1L);
	}
	
	@Test
	public void testLcm() {
		assertEquals(MathMethods.lcm(0, 0), 0L);
		assertEquals(MathMethods.lcm(1, 1), 1L);
		assertEquals(MathMethods.lcm(2, 4), 8L);
		assertEquals(MathMethods.lcm(30, 45), 90L);
		assertEquals(MathMethods.lcm(12, 80), 240L);
	}
	
	@Test
	public void testPoly() {
		assertEquals(MathMethods.poly(0.0, new double[]{1.0} ), 1.0, 0.001);
		assertEquals(MathMethods.poly(1.0, new double[]{0.0, 0.0, 1.0} ), 1.0, 0.001);
		assertEquals(MathMethods.poly(3.3, new double[]{6.9, 0.3, -18.3, 4.5} ), -29.68, 0.001);
		assertEquals(MathMethods.poly(-0.5, new double[]{0.0, -44.2, -22, 0.0, 0.0, 369.1} ), 5.06, 0.001);
	}
	
	@Test
	public void testPower() {
		assertEquals(MathMethods.power(0.0, 0), 1.0, 0.001);
		assertEquals(MathMethods.power(1.0, 1000000000), 1.0, 0.001);
		assertEquals(MathMethods.power(2.0, 2), 4.0, 0.001);
		assertEquals(MathMethods.power(Math.PI, 2), 9.86, 0.001);
		assertEquals(MathMethods.power(Math.E, 7), 1096.63, 0.001);
		assertEquals(MathMethods.power(123.45, 12), 1.2528328e25, 0.001);
	}
	
	@Test
	public void testRoot() {
		assertEquals(MathMethods.root(1, 0.2, 0.001), 0.2, 0.001);
		assertEquals(MathMethods.root(3, 27.0, 0.001), 3.0, 0.001);
		assertEquals(MathMethods.root(24, 16777216.0, 0.001), 2.0, 0.001);
		assertEquals(MathMethods.root(8, 456.02, 0.001), 2.14, 0.001);
	}
	
	@Test
	public void testSqrt() {
		assertEquals(MathMethods.sqrt(0.0, 0.001), 0.0, 0.001);
		assertEquals(MathMethods.sqrt(4.0, 0.001), 2.0, 0.001);
		assertEquals(MathMethods.sqrt(100.0, 0.001), 10.0, 0.001);
		assertEquals(MathMethods.sqrt(Math.E, 0.001), 1.64, 0.001);
	}
	
}
