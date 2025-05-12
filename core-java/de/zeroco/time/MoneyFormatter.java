package de.zeroco.time;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoneyFormatter {

	public static String formatCurrency(double money) {
        if (money < 0) return "";
        DecimalFormat df = new DecimalFormat("0.00");
        String amount = df.format(money);
        String[] values = amount.split("\\.");
        int length = values[0].length();
        String formattedCurrency = IntStream.range(0, length)
                .mapToObj(i -> ((i > 0 && ((length - i) == 3 || ((length - i) > 3 && (length - i) % 2 == 1))) ? "," : "") + values[0].charAt(i))
                .collect(Collectors.joining());
        return "Rs. " + formattedCurrency + "." + values[1];
    }

	public static void main(String[] args) {
//	    double money = 100000000;
//	    System.out.println(formatCurrency(money));
	}
}
