package de.zeroco.main;

public class StringUtility {
	
	public static void main(String[] args) {
		System.out.println("hi");
        System.out.println(formatSentence(" "));
//        System.out.println(reverse(null));
        System.out.println(printString(6, 'a'));
	}
	
	/**
	 * Format sentence by guidelines of sentence case
	 * 
	 * @author Tejaswini.S
	 * @since 2024-12-30
	 * @param input
	 * @return String of formatted sentence
	 * @throws NULLException
	 */
	public static String formatSentence(String input) {
		if (input == null) return null;
		input = input.replaceAll("\\s+", " ");
		String[] splitByDot = input.split("\\.");
		String res = "";
		for(int i = 0; i < splitByDot.length; i++) {
			splitByDot[i] = splitByDot[i].trim();
			String sentence = splitByDot[i].substring(0, 1).toUpperCase() + splitByDot[i].substring(1);
			String[] splitByComma = sentence.split("\\,");
			String joinByComma = "";
			for(int j = 0; j < splitByComma.length; j++) {
				splitByComma[j] = splitByComma[j].trim();
				joinByComma += ", " + splitByComma[j];
			}
			res += joinByComma.substring(2) + ". ";
		}
		return res;
	}
	
//	/**
//	 * Reverse given string
//	 * 
//	 * @author Tejaswini.S
//	 * @since 2024-12-30
//	 * @param input
//	 * @return String after reversed
//	 * @throws NULLException
//	 */
//	public static String reverse(String input) {
//		if (input == null) return null;
//		String reverse = "";
//		for(int i = input.length() - 1; i >= 0; i --) {
//			reverse = reverse + input.charAt(i);		
//		}
//		return reverse;		
//	}
	
	/** 
	 * Print character given number of times
	 * 
	 * @author Tejaswini.S
	 * @since 2-01-2025
	 * @param number
	 * @param ch
	 * @return print char number of times
	 */
	
	public static String printString(int number, char ch) {
		String res = "";
		for (int i = 1; i <= number; i ++) {
			res = res + ch;		
		}
		return res;
	}
	
}
