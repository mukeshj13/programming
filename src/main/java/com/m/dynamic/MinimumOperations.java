package com.m.dynamic;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MinimumOperations {

	private static BigInteger zero = BigInteger.ZERO;
	private static BigInteger one = BigInteger.ONE;

	private static Map<BigInteger, BigInteger> cacheMap = new HashMap<BigInteger, BigInteger>();

	public static void main(String[] args) {

		BigInteger number = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
		long start = System.currentTimeMillis();
		BigInteger n = getMinimumOperations(number);
		long end = System.currentTimeMillis();
		System.out.println("The minimum operations are " + n);
		System.out.println("Time taken " + (end - start) + " ms");
	}

	private static BigInteger getMinimumOperations(BigInteger number) {

		if (number.compareTo(zero) == 0) {
			return one;
		}

		if (number.compareTo(one) == 0) {
			return zero;
		}

		if (cacheMap.get(number) != null) {
			return cacheMap.get(number);
		}
		BigInteger a;
		if (number.and(one)
				.equals(zero)) {

			a = min(getMinimumOperations(number.shiftRight(1)).add(one), minimumOperationsForNearestPowerOfTwo(number));
			cacheMap.put(number, a);
			return a;
		}

		a = min(getMinimumOperations(number.subtract(one)).add(one), getMinimumOperations(number.add(one)).add(one));
		cacheMap.put(number, a);
		return a;
	}

	private static BigInteger minimumOperationsForNearestPowerOfTwo(BigInteger number) {

		BigInteger count = new BigInteger("0");
		BigInteger greaterNearestPowerOfTwo = new BigInteger("1");
		BigInteger n = number;
		while (n.compareTo(zero) != 0) {

			n = n.shiftRight(1);
			count = count.add(one);
			greaterNearestPowerOfTwo = greaterNearestPowerOfTwo.shiftLeft(1);
		}

		return min(greaterNearestPowerOfTwo.subtract(number)
				.add(count), number.subtract(greaterNearestPowerOfTwo.shiftRight(1))
						.add(count)
						.subtract(one));
	}

	private static BigInteger min(BigInteger a, BigInteger b) {
		if (a.compareTo(b) < 0) {
			return a;
		} else {
			return b;
		}
	}

}
