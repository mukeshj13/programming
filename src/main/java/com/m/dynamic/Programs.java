package com.welldyne.mx.web.setup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.welldyne.common.utilities.utilities.RequestUtility;

public class Test {

	private static String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private static int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	static Map<String, Integer> romanToInt = new HashMap<String, Integer>() {
		{
			put("M", 1000);
			put("CM", 900);
			put("D", 500);
			put("CD", 400);
			put("C", 100);
			put("XC", 90);
			put("L", 50);
			put("XL", 40);
			put("X", 10);
			put("IX", 9);
			put("V", 5);
			put("IV", 4);
			put("I", 1);
		}
	};

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		var a = EmailValidator.getInstance()
				.isValid("select email from wdportal.users@gmail.com");

		System.out.println(intToRoman(1929));

		Random rand = new Random();
		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		String transactionId = String.valueOf(System.nanoTime() + randomNum);
		System.out.println(RequestUtility.generateRequestTransactionId());
		System.out.println();

		System.out.println(UUID.randomUUID()
				.toString());

		printBoard(new char[][] { { '.', '.', '9', '7', '4', '8', '.', '.', '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2', '.', '1', '.', '9', '.', '.', '.' }, { '.', '.', '7', '.', '.', '.', '2', '4', '.' }, { '.', '6', '4', '.', '1', '.', '5', '9', '.' }, { '.', '9', '8', '.', '.', '.', '3', '.', '.' }, { '.', '.', '.', '8', '.', '3', '.', '2', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '6' }, { '.', '.', '.', '2', '7', '5', '9', '.', '.' } });
		var start = System.currentTimeMillis();
		// solveSudoku(new char[][] { { '.', '.', '9', '7', '4', '8', '.', '.',
		// '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2',
		// '.', '1', '.', '9', '.', '.', '.' }, { '.', '.', '7', '.', '.', '.',
		// '2', '4', '.' }, { '.', '6', '4', '.', '1', '.', '5', '9', '.' }, {
		// '.', '9', '8', '.', '.', '.', '3', '.', '.' }, { '.', '.', '.', '8',
		// '.', '3', '.', '2', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.',
		// '6' }, { '.', '.', '.', '2', '7', '5', '9', '.', '.' } });
		var end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");

		int[] arr = new int[] { 9, 10, 283, 0, 38, -4, 4, 1, 27 };
		mergeSort(arr, 0, 4);
		printArray(arr);
		rotateLeft(arr, 2);
		printArray(arr);

		System.out.println(getQuotient(1100540749, 1090366779));

		System.out.println(solution("0081"));

