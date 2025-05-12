package de.zeroco.main;

//import java.util.Arrays;
import java.util.Collection;
//import java.util.List;
import java.util.regex.Pattern;
//import de.zeroco.collections.ListOperation;
public class Utility {

	public static final int TAX_DEDUCTION = 150;
	public static final int OT_PAY_PER_HOUR = 250;
	public static final int NUMBER_OF_WORKING_DAYS_IN_MONTH = 30;

	public static void main(String[] args) {
		double value = emiCalculation(200000, 12, 12f);
		if (value == -1) {
			System.out.println(
					"Total amount need to be inbetween 20k - 5L, tenure in between 12 -24 months, rate of interest in between 7 - 12");
		} else {
			System.out.println(value);
		}
//		System.out.println(salaryCalculation(27451, 5, 2.5f));
//		System.out.println(isBlank(0));
//		System.out.println(isBlank(""));
//		System.out.println(isBlank("   "));
//		System.out.println(isBlank(-567));
//		System.out.println(!isBlank(-9876));
//		System.out.println(isPhoneNumberValid("234567890"));
//		System.out.println(isPhoneNumberValid("+9134567899999999999999999999"));
//		System.out.println(isPhoneNumberValid("+91 7671834414"));
//		System.out.println(isEmailValid("*prav..;e*en.d@zeroco.de"));
//		System.out.println(isValidPassword("Tejaswini6#"));
//		System.out.println("aplha " + isLettersOnly("ertyhgfcvh"));
//		System.out.println(isLettersOnly("tejaswini12345"));
//		System.out.println(isLettersOnly("!@#$%^&"));
//		System.out.println(isLettersOnly("2345678"));
//		System.out.println(isLettersOnly("tejaswii567!@#"));
//		System.out.println(isLettersOnly("   "));
//		System.out.println(printNumber(5));
//		System.out.println(wordCount("Test TEST test TesT test test", "Te"));
//		System.out.println(wordFrequency("Test TEST test TesT test test", "Te"));
//		System.out.println(getCount("Test TEST test TesT test test", "ST"));
//		System.out.println(countWordOccurrences("Test TEST test TesT test test", "Te"));
//		System.out.println(countWordFrequency("Test TEST test TesT test test", ""));
//		System.out.println(wordCount("Test TEST test TesT test test", "Te"));
//		Set<Integer> set = new HashSet<Integer>();
//		Set<Object> object = new HashSet<Object>();
//		Set<String> secondSet = new HashSet<String>();
//		SetUtility setUtility = new SetUtility();
//		setUtility.hasElement(set, 10);
//		setUtility.hasElement(secondSet, "String");
//		setUtility.addElement(set, 10);
//		setUtility.addElement(set, 10);
//		setUtility.addElement(set, 20);
//		setUtility.addElement(set, 30);
//		setUtility.addElement(set, null);
//		setUtility.addElement(set, null);
//		System.out.println(set);
//		set = new LinkedHashSet<Integer>();
//		setUtility.addElement(set, 10);
//		setUtility.addElement(set, 10);
//		setUtility.addElement(set, 20);
//		setUtility.addElement(set, 30);
//		setUtility.addElement(set, null);
//		setUtility.addElement(set, null);
//		System.out.println(set);
//		set = new TreeSet<Integer>();
//		setUtility.addElement(set, 10);
//		setUtility.addElement(set, 10);
//		setUtility.addElement(set, 20);
//		setUtility.addElement(set, 30);
//		System.out.println(set);
//		setUtility.addHeterogeneousElement(object, "String");
//		setUtility.addHeterogeneousElement(object, 1);
//		setUtility.addHeterogeneousElement(object, 20.0);
////		System.out.println(object);
//		MyArrayList myArrayList = new MyArrayList();
//		System.out.println(myArrayList.add(5));
//		System.out.println(myArrayList.add(10));
//        System.out.println(myArrayList.add(20));
//        System.out.println(myArrayList.add(30));
//        System.out.println(myArrayList.add(null));
//        System.out.println(myArrayList);
//		System.out.println("Size of my array list :" + myArrayList.size());
//		System.out.println(myArrayList.get(4));
//		System.out.println(myArrayList.remove(3));
//		ArrayList<Integer> secondList = new ArrayList<>();
//	    secondList.add(40);
//	    secondList.add(50);
//	    secondList.add(60);
//	    System.out.println(secondList);
//	    System.out.println(myArrayList.addAll(secondList));
//	    System.out.println(myArrayList);
//	    System.out.println("Remove element :" + myArrayList.remove(0));
//	    System.out.println("Get element :" + myArrayList.get(2));
//	    ListOperation listOperation = new ListOperation();
//		List<Integer> list = Arrays.asList(8, 7, 6, 9, 1, 2, 5, 3, 4); 
//		List<Integer> thridList = Arrays.asList(8, 7, 6, 9, 1, 2, 5, 3, 4, 11);
//		System.out.println(listOperation.sortEvenOddByIndex(list));
//		try {
//			System.out.println(listOperation.splitAndArrange(thridList));
//	    } catch (IllegalArgumentException e) {
//			System.out.println("Exception caught: " + e.getMessage());
//		}
		System.out.println("hi");
	}

	/**
	 * Calculate monthly EMI
	 * 
	 * @author Tejaswini.S @since 2024-12-30
	 * @param totalAmount
	 * @param tenure
	 * @param rateOfInterest
	 * @return String of emiEalculation
	 */
	public static double emiCalculation(int totalAmount, int tenure, float rateOfInterest) {
		double monthlyInterest = (rateOfInterest) / (12 * 100);
		if ((totalAmount < 20000) || (totalAmount > 500000))
			return -1;
		if ((tenure < 12) || (tenure > 24))
			return -1;
		if ((rateOfInterest < 7) || (rateOfInterest > 12))
			return -1;
		return (totalAmount * monthlyInterest * Math.pow(1 + monthlyInterest, tenure))
				/ (Math.pow(1 + monthlyInterest, tenure) - 1);
	}

	/**
	 * Calculate monthly salary
	 * 
	 * @author Tejaswini.S @since 2024-12-30
	 * @param committedMonthlySalary
	 * @param otHours
	 * @param lops
	 * @return float of salary calculation
	 */
	public static float salaryCalculation(int committedMonthlySalary, int otHours, float lops) {
		int otPayment = otHours * OT_PAY_PER_HOUR;
		float lopAmount = lops * (committedMonthlySalary / NUMBER_OF_WORKING_DAYS_IN_MONTH);
		return committedMonthlySalary + otPayment - lopAmount - TAX_DEDUCTION;
	}

	/**
     * This a method named isBlank that takes an Object as a parameter. Check the input type and validate if it is blank.
	 * 
	 * @author Tejaswini.S
	 * @since 2-01-2025
	 * @param input
	 * @return true if input is empty
	 * @reviewed by Praveen.D, Sujwal.B
	 */
	public static boolean isBlank(Object input) {
		if (input == null)
			return true;
		if ((input instanceof Integer)) {
			if ((int) input <= 0)
				return true;
		} else if (input instanceof Long) {
			if ((long) input <= 0)
				return true;
		} else if (input instanceof Float) {
			if ((float) input <= 0.0f)
				return true;
		} else if (input instanceof Double) {
			if ((double) input <= 0.0)
				return true;
		} else if (input instanceof String) {
			if ((((String) input).trim().isEmpty()))
				return true;
		} else if ((input instanceof Character)) {
			if (Character.isWhitespace((Character) input))
				return true;
		} else if (input.getClass().isArray()) {
			if (java.lang.reflect.Array.getLength(input) == 0)
				return true;
		}  else if (input instanceof Collection<?>) {
			if (((Collection<?>) input).isEmpty())
				return true;
		}
		return false;
	}

	/**
	 * This is a method named hasData, takes Object as parameter. Check the input type and validate if it has data
	 * 
	 * @author Tejaswini.S
	 * @since 2-01-2025
	 * @param input
	 * @return true if input has data
	 * @reviewed by Praveen.D, Sujwal.B
	 */
	public static boolean hasData(Object input) {
		return !isBlank(input);
	}

	/**
	 * This is a method named isPhoneNumber, takes parameter as String. It will validate Indian phone number with regex.
	 * 
	 * @author Tejaswini.S
	 * @since 2-01-2025
	 * @param phoneNumber
	 * @return true if input is valid
	 * @reviewed by Praveen.D, Sujwal.B
	 */
	public static boolean isPhoneNumberValid(String phoneNumber) {
		if (isBlank(phoneNumber)) return false;
		return Pattern.compile("^\\+91\\s[6-9]\\d{9}$").matcher(phoneNumber).matches();
	}

	/**
	 * This is method named isValidEmail, takes parameter as String. It will validate email with regex. 
	 * 
	 * @author Tejaswini.S
	 * @since 2-01-2025
	 * @param email
	 * @return true if input is valid
	 * @reviewed by Praveen.D, Sujwal.B
	 */
	public static boolean isEmailValid(String email) {
		if (isBlank(email)) return false;
		return Pattern.compile("^[a-z0-9][a-z0-9!#%&'*+/=?^_`{|}~.;:]{0,63}@[a-z0-9][a-z0-9.-]{1,63}\\.[a-z0-9]{2,6}$\r\n").matcher(email).matches();
	}

	/**
	 * This is method named isValidPassword, takes parameter as String. It will validate password with regex.
	 * 
	 * @author Tejaswini.S
	 * @since 3-01-2025
	 * @param password
	 * @return true if input is valid
	 * @reviewed by Sujwal.B,  Praveen.D
	 */
	public static boolean isValidPassword(String password) {
		if (isBlank(password)) return false;
		return Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,12}$").matcher(password).matches();
	}
	
	/**
	 * This is method named isValidURL, takes parameter as String. It will validate input URL with regex.
	 * 
	 * @author Tejaswini.S
	 * @since 3-01-2025
	 * @param url
	 * @return true if input is valid
	 * @reviewed by Praveen.D, Sujwal.B
	 */
	public static boolean isValidURL(String url) {
		if (isBlank(url)) return false;
		return Pattern.compile("^(https?://)?(www\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}(/.*)?$").matcher(url).matches();
	}
	
	/**
	 * This is method named isLettersOnly, takes parameter as String. It will check whether the given input contains only letters.
	 * 
	 * @author Tejaswini.S
	 * @since 3-01-2025
	 * @param input
	 * @return true if only contains alphabets
	 * @reviewed by Praveen.D, Sujwal.B
	 */
	public static boolean isLettersOnly(String input) {
		if (isBlank(input)) return false;
		return Pattern.compile("^[a-zA-Z]*$").matcher(input).matches();			
	}	
	
	/**
	 * Recursively calculates the sum of all integers from 1 to the given number n.
	 * 
	 * @author Tejaswini.S
	 * @since 21-01-2025
	 * @param input
	 * @return sum of n integers
	 * @reviewed by 
	 */
	public static int printNumber(int n) {
		if (n == 0) {
			return 0;
		}
		return n + printNumber(n - 1);
	}
	
	/**
	 * Counts the occurrences of a specific word in a given sentence by for loop.
	 * 
	 * @author Tejaswini.S
	 * @since 21-01-2025
	 * @param sentence
	 * @param word
	 * @return integer The count of occurrences of the specified word in the sentence.
	 * @reviewed by 
	 */
	public static int wordCount(String sentence, String word) {
	    if (sentence == null || sentence.trim().isEmpty() || word == null || word.trim().isEmpty()) {
	        return 0;
	    }
	    int count = 0;
	    String[] array = sentence.split("\\s+");
	    for (int i = 0; i < array.length; i++) {
	        if (array[i].toLowerCase().contains(word.toLowerCase())) {
	            count++;
	        }
	    }
	    return count;
	}

    
    /**
	 * Counts the occurrences of a specific word in a given sentence by while loop.
	 * 
	 * @author Tejaswini.S
	 * @since 21-01-2025
	 * @param sentence
	 * @param word
	 * @return integer The count of occurrences of the specified word in the sentence.
	 * @reviewed by 
	 */
    public static int wordFrequency(String sentence, String word) {
    	if (isBlank(sentence) || isBlank(word)) return 0;
    	int count = 0;
    	String[] array = sentence.split("\\s+");
    	int i = 0;
    	while (i < array.length) {
    		if (array[i].toLowerCase().contains(word.toLowerCase())) {
	            count++;
	        }
    		i++;
    	}
    	return count;
    }
    
    /**
	 * Counts the occurrences of a specific word in a given sentence by do-while loop.
	 * 
	 * @author Tejaswini.S
	 * @since 21-01-2025
	 * @param sentence
	 * @param word
	 * @return integer The count of occurrences of the specified word in the sentence.
	 * @reviewed by 
	 */
    public static int getCount(String sentence, String word) {
        if (isBlank(sentence) || isBlank(word)) return 0; 
        int count = 0;
        String[] array = sentence.split("\\s+"); 
        int i = 0;
        do {
            if (array[i].toLowerCase().contains(word.toLowerCase())) { 
                count++;
            }
            i++;
        } while (i < array.length);  
        return count; 
    }

    /**
	 * Counts the occurrences of a specific word in a given sentence by recursion.
	 * 
	 * @author Tejaswini.S
	 * @since 21-01-2025
	 * @param sentence
	 * @param word
	 * @return integer The count of occurrences of the specified word in the sentence.
	 * @reviewed by 
	 */
    public static int countWordFrequency(String sentence, String word) {
        return sentence.indexOf(word) != -1 ? countWordFrequency(sentence.substring(sentence.indexOf(word) + word.length()), word) + 1 : 0; 
    }
}

