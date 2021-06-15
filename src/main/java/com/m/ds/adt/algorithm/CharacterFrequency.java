package com.m.ds.adt.algorithm;

/**
 * 
 * @author mukesh.kumar
 *
 */
public class CharacterFrequency {

	public static void main(String[] args) {

		String string = "Lokesh Jumwal is a Nagarrian";

		char ch = 'z';
		int freq = findFrequency(string, ch);

		System.out.println("Frequency of " + ch + ": " + freq);
	}

	/**
	 * Finds frequency of a character that is a part of the Extended ASCII encoding
	 * in the provide string. It also prints the maximum occurring character in the
	 * string and its frequency.
	 * 
	 * @param string
	 * @param ch
	 * @return
	 */
	private static int findFrequency(String string, char ch) {

		if (string == null || string.length() == 0) {
			return 0;
		}
		int[] arr = new int[256];
		char[] charArray = string.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			arr[charArray[i]]++;
		}

		int max = Integer.MIN_VALUE, maxIndex = -1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		System.out.println("Maximun frequent character - '" + (char) maxIndex + "' It occurs " + max + " times");
		return arr[ch];

	}
}