		printTitleCase();
	}

	private static void rotateLeft(int[] arr, int d) {

		int[] buffer = new int[d];
		for (int i = 0; i < d; i++) {
			buffer[i] = arr[i];
		}
		for (int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}
		for (int i = 0; i < d; i++) {
			arr[i + (arr.length - d)] = buffer[i];
		}
	}

	public static void mergeSort(int[] arr, int l, int r) {

		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void printArray(Object[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void merge(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		/*
		 * Prepare the two arrays to merge
		 */
		int[] lA = new int[n1];
		int[] rA = new int[n2];

		for (int i = 0; i < n1; i++) {
			lA[i] = arr[i + l];
		}
		for (int i = 0; i < n2; i++) {
			rA[i] = arr[i + m + 1];
		}
		int i = 0, j = 0;
		while (i < n1 && j < n2) {

			if (lA[i] < rA[j]) {
				arr[l] = lA[i++];
			} else {
				arr[l] = rA[j++];
			}
			l++;
		}

		while (i < n1) {
			arr[l++] = lA[i++];
		}

		while (j < n2) {
			arr[l++] = rA[j++];
		}
	}

	public static String intToRoman(int num) {
		if (num == 0) {
			return "";
		}
		if (num == 4) {
			return "IV";
		}
		if (num == 9) {
			return "IX";
		}
		if (num == 10) {
			return "X";
		}
		StringBuilder sb = new StringBuilder();
		if (num < 4) {
			while (num-- > 0) {
				sb.append("I");
			}
			return sb.toString();
		}
		if (num < 9) {
			sb.append("V");
			while (num-- > 5) {
				sb.append("I");
			}
			return sb.toString();
		}
		if (num < 40) {
			int highestDecimalDigit = num / 10;
			while (highestDecimalDigit-- > 0) {
				sb.append("X");
			}
			sb.append(intToRoman(num % 10));
			return sb.toString();
		}
		if (num > 39 && num < 50) {
			return "XL" + intToRoman(num % 40);
		}
		if (num < 90) {
			sb.append("L")
					.append(intToRoman(num - 50));
			return sb.toString();
		}
		if (num > 89 && num < 100) {
			return "XC" + intToRoman(num % 90);
		}
		if (num < 400) {
			int highestDecimalDigit = num / 100;
			while (highestDecimalDigit-- > 0) {
				sb.append("C");
			}
			sb.append(intToRoman(num % 100));
			return sb.toString();
		}
		if (num > 399 && num < 500) {
			return "CD" + intToRoman(num % 400);
		}
		if (num < 900) {
			sb.append("D")
					.append(intToRoman(num - 500));
			return sb.toString();
		}
		if (num > 899 && num < 1000) {
			return "CM" + intToRoman(num % 900);
		}
		if (num == 50) {
			return "L";
		}
		if (num == 100) {
			return "C";
		}
		if (num == 500) {
			return "D";
		}
		if (num == 1000) {
			return "M";
		}
		int ks = num / 1000;
		while (ks-- > 0) {
			sb.append("M");
		}
		return sb.append(intToRoman(num % 1000))
				.toString();
	}

	public static int romanToInt(String s) {
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (int i = charArray.length - 1; i > 0; i--) {
			if (i > 0) {
				sb.delete(0, sb.length());
				String sym = sb.append(charArray[i - 1])
						.append(charArray[i])
						.toString();
				if (romanToInt.containsKey(sym)) {
					sum += romanToInt.get(sym);
				} else {
					sum += romanToInt.get(String.valueOf(charArray[i]));
				}
			} else {
				sum += romanToInt.get(String.valueOf(charArray[i]));
			}
		}
		return sum;
	}

	static char probableChar = '1';
	static boolean expStreak;
	static Stack<Move> expMoveHistory = new Stack<>();

	@SuppressWarnings("unchecked")
	public static void solveSudoku(char[][] board) {
		Set<Character>[] rowSets = new HashSet[9];
		Set<Character>[] colSets = new HashSet[9];
		Set<Character>[] boxSets = new HashSet[9];

		/*
		 * prepare sets
		 */
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (rowSets[i] == null) {
					rowSets[i] = new HashSet<Character>();
				}
				if (colSets[j] == null) {
					colSets[j] = new HashSet<Character>();
				}
				int boxIndex = i / 3 * 3 + j / 3;
				if (boxSets[boxIndex] == null) {
					boxSets[boxIndex] = new HashSet<Character>();
				}
				if (board[i][j] != '.') {
					rowSets[i].add(board[i][j]);
					colSets[j].add(board[i][j]);
					boxSets[boxIndex].add(board[i][j]);
				}
			}
		}
		boolean strongTraverse = false;
		while (!solved(rowSets)) {
			int identifiedElements = getIdentifiedElements(rowSets);
			traverse(board, rowSets, colSets, boxSets, strongTraverse);
			if (identifiedElements == getIdentifiedElements(rowSets)) {
				expStreak = strongTraverse = true;
			} else {
				strongTraverse = false;
			}
		}
		if (isValidSudoku(board)) {
			printBoard(board);
		}
	}

	private static int getIdentifiedElements(Set<Character>[] rowSets) {

		int count = 0;
		for (int k = 0; k < rowSets.length; k++) {
			count += rowSets[k].size();
		}
		return count;
	}

	private static void printBoard(char[][] board) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	static boolean solved(Set<Character>[] susdokuRowSets) {
		int k = 0;
		while (k < susdokuRowSets.length) {
			if (susdokuRowSets[k].size() < 9) {
				return false;
			}
			k++;
		}
		return true;
	}

	static void traverse(char[][] board, Set<Character>[] susdokuRowSets, Set<Character>[] susdokuColSets, Set<Character>[] susdokuBoxSets, boolean strong) {
		boolean strongPush = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (board[i][j] == '.') {
					List<Character> options = new ArrayList<>();
					char digitChar = '1';
					while (digitChar - '1' < 9) {
						if (!susdokuRowSets[i].contains(digitChar) && !susdokuColSets[j].contains(digitChar) && !susdokuBoxSets[i / 3 * 3 + j / 3].contains(digitChar)) {
							options.add(digitChar);
						}
						digitChar++;
					}
					// printArray(options.toArray());
					if (options.size() == 1 || (strong && !strongPush && options.size() == 2)) {
						var option = options.get(0);
						if (options.size() == 2) {
							option = options.get(((int) Math.random()) % 2);
							System.out.println(option);
						}

						board[i][j] = option;
						susdokuRowSets[i].add(option);
						susdokuColSets[j].add(option);
						susdokuBoxSets[i / 3 * 3 + j / 3].add(option);
						if (expStreak) {
							var move = new Move(i, j, option);
							expMoveHistory.push(move);
						}
						if (strong) {
							strongPush = true;
						}
					}

				}
			}
			if (expStreak && !isValidSudoku(board)) {
				while (!expMoveHistory.isEmpty()) {
					var move = expMoveHistory.pop();
					susdokuRowSets[move.row].remove(move.character);
					susdokuColSets[move.col].remove(move.character);
					susdokuBoxSets[move.row / 3 * 3 + move.col / 3].remove(move.character);
					board[move.row][move.col] = '.';

				}
				expStreak = false;
			}
		}
	}

	static class Move {
		int row, col;
		char character;

		Move(int row, int col, char ch) {
			this.row = row;
			this.col = col;
			this.character = ch;
		}
	}

	public static boolean isValidSudoku(char[][] board) {
		/*
		 * i rows and j columns
		 */
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!validRow(board, i, j) || !validColumn(board, i, j) || !validBox(board, i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean validRow(char[][] board, int i, int j) {
		int k = 0;
		while (k < 9) {
			if (k != i && board[i][j] == board[k][j]) {
				return false;
			}
			k++;
		}
		return true;
	}

	public static boolean validColumn(char[][] board, int i, int j) {
		int k = 0;
		while (k < 9) {
			if (k != j && board[i][j] == board[i][k]) {
				return false;
			}
			k++;
		}
		return true;
	}

	public static boolean validBox(char[][] board, int i, int j) {
		int m = i / 3 * 3, n = j / 3 * 3;
		for (int a = m; a < m + 3; a++) {
			for (int b = n; b < n + 3; b++) {
				if ((a != i || b != j) && board[a][b] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static int getQuotient(int num, int div) {
		if (num < div) {
			return 0;
		}
		int acc = div;
		int counter = 1, sum = 0;
		while (num >= acc) {
			System.out.println(num + " " + div);
			num -= acc;
			if (counter == 1) {
				sum++;
			} else {
				sum += counter;
			}
			if (acc < Integer.MAX_VALUE - acc) {
				acc += acc;
			}
			counter += counter;
		}

		return sum + getQuotient(num, div);
	}

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public static int solution(String S) {
		// write your code in Java SE 8
		int n = 0;
		char[] charArray = S.toCharArray();

		// find sum of digits
		int digit = 0, sum = 0;

		for (int i = 0; i < charArray.length; i++) {
			digit = Character.getNumericValue(charArray[i]);
			sum += digit;
		}

		// for each decimal place find number
		int targetComplement = 0, j = 0, size = 4;
		int remainder = 0;
		int[] nearMultiplesOfthree = new int[size];
		for (int i = 0; i < charArray.length; i++) {
			digit = Character.getNumericValue(charArray[i]);
			targetComplement = sum - digit;
			remainder = targetComplement % 3;

			size = remainder == 0 ? 4 : 3;
			if (remainder == 0) {
				nearMultiplesOfthree[0] = targetComplement;
			} else {
				nearMultiplesOfthree[0] = targetComplement + 3 - remainder;
			}

			for (int k = 1; k < size; k++) {
				nearMultiplesOfthree[k] = nearMultiplesOfthree[k - 1] + 3;
			}

			j = 0;
			while (j < 10) {
				for (int k = 0; k < size; k++) {
					if (j == nearMultiplesOfthree[k] - targetComplement && j != digit) {
						n++;
					}
				}
				j++;
			}

		}

		return sum % 3 == 0 ? n + 1 : n;
	}

	@SuppressWarnings("unchecked")
	private static void printTitleCase() throws JsonParseException, JsonMappingException, IOException {

		String declarationConstant = "private static final String ";
		var labels = "{\n" + "        \"titleRequestCovidAtHomeTests\": \"Request Covid At-Home Tests\",\n" + "        \"descriptionCovidSupply\": \"You may order up to 8 over-the-counter Covid At-Home tests per member per month. Some plans may require members to pay out-of-pocket for the tests and submit for reimbursement. If you have any questions, please call the WellDyne Member Services number listed on your ID card.\",\n" + "        \"titleProduct\": \"Product\",\n" + "        \"titleQuantity\": \"Quantity\",\n" + "        \"descriptionConfirmation\": \"By submitting this order, I agree that the OTC COVID-19 test is being purchased by the participant, beneficiary, or enrollee for personal use, not for employment purposes, has not been and will not be reimbursed by another source, and is not for resale.\"\n" + "      }";
		Map<String, String> labelMap = new ObjectMapper().readValue(labels, Map.class);

		StringBuilder sb = new StringBuilder();
		labelMap.forEach((k, v) -> {
			var words = StringUtils.splitByCharacterTypeCamelCase(k);
			System.out.print(declarationConstant);
			for (int i = 0; i < words.length; i++) {

				sb.append(words[i].toUpperCase());
				if (i < words.length - 1) {
					sb.append("_");
				}
			}
			System.out.println(sb.toString() + " = " + "\"" + k + "\"" + ";");
			sb.setLength(0);
		});

	}

}
