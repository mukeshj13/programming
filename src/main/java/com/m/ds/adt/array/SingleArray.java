package com.m.ds.adt.array;

public class SingleArray extends Array {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 1, 65, 6 };
		int[] arr_rotated = rotate(arr, 3);
		printArray(arr_rotated);
	}

	protected static void printArray(int[] arr_rotated) {

		for (int i = 0; i < arr_rotated.length; i++) {
			System.out.print(arr_rotated[i]);
			System.out.print(" ");
		}

	}

	protected static int[] rotate(int[] arr, int d) {

		int[] temp = new int[arr.length - d];

		for (int i = 0; i < temp.length; i++) {

			temp[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {

			arr[i] = arr[(i + arr.length - d) % arr.length];

		}

		for (int i = d; i < arr.length; i++) {

			arr[i] = temp[i - d];
		}
		return arr;
	}
}
