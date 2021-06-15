package com.m.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Map<Integer, List<Integer>> indexMultiples = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < integers.length; i++) {

			indexMultiples.put(i, getMultiples(integers, i));
		}

		int luckyTriplets = 0;
		for (int i = 0; i < integers.length - 1; i++) {

			luckyTriplets += getLuckyTripletsFromMultiplesMap(indexMultiples, i);
		}
		return luckyTriplets;
	}

	private static int getLuckyTripletsFromMultiplesMap(Map<Integer, List<Integer>> indexMultiples, int n) {

		int sum = 0;

		for (int i = 0; i < indexMultiples.get(n)
				.size(); i++) {

			sum += indexMultiples.get(indexMultiples.get(n)
					.get(i))
					.size();
		}

		return sum;
	}

	private static List<Integer> getMultiples(int[] integers, int n) {

		List<Integer> multiples = new ArrayList<>();
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
