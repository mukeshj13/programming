package com.m.ds.adt.array;

public class SortedRotatedArraySearch {

	public static void main(String[] args) {

		int[] arr = { 19, 23, 45, 261, 4, 7, 12 };
		int index = findNumber(arr, 4);
		System.out.println(index);
	}

	private static int findNumber(int[] arr, int n) {

		return findNumber(arr, 0, arr.length - 1, n);
	}

	private static int findNumber(int[] arr, int start, int end, int n) {

		if (start < end) {
			int mid = (end + start) / 2;
			if (n > (arr[mid])) {

				if (isPivotBetween(arr, mid, end)) {

					end = getValidEndIndex(arr, mid, end);

				} else {
					if (n > arr[end]) {
						start = getValidEndIndex(arr, start, mid);
					}
				}
				return findNumber(arr, mid, end, n);

			} else if (n < (arr[mid])) {
				if (isPivotBetween(arr, start, mid)) {

					start = getValidStartIndex(arr, start, mid);

				} else {
					if (n < arr[start]) {
						start = getValidStartIndex(arr, mid, end);
						mid = end;
					}
				}
				return findNumber(arr, start, mid, n);
			} else {

				return mid;
			}
		}
		return -1;
	}

	private static int getValidStartIndex(int[] arr, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] > arr[start]) {
				return getValidStartIndex(arr, mid + 1, end);
			} else {
				return getValidStartIndex(arr, start, mid);
			}
		}

		return start + 1;
	}

	private static int getValidEndIndex(int[] arr, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] < arr[start]) {
				return getValidEndIndex(arr, start, mid);
			} else {
				return getValidEndIndex(arr, mid + 1, end);
			}
		}
		return start - 1;
	}

	private static boolean isPivotBetween(int[] arr, int start, int end) {

		return arr[start] > arr[end];
	}

}
