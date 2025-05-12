package de.zeroco.casting;

public class DoubleDataTypeCasting {

	public static void main(String[] args) {
		System.out.println("hi");
		System.out.println(convertByteToDouble(123.987));
		System.out.println(convertByteToShort(123.987));
		System.out.println(convertByteToInt(123.987));
		System.out.println(convertByteToLong(123.987));
		System.out.println(convertByteToFloat(123.987));
	}

	public static byte convertByteToDouble(double firstNo) {
		byte secondNo = (byte) firstNo;
		return secondNo;
	}

	public static short convertByteToShort(double firstNo) {
		short secondNo = (short) firstNo;
		return secondNo;
	}

	public static int convertByteToInt(double firstNo) {
		int secondNo = (int) firstNo;
		return secondNo;
	}

	public static long convertByteToLong(double firstNo) {
		long secondNo = (long) firstNo;
		return secondNo;
	}

	public static float convertByteToFloat(double firstNo) {
		float secondNo = (float) firstNo;
		return secondNo;
	}
	
}
