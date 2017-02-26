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
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		for (int i = 0; i < n; i++) {
			BigInteger temp = a;
			a = b;
			b = temp.add(b);
		}
		return a;
	}
	
	static long gcd(long m, long n) {
		if (n == 0) { return m;}
		return gcd(n, m % n);
	}
	
	static long lcm(long m, long n) {
		if (m == 0) {return 0;}
		return (m * n) / gcd(m, n);
	}
	
	static double poly(double x, double[] coeff) {
		double result = coeff[coeff.length - 1];
		for (int i = coeff.length - 2; i >= 0; i--) {
			result = (x * result) + coeff[i];//Backwards Horner's rule
		}
		return result;
	}
	
	static double power(double x, int n) {
		if (n == 0) {return 1.0;}
		if (n == 1) {return x;}
		if (n % 2 == 1) {
			return x * power(x, n - 1);
		} else {
			double temp = power(x, n / 2);
			return temp * temp;
		}
	}
	
	static double root(int n, double x, double epsilon) {
		if (n <= 0 || (x < 0 && n % 2 == 0) ) {throw new IllegalArgumentException("BAD DATA");}
		if (x == 1.0) {return 1.0;}
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x *= -1;
		}
		double lowerBnd = 0;
		double upperBnd = (x > 0 && x < 1) ? 1.0 : x;
		double midPnt = setMidPoint(lowerBnd, upperBnd);
		double estimate = power(midPnt, n);
		while (isOutsideEpsilon(estimate, x, epsilon)) {
			if (estimate > x) {
				upperBnd = midPnt;
			} else {
				lowerBnd = midPnt;
			}
			midPnt = setMidPoint(lowerBnd, upperBnd);
			estimate = power(midPnt, n);
		}
		if (isNegative) {
			midPnt *= -1;
		}
		return midPnt;
	}
	
	private static double setMidPoint(double lowerBnd, double upperBnd) {
		return  (lowerBnd + upperBnd) / 2.0;
	}
	
	private static boolean isOutsideEpsilon(double estimate, double x, double epsilon) {
		return Math.abs(estimate - x) > epsilon;
	}
	
	static double sqrt(double x, double epsilon) {
		return root(2, x, epsilon);
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
    		System.out.println(root(
    				Integer.parseInt(args[1]),
    				Double.parseDouble(args[2]),
    				Double.parseDouble(args[3]
    		)));
    		break;
    	case "sqrt":
    		System.out.println(sqrt(
    				Double.parseDouble(args[1]), 
    				Double.parseDouble(args[2])
    		));
    		break;
    	default:
    		throw new IllegalArgumentException("BAD DATA");
    	}
    }
	
}
