package com.firstdata.utilities;

import java.time.LocalDate;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public class Utilities {
	public static LocalDate fromDateToLocalDate(String date) {
		return LocalDate.parse(date);
	}
}
