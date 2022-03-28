package com.welldyne.ex.dao.edw.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.welldyne.common.utilities.utilities.DateTimeUtility;

class Test {
	public static void main(String args[]) {

		// PriorityQueue<Integer> intQ = new PriorityQueue<>();
		// // offer() and add() are used to add elements
		//
		// intQ.add(51);
		// intQ.offer(6);
		// intQ.add(72);
		// intQ.add(1);
		// intQ.add(2);
		// intQ.offer(3);
		// intQ.offer(4);
		// intQ.add(11);
		// intQ.add(19);
		//
		// System.out.println("Elements in this queue are: ");
		// System.out.println(intQ);
		//
		// // printing size of the queue
		// System.out.println("Size of this queue is: " + intQ.size());
		//
		// // removing values based on priority and printing them
		// System.out.println("Priority Queue:");
		// while (!intQ.isEmpty()) {
		// System.out.println(intQ.remove());
		// }
		//
		// var filePath = "Template.Kalsk-Jskaks/Workflow./name";
		//
		// System.out.println(DateTimeUtility.formatDateTime(LocalDateTime.now(),
		// DateTimeUtility.PRESENTATION_FORMATTER_DATE_TIME));
		//
		// int a = 48;
		// System.out.println(getStartingNumber(""));
		// System.out.println(2 << 1);
		// System.out.println(convert("PAYPALISHIRING", 4));
		// System.out.println(LocalDate.now()
		// .format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		// boolean[][] visited = new boolean[2][3];
		//
		// int z = visited.length;
		// System.out.println(z);
		// System.out.println(visited[0].length);
		//
		// int[][] matrix = { { 1, 5, 45, 0, 81 }, { 6, 7, 2, 82, 8 }, { 20, 22,
		// 49, 5, 5 }, { 0, 23, 50, 4, 92 } };
		// make_zeroes(matrix);
		// // print_matrix(matrix);
		//
		// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// map.put(1, 13);
		// map.put(2, 11);
		// map.put(3, -4);
		// map.put(4, 14);
		// map.put(5, 13);
		// map.put(6, 9);
		// map.entrySet()
		// .stream()
		// .sorted((entryA, entryB) -> entryA.getValue()
		// .compareTo(entryB.getValue()))
		// .forEach(entry -> System.out.println(entry.getKey() + " - " +
		// entry.getValue()));

		printTriplets(11);
	}

