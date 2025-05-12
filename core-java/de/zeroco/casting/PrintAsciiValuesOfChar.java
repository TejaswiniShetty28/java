package de.zeroco.casting;

public class PrintAsciiValuesOfChar {
	public static void main(String[] args) {
		System.out.println("hi");
		System.out.println(printAsciiValuesOfChar('a', 'z'));
	}

	public static String printAsciiValuesOfChar(char alphaOne, char alphaTwo) {
		String result = "";
		for (char i = alphaOne; i <= alphaTwo; i++) {
			int num = (int) i;
			result = result + "," + num;
		}
		return result.substring(1);
	}
	
}
