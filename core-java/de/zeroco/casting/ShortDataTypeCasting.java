package de.zeroco.casting;

public class ShortDataTypeCasting {
	public static void main(String[] args) {
		System.out.println("hi");
		System.out.println(convertShortToByte((short) 1234));
		System.out.println(convertShortToInt((short) 1234));
		System.out.println(convertShortToLong((short) 1234));
		System.out.println(convertShortToFloat((short) 1234));
		System.out.println(convertShortToDouble((short) 1234));
	}
	
	public static byte convertShortToByte(short firstNum) {
		byte secondNum = (byte) firstNum;
		return secondNum;
	}
	
	public static int convertShortToInt(short firstNum) {
		int secondNum = firstNum;
		return secondNum;
	}
	
	public static long convertShortToLong(short firstNum) {
		long secondNum = firstNum;
		return secondNum;
	}
	
	public static float convertShortToFloat(short firstNum) {
		float secondNum = firstNum;
		return secondNum;
	}
	
	public static double convertShortToDouble(short firstNum) {
		double secondNum = firstNum;
		return secondNum;
	}
}
