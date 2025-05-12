package de.zeroco.casting;

public class IntegerDataTypeCasting {
	public static void main(String[] args) {
		System.out.println("hi");
		System.out.println(convertIntToByte(234));
		System.out.println(convertIntToShort(234));
		System.out.println(convertIntToLong(234));
		System.out.println(convertIntToFloat(234));
		System.out.println(convertIntToDouble(234));
	}
	
	public static byte convertIntToByte(int firstNum) {
		byte secondNum = (byte) firstNum;
		return secondNum;
	}
	
	public static short convertIntToShort(int firstNum) {
		short secondNum = (short) firstNum;
		return secondNum;
	}
	
	public static long convertIntToLong(int firstNum) {
		long secondNum = firstNum;
		return secondNum;
	}
	
	public static float convertIntToFloat(int firstNum) {
		float secondNum = firstNum;
		return secondNum;
	}
	
	public static double convertIntToDouble(int firstNum) {
		double secondNum = firstNum;
		return secondNum;
	}
	
}
