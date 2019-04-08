package com.applause.auto.pageframework.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class KRHelper {

	public static String MonthsNumberToName(LocalDate date) {
		String monthName = date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

		return monthName.toUpperCase();
	}

	public static void VerticalScroll(WebDriver driver, int Ylocation) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + Ylocation + ")");
	}

	// KRHelper.Convert(expandCalendar().getAttributeValue("value"));
	public static LocalDate Convert(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);

		return date;
	}

}
