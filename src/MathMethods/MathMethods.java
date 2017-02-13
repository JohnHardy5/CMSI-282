/*
 * Written by: John Hardy
 */

package MathMethods;//TODO: Delete package before submitting

import java.math.BigInteger;

public class MathMethods {
	
	static java.math.BigInteger factorial(int n) {
		if (n == 0) {return new BigInteger("1");}
		BigInteger result = BigInteger.valueOf(n);
		for (int i = n - 1; i > 1; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
	
	static java.math.BigInteger fibonacci(int n) {
		BigInteger first = new BigInteger("0");
		BigInteger second = new BigInteger("1");
		if (n == 1) {return second;}
		BigInteger third = new BigInteger("0");
		for (int i = 1; i < n; i++) {
			third = first.add(second);
			first = second;
			second = third;
		}
		return third;
	}
	
	static long gcd(long m, long n) {
		return 0L;
	}
	
	static long lcm(long m, long n) {
		return 0L;
	}
	
	static double poly(double x, double[] coeff) {
		double result = coeff[coeff.length - 1];
		for (int i = coeff.length - 2; i >= 0; i--) {
			result = (x * result) + coeff[i];
		}
		return result;
	}
	
	static double power(double x, int n) {
		return 0.0;
	}
	
	static double root(int n, double x, double epsilon) {
		return 0.0;
	}
	
	static double sqrt(double x, double epsilon) {
		return 0.0;
	}
	
	public static void main(String[] args) {
    	String operation = args[0];
    	switch (operation) {
    	case "factorial":
    		System.out.println(factorial(Integer.parseInt(args[1])));
    		break;
    	case "fibonacci":
    		System.out.println(fibonacci(Integer.parseInt(args[1])));
    		break;
    	case "gcd":
    		System.out.println(gcd(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
    		break;
    	case "lcm":
    		System.out.println(lcm(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
    		break;
    	case "poly":
    		double[] coeff = new double[args.length - 2];
    		for (int i = 2; i < args.length; i++) {
    			coeff[i - 2] = Double.parseDouble(args[i]);
    		}
    		System.out.println(poly(Double.parseDouble(args[1]), coeff));
    		break;
    	case "power":
    		System.out.println(power(Double.parseDouble(args[1]), Integer.parseInt(args[2])));
    		break;
    	case "root":
    		System.out.println(root(Integer.parseInt(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3])));
    		break;
    	case "sqrt":
    		System.out.println(sqrt(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
    		break;
    	default:
    		throw new IllegalArgumentException("Given operation was not specified correctly.");
    	}
    }
	
}
