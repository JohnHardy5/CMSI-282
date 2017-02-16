/*
 * Written by: John Hardy
 */

package MathMethods;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class MathMethodsTests {

	@Test
	public void testFactorial() {
		assertEquals(new BigInteger("1"), MathMethods.factorial(0));
		assertEquals(new BigInteger("1"), MathMethods.factorial(1));
		assertEquals(new BigInteger("120"), MathMethods.factorial(5));
		assertEquals(new BigInteger("3628800"), MathMethods.factorial(10));
		assertEquals(new BigInteger("2432902008176640000"), MathMethods.factorial(20));
	}
	
	@Test
	public void testFibonacci() {
		assertEquals(new BigInteger("0"), MathMethods.fibonacci(0));
		assertEquals(new BigInteger("1"), MathMethods.fibonacci(1));
		assertEquals(new BigInteger("1"), MathMethods.fibonacci(2));
		assertEquals(new BigInteger("55"), MathMethods.fibonacci(10));
		assertEquals(new BigInteger("12586269025"), MathMethods.fibonacci(50));
	}

	@Test
	public void testGcd() {
		assertEquals(0L, MathMethods.gcd(0, 0));
		assertEquals(1L, MathMethods.gcd(1, 1));
		assertEquals(10L, MathMethods.gcd(100, 10));
		assertEquals(3L, MathMethods.gcd(18, 57));
		assertEquals(1L, MathMethods.gcd(12, 5));
	}
	
	@Test
	public void testLcm() {
		assertEquals(0L, MathMethods.lcm(0, 0));
		assertEquals(1L, MathMethods.lcm(1, 1));
		assertEquals(4L, MathMethods.lcm(2, 4));
		assertEquals(90L, MathMethods.lcm(30, 45));
		assertEquals(240L, MathMethods.lcm(12, 80));
	}
	
	@Test
	public void testPoly() {
		assertEquals(1.0, MathMethods.poly(0.0, new double[]{1.0} ), 0.01);
		assertEquals(1.0, MathMethods.poly(1.0, new double[]{0.0, 0.0, 1.0} ), 0.01);
		assertEquals(-29.68, MathMethods.poly(3.3, new double[]{6.9, 0.3, -18.3, 4.5} ), 0.01);
		assertEquals(5.06, MathMethods.poly(-0.5, new double[]{0.0, -44.2, -22, 0.0, 0.0, 369.1} ), 0.01);
	}
	
	@Test
	public void testPower() {
		assertEquals(1.0, MathMethods.power(0.0, 0), 0.001);
		assertEquals(1.0, MathMethods.power(1.0, 1000000000), 0.01);
		assertEquals(4.0, MathMethods.power(2.0, 2), 0.001);
		assertEquals(9.86, MathMethods.power(Math.PI, 2), 0.01);
		assertEquals(1096.63, MathMethods.power(Math.E, 7), 0.01);
		assertEquals(1.2528328e25, MathMethods.power(123.45, 12), 1e18);
	}
	
	@Test
	public void testRoot() {
		assertEquals(0.2, MathMethods.root(1, 0.2, 0.001), 0.001);
		assertEquals(3.0, MathMethods.root(3, 27.0, 0.001), 0.001);
		assertEquals(2.0, MathMethods.root(24, 16777216.0, 0.001), 0.001);
		assertEquals(0.9594820623236890, MathMethods.root(8, Math.E - 2.0, 1e-15), 1e-15);
		assertEquals(2.14967589341, MathMethods.root(8, 456.02, 1e-10), 1e-10);
	}
	
	@Test
	public void testSqrt() {
		assertEquals(0.0, MathMethods.sqrt(0.0, 0.01), 0.01);
		assertEquals(2.0, MathMethods.sqrt(4.0, 0.001), 0.01);
		assertEquals(10.0, MathMethods.sqrt(100.0, 0.001), 0.01);
		assertEquals(0.37628, MathMethods.sqrt(Math.PI - 3.0, 1e-5), 1e-5);
		assertEquals(1.7724538509055160, MathMethods.sqrt(Math.PI, 1e-15), 1e-15);
	}
	
}
