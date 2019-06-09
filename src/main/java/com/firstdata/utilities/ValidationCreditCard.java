package com.firstdata.utilities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public class ValidationCreditCard {

	static public boolean validationNumber(String numberCard) {
		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<amex>3[47][0-9]{13}))$";
		boolean result = false;

		if (numberCard.matches(regex)) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(numberCard);
			if (matcher.matches()) {
				result = true;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		/* Mastercard 5312345678945612 */
		/* Visa 4123456789123369 */
		/* Amex 371234567894561 */
		System.out.println(ValidationCreditCard.validationNumber("371234567894561"));
	}
}
