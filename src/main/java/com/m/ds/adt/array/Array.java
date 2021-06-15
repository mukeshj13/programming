package com.m.ds.adt.array;

/**
 * 
 * @author mukesh.kumar
 *
 */
public class Array {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		int[] arr_rotated = rotate(arr, 2);
		printArray(arr_rotated);
	}

	protected static void printArray(int[] arr_rotated) {

		for (int i = 0; i < arr_rotated.length; i++) {
			System.out.print(arr_rotated[i]);
			System.out.print(" ");
		}

	}

	protected static int[] rotate(int[] arr, int d) {
		int[] arr_rotated = new int[3];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {

			index = (i - d + arr.length) % arr.length;
			arr_rotated[i] = arr[index];
		}
		return arr_rotated;
	}
}
