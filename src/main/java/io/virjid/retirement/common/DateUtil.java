package io.virjid.retirement.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static LocalDate localDateParse(String date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ld = LocalDate.parse(date, df);
		return ld;
	}
	
	public static String localDateToString(LocalDate date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(df);
	}
}
