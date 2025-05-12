package de.zeroco.strings;

public class ReverseString {
	
	public static void main(String[] args) {
		 System.out.println(reverseString("This is a laptop"));
		 System.out.println(reverseWord("This is a laptop"));
		 System.out.println("This thisqwer aaaaa ,,,,,,,,,,,,,,,,,,,,,,,,,");
	}
	
	public static  String reverseWord(String input) {
		String res = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			res += input.charAt(i);
		}
		return res;
	}
	
	public static String reverseString(String input) {
		String res = "";
		String[] result = input.split(" ");
		for (int i = result.length - 1; i >= 0; i--) {
			res += result[i] + " ";
		}
		return res.substring(0, res.length() - 1);
	}
	
	public static String longestSubString(String input) {
	    String res = "";
	    int index = 0;
	    String[] resArray = new String[input.length()];
	    int maxLength = 0; 
	    String longestSubstring = "";
	    for (int i = 0; i < input.length(); i++) {
	        boolean isUnique = true;
	        for (int j = 0; j < res.length(); j++) {
	            if (input.charAt(i) == res.charAt(j)) {
	                isUnique = false;
	                break;
	            }
	        }
	        if (isUnique) {
	            res += input.charAt(i);
	        } else {
	            resArray[index++] = res;
	        }
	    }
	    resArray[index++] = res;
	    for (int i = 0; i < index; i++) {
	        if (resArray[i].length() > maxLength) {
	            maxLength = resArray[i].length();
	            longestSubstring = resArray[i];
	        }
	    }
	    return longestSubstring;
	}
}
