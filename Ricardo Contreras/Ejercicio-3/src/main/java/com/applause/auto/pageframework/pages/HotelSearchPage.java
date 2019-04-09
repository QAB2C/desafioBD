package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;

@WebDesktopImplementation(HotelSearchPage.class)
@WebTabletImplementation(HotelSearchPage.class)
@WebPhoneImplementation(HotelSearchPage.class)
public class HotelSearchPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(ClickEditLiquidBox());
	}

	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 */
	public void EditLiquidBox() {
		LOGGER.info(String.format("Click in Edit Button"));
		ClickEditLiquidBox().click();
	}

	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 */
	public void DestinationBox() {
		LOGGER.info(String.format("Click in Edit Button"));
		ClickDestinationBox().click();
		syncHelper.waitForElementToAppear(ClickDestinationBox());
		ClickDestinationBox().select("Todos los destinos");
	}

	/**
	 * Change date in the calendar
	 */
	public void ChangeDate() {
		LOGGER.info(String.format("Click and Change Date"));
		ClickDateFrom().click();
		ClickSig().click();
		ClickSig().click();
		ClickSig().click();
		SelectDay().getDriver().findElements(By.tagName("td")).get(10).click();
		SelectDay().getDriver().findElements(By.tagName("td")).get(15).click();
	}

	// WebElement

	// Button ChangeSearch
	@WebElementLocator(webDesktop = "#changeSearchResume")
	protected Button ClickEditLiquidBox() {
		return new Button(this, getLocator(this, "ClickEditLiquidBox"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtDestinySelectHtl")
	protected Dropdown ClickDestinationBox() {
		return new Dropdown(this, getLocator(this, "ClickDestinationBox"));
	}

	// Calendar
	@WebElementLocator(webDesktop = "#EtDateFromHotel")
	protected Button ClickDateFrom() {
		return new Button(this, getLocator(this, "ClickDateFrom"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody")
	protected Dropdown SelectDay() {
		return new Dropdown(this, getLocator(this, "SelectDay"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = ".ui-icon-circle-triangle-e")
	protected Button ClickSig() {
		return new Button(this, getLocator(this, "ClickSig"));
	}

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopHotelSearchPage extends HotelSearchPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletHotelSearchPage extends HotelSearchPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneHotelSearchPage extends HotelSearchPage {

}