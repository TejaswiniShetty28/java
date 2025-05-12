package de.zeroco.streams;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PasswordStrength {
	
	public static boolean checkStrength(String passWord) {
		if (passWord == null || passWord.length() < 10) return false;
        boolean hasSpecialChar = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(passWord).find();
        boolean hasNumber = passWord.chars().anyMatch(Character::isDigit);
        boolean hasUpperCase = passWord.chars().anyMatch(Character::isUpperCase);
        boolean hasConsecutiveLetters = IntStream.range(0, passWord.length() - 1)
            .anyMatch(i -> Character.isLetter(passWord.charAt(i)) &&
                           Character.isLetter(passWord.charAt(i + 1)) &&
                           passWord.charAt(i) == passWord.charAt(i + 1));
        return hasSpecialChar && hasNumber && hasUpperCase && !hasConsecutiveLetters;
	}
	
}
