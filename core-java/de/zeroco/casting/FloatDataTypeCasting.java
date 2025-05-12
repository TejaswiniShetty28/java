package de.zeroco.casting;

public class FloatDataTypeCasting {
	public static void main(String[] args) {
		System.out.println("hi");
		System.out.println(convertFloatToByte((float) 123.987));
		System.out.println(convertFloatToShort((float) 123.987));
		System.out.println(convertFloatToInt((float) 123.987));
		System.out.println(convertFloatToLong((float) 123.987));
		System.out.println(convertFloatToDouble((float) 123.987));
	}
	
	public static byte convertFloatToByte(float firstNum) {
		byte secondNum = (byte) firstNum;
		return secondNum;
	}
	
	public static short convertFloatToShort(float firstNum) {
		short secondNum = (short) firstNum;
		return secondNum;
	}
	
	public static int convertFloatToInt(float firstNum) {
		int secondNum = (int) firstNum;
		return secondNum;
	}
	
	public static long convertFloatToLong(float firstNum) {
		long secondNum = (long) firstNum;
		return secondNum;
	}
	
	public static double convertFloatToDouble(float firstNum) {
		double secondNum = firstNum;
		return secondNum;
	}
	
}
