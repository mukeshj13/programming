package com.m.dynamic;

import java.util.HashMap;
import java.util.Map;

public class BrickStaircases {

	private static Map<String, Long> cacheNumberStaircasesForNBricks = new HashMap<String, Long>();

	public static void main(String[] args) {

		int bricks = 600;
		Long start = System.currentTimeMillis();
		long numberOfStaircases = getStaircases(bricks, Integer.MAX_VALUE, true);
		Long end = System.currentTimeMillis();
		System.out.println(numberOfStaircases);
		System.out.println("Time taken " + (end - start) + " ms");

	}

	/*
	 * For n bricks returns number of staircases can be formed with minimum 2
	 * stairs and no double steps
	 */
	private static long getStaircases(int n, int k, boolean multilevelOnly) {

		if (n == k) {

			multilevelOnly = true;
		}
		/*
		 * for n less than 3 ie 1 or 2 there is only one stair case possob;e
		 */
		if (n < 3) {
			if (k <= n) {
				return 0;
			}
			return 1;
		}

		/*
		 * for n =3, if multilevel is allowed only, then only one combination is
		 * there ie 2,1. Otherwise we have 2 possible staircases [3] and [2,1]
		 */
		if (n == 3) {
			if (k < n) {
				return 0;
			}
			if (multilevelOnly) {
				return 1;
			}
		}

		/*
		 * refer from the in-memory cache
		 */
		String cacheKey = n + "-" + k;
		if (cacheNumberStaircasesForNBricks.get(cacheKey) != null) {

			return cacheNumberStaircasesForNBricks.get(cacheKey);
		}

		long numberOfStaircases = multilevelOnly || k < n ? 0 : 1;

		for (int i = 1; n - i > 0; i++) {

			if (n - i < k) {

				numberOfStaircases += getStaircases(i, n - i, false);
			}
		}

		cacheNumberStaircasesForNBricks.put(cacheKey, numberOfStaircases);
		return numberOfStaircases;
	}

}
