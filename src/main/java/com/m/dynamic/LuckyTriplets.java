package com.m.dynamic;

import java.util.LinkedList;
import java.util.List;

public class LuckyTriplets {

	public static void main(String[] args) {

		int[] integers = new int[2000];

		for (int i = 1; i < 2001; i++) {

			integers[i - 1] = i;
		}
		long start = System.currentTimeMillis();
		int n = findLuckyTriplets(integers);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
		System.out.println(n);

	}

	private static int findLuckyTriplets(int[] integers) {

		List<Integer>[] indexMultiples = new LinkedList[integers.length];

		for (int i = 0; i < integers.length; i++) {

			indexMultiples[i] = getMultiples(integers, i);
		}

		int luckyTriplets = 0;
		for (int i = 0; i < integers.length - 1; i++) {

			luckyTriplets += getLuckyTripletsFromMultiplesMap(indexMultiples, i);
		}
		return luckyTriplets;
	}

	private static int getLuckyTripletsFromMultiplesMap(List<Integer>[] indexMultiples, int n) {

		int sum = 0;

		for (int i = 0; i < indexMultiples[n].size(); i++) {

			sum += indexMultiples[(indexMultiples[n].get(i))].size();
		}

		return sum;
	}

	private static List<Integer> getMultiples(int[] integers, int n) {

		List<Integer> multiples = new LinkedList<>();
		for (int i = n + 1; i < integers.length; i++) {

			if (isMultiple(integers[n], integers[i])) {

				multiples.add(i);
			}
		}
		return multiples;
	}

	/*
	 * if b is the multiple of a
	 */
	private static boolean isMultiple(int a, int b) {

		return b % a == 0;
	}

}