	public static Double getStartingNumber(String numberedString) {

		if (NumberUtils.isNumber(numberedString)) {
			return Double.parseDouble(numberedString);
		}
		StringBuilder sb = new StringBuilder();
		boolean decimal = false;
		char[] charArray = numberedString.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isDigit(charArray[i])) {
				sb.append(charArray[i]);
			} else if (!decimal && charArray[i] == '.') {
				sb.append(charArray[i]);
				decimal = true;
			} else {
				break;
			}
		}
		final var str = sb.toString();
		if (StringUtils.isEmpty(str)) {
			return 0d;
		}
		return Double.parseDouble(str);
	}

	public static String convert(String s, int numRows) {

		// finding the columns of the matrix
		final int stringLen = s.length();
		if (numRows < 2) {
			return s;
		}
		char[] charArray = s.toCharArray();
		final int unitSize = (numRows << 1) - 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < stringLen; j += unitSize) {
				sb.append(charArray[j + i]);
				if (i != 0 && i != numRows - 1 && j + unitSize - i < stringLen) {
					sb.append(charArray[j + unitSize - i]);
				}
			}
		}
		return sb.toString();
		// int charCounter = 0;
		// // numRows rows and n columns
		// char[][] zigZag = new char[numRows][n];
		// int columnCounter = 0;
		// for (int j = 0; j <= units; j++) {
		// if (j == units && remainingCharacters == 0) {
		// break;
		// }
		// for (int i = 0; i < numRows; i++) {
		// zigZag[i][columnCounter] = charArray[charCounter++];
		// if (charCounter == stringLen) {
		// break;
		// }
		// }
		// if (charCounter < stringLen) {
		// for (int k = numRows - 2; k > 0; k--) {
		// zigZag[k][++columnCounter] = charArray[charCounter++];
		// if (charCounter == stringLen) {
		// break;
		// }
		// }
		// }
		// columnCounter++;
		// }
		// StringBuilder sb1 = new StringBuilder();
		// for (int i = 0; i < numRows; i++) {
		// for (int j = 0; j < n; j++) {
		// if (zigZag[i][j] != Character.MIN_VALUE) {
		// sb1.append(zigZag[i][j]);
		// }
		// }
		// }
		//
		// return sb.toString();
	}

	public static int reverseBits(int n) {
		var charArray = Integer.toUnsignedString(n, 2)
				.toCharArray();
		char[] anotherCharArray = new char[32];
		char temp = '\u0000';
		for (int i = 0; i < 32; i++) {
			if (charArray.length - i - 1 >= 0) {
				anotherCharArray[i] = charArray[charArray.length - i - 1];
			} else {
				anotherCharArray[i] = '0';
			}
		}
		if (anotherCharArray[0] == '1') {
			return Integer.parseUnsignedInt(String.valueOf(anotherCharArray), 2);
		} else {
			return Integer.parseUnsignedInt(String.valueOf(anotherCharArray), 2);
		}
	}

	public static int reverse(int x) {
		final boolean positive = x > 0;
		int sum = 0;
		while (x != 0) {
			sum = x % 10 + sum * 10;
			if (positive) {
				if (sum > 100000000 && x % 10 > 2) {
					return 0;
				}
			} else if (sum < -100000000 && x % 10 < -2) {
				return 0;
			}
			x /= 10;
		}
		return sum;
		// while (!stack.isEmpty()) {
		// int addition = stack.pop();
		// if (i > 100000000 && Math.abs(addition) > 2) {
		// return 0;
		// }
		// // decimal place
		// addition = addition * i;
		// if (positive) {
		// if (Integer.MAX_VALUE - sum < addition) {
		// return 0;
		// }
		// } else if (Integer.MIN_VALUE - sum > addition) {
		// return 0;
		// }
		// sum += addition;
		// i *= 10;
		// }
		// return sum;
	}

	static int[][] make_zeroes(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		boolean[][] visited = new boolean[n][m];
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				System.out.println(j + " " + i + " " + matrix[j][i]);
				if (matrix[j][i] == 0) {
					System.out.println(j + " " + i + " " + matrix[j][i]);
					for (int a = 0; a < m; a++) {
						if (!visited[j][a]) {
							matrix[j][a] = 0;
							visited[j][a] = true;
						}
					}
					for (int a = 0; a < n; a++) {
						if (!visited[a][i]) {
							matrix[a][i] = 0;
							visited[a][i] = true;
						}
					}

				}
			}
		}
		return matrix;
	}

	static void print_matrix(int[][] m) {
		System.out.println();
		for (int i = 0; i < m.length; ++i) {
			for (int j = 0; j < m[i].length; ++j) {
				System.out.print(m[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public int solution(int[] A) {
		// write your code in Java SE 11
		Set<Integer> currItemSet = new HashSet<Integer>();
		int si = 1;
		for (int i = 0; i < A.length; i++) {
			if (si == A[i]) {
				si = getNextSmallestMissingInteger(currItemSet, si + 1);
			}
			currItemSet.add(A[i]);
		}
		return si;
	}

	public int getNextSmallestMissingInteger(Set<Integer> currItemSet, int start) {
		while (currItemSet.contains(start)) {
			start++;
		}
		return start;
	}

	public int solution2(int[] D, int X) {
		// write your code in Java SE 11

		int days = 1, firstMissionIndex = 0;
		for (int i = 0; i < D.length; i++) {

			if (!canBeCompletedToday(D, firstMissionIndex, i, X)) {
				days++;
				firstMissionIndex = i;
			}
		}
		return days;
	}

	private boolean canBeCompletedToday(int[] D, int startIndex, int currMissionIndex, int maxAllowedDiff) {
		while (startIndex < currMissionIndex) {
			if (Math.abs(D[startIndex] - D[currMissionIndex]) > maxAllowedDiff) {
				return false;
			}
			startIndex++;
		}

		return true;
	}

	// n being the limit
	public static void printTriplets(int n) {

		Set<Integer> tripletLows = new HashSet<Integer>();
		int complement = 0;
		for (int sqSumRoot = 2; sqSumRoot < n; sqSumRoot++) {
			for (int i = 1; i < sqSumRoot; i++) {
				complement = sqSumRoot * sqSumRoot - i * i;
				Integer sqRoot = intSqRoot(complement);
				if (sqRoot != null) {
					tripletLows.add(i);
					if (!tripletLows.contains(sqRoot))
						System.out.println(i + " " + sqRoot + " " + sqSumRoot);
				}
			}

		}
	}

	/*
	 * returns null if no int sq root
	 */
	public static Integer intSqRoot(int num) {

		int i = 0;
		while (i < num / 2) {
			if (i * i == num) {
				return i;
			}
			i++;
		}
		return null;
	}

	public static void solution(int N, int[] R, int[] C) {
		// board matrix with i rows and j columns
		int[][] board = new int[N][N];
		for (int k = 0; k < R.length; k++) {
			// denote the bomb with -1
			board[R[k]][C[k]] = -1;
			updateNeighbourCount(board, R[k], C[k]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == -1) {
					System.out.print('B');
				} else {
					System.out.print(board[i][j]);
				}
			}
			System.out.println();
		}
	}

	private static void updateNeighbourCount(int[][] board, int i, int j) {
		final int n = board.length;
		if (i == n - 1 || j == n - 1 || i == 0 || j == 0) {
			for (int a = i - 1; a < i + 2; a++) {
				for (int b = j - 1; b < j + 2; b++) {
					if (a >= 0 && b >= 0 && a < n && b < n) {
						// if not a bomb, increment count
						board[a][b] = board[a][b] == -1 ? -1 : board[a][b] + 1;
					}
				}
			}
		} else {
			for (int a = i - 1; a < i + 2; a++) {
				for (int b = j - 1; b < j + 2; b++) {
					// if not a bomb, increment count
					board[a][b] = board[a][b] == -1 ? -1 : board[a][b] + 1;
				}
			}
		}
	}


}
