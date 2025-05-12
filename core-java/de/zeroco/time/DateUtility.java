package de.zeroco.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import de.zeroco.main.Utility;

/**
 * This class calculates age of the person.
 * 
 * @author Tejaswini.S 
 * @since 06-02-2025
 * @reviewed 
 */
public class DateUtility {
	
	/**
	 * Parses a given date string into a LocalDate object based on the pattern "d MMMM yyyy".
	 * 
	 * @author Tejaswini.S 
	 * @since 06-02-2025
	 * @param dob
	 * @return The parsed LocalDate object or null if the input string is blank or invalid
	 * @reviewed 
	 */
	public static LocalDate parsingString(String dob) {
		try {
			return LocalDate.parse(dob, DateTimeFormatter.ofPattern("d MMMM yyyy"));
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	/**
	 * Calculates the age based on the given date of birth string.
	 * 
	 * @author Tejaswini.S 
	 * @since 06-02-2025
	 * @param dob
	 * @return A string representing the age in years, months, and days.
	 *         Returns "Invalid Date Format" if the date string is invalid.
	 *         Returns "Invalid Date" if the date of birth is in the future.
	 *         Returns null if the input date of birth string is blank.
	 * @reviewed 
	 */
	public static String ageCalculator(String dob) {
		if (Utility.isBlank(dob)) return null;
		LocalDate dobDate = parsingString(dob);
        if (dobDate == null) return "Invalid Date Format";
        if (dobDate.isAfter(LocalDate.now())) return "Invalid Date";
		Period age = Period.between(parsingString(dob), LocalDate.now());
		return age.getYears() + " years " +  age.getMonths() + " months " + age.getDays() + " days";
	}
	
	/**
     * Generates a random LocalDateTime between the given start and end dates.
     * 
     * @author Tejaswini.S 
     * @since 06-02-2025
     * @param start
     * @param end
     * @return 
     * @reviewed 
     */
    public static LocalDateTime getRandomDateTime(LocalDateTime start, LocalDateTime end) {
    	if (Utility.isBlank(start) || Utility.isBlank(end)) return null;
        long startEpoch = start.atZone(ZoneId.systemDefault()).toEpochSecond();
        long endEpoch = end.atZone(ZoneId.systemDefault()).toEpochSecond();
        Random random = new Random();
        long randomEpoch = startEpoch + (long) (random.nextDouble() * (endEpoch - startEpoch));
        return LocalDateTime.ofEpochSecond(randomEpoch, 0, ZoneId.systemDefault().getRules().getOffset(start));
    }
    
//    public class RandomDate{
//        public static void main(String[] args) {
//            LocalDateTime startDate = LocalDateTime.of(2024, 2, 1, 0, 0);
//            LocalDateTime endDate = LocalDateTime.of(2024, 2, 10, 23, 59);
//            LocalDateTime randomDateTime1 = getRandomDateTime(startDate, endDate);
//            LocalDateTime randomDateTime2 = getRandomDateTime(startDate, endDate);
//            System.out.println("Random Timestamp 1: " + randomDateTime1);
//            System.out.println("Random Timestamp 2: " + randomDateTime2);
//        }
//	
    
}

