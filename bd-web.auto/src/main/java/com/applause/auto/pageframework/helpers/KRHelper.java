package com.applause.auto.pageframework.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KRHelper {

	public static String MonthsNumberToName(LocalDate date) {
		String monthName = date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

		return monthName.toUpperCase();
	}

	public static void VerticalScroll(WebDriver driver, int Ylocation) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + Ylocation + ")");
	}

	public static void ModifyAttributeClass(WebDriver driver, String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('.vjs-user-inactive')[0].classList.remove('.vjs-user-inactive');");
	}

	// KRHelper.Convert(expandCalendar().getAttributeValue("value"));
	public static LocalDate Convert(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);

		return date;
	}

}
