package com.m.ds.adt.algorithm;

public class ZigZagMatrix {

	public static void main(String[] args) {

//		int m = 5, n = 4;
//		int[][] arr = new int[m][n];
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//
//				arr[i][j] = (int) Math.random();
//			}
//		}

		int M[][] = { { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };
		printZigZagMatrix(M);
	}

	private static void printZigZagMatrix(int[][] arr) {

		int m = arr.length;
		int n = arr[0].length;
		for (int i = 0; i < m; i++) {

			printDiagonal(i, 0, arr);
		}

		for (int i = 1; i < n; i++) {

			printDiagonal(m - 1, i, arr);
		}
	}

	private static void printDiagonal(int a, int b, int[][] arr) {

		int m = arr.length;
		int n = arr[0].length;
		while (a < m && a >= 0 && b < n && b >= 0) {

			System.out.print(arr[a][b] + " ");
			a--;
			b++;
		}
		System.out.println("");
	}

}
