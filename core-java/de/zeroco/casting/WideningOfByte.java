package de.zeroco.casting;

public class WideningOfByte {
	public static void main(String[] args) {
//		System.out.println("hi");
		System.out.println(convertByteToShort((byte) 130));
//		System.out.println(convertByteToInt((byte) 128));
//        System.out.println(convertByteToLong((byte) 132));
//        System.out.println(convertByteToFloat((byte) 34));
//        System.out.println(convertByteToDouble((byte) 4567));
	}
	
	public static short convertByteToShort(byte firstNum) {
		return firstNum;
	}
	
	public static int convertByteToInt(byte firstNum) {
		int secondNum = firstNum;
		return secondNum;	
	}
	
	public static long convertByteToLong(byte firstNum) {
		long secondNum = firstNum;
		return secondNum;
	}
	
	public static float convertByteToFloat(byte firstNum) {
		float secondNum = firstNum;
		return secondNum;
	}

	public static double convertByteToDouble(byte firstNum) {
		double secondNum = firstNum;
		return secondNum;
	}
	
}
