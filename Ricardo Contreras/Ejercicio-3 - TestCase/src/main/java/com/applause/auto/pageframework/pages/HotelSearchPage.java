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
import com.applause.auto.framework.pageframework.webcontrols.EditField;

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

	public void SelectRooms() {
		LOGGER.info(String.format("Select rooms"));
		syncHelper.fireOnClick(ComboBoxRooms());
		ComboBoxRooms().click();
		ComboBoxRooms().select("2");
	}

	public void isVisibleAdults() {
		LOGGER.info(String.format("Select Adults"));
		ClickAdults1().click();
		ClickAdults1().select("2");

		ClickAdults2().click();
		ClickAdults2().select("2");
	}

	public boolean isVisibleChildrens() {
		LOGGER.info(String.format("Select Childrens"));
		boolean isValid;
		if (!ClickNumChild().exists() && !ClickNumChild2().exists()) {
			LOGGER.info(String.format("Select Childrens"));
			isValid = true;
		} else {
			LOGGER.error(String.format("Select Childrens"));
			isValid = false;
		}
		return isValid;
	}

	public void ClickSearchButton() {
		LOGGER.info(String.format("Click in Search"));
		SearchButton().click();
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

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNRooms")
	protected Dropdown ComboBoxRooms() {
		return new Dropdown(this, getLocator(this, "ComboBoxRooms"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNumAdults1")
	protected Dropdown ClickAdults1() {
		return new Dropdown(this, getLocator(this, "ClickAdults1"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNumAdults2")
	protected Dropdown ClickAdults2() {
		return new Dropdown(this, getLocator(this, "ClickAdults2"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNumAdults3")
	protected Dropdown ClickAdults3() {
		return new Dropdown(this, getLocator(this, "ClickAdults3"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNumChild1")
	protected Button ClickNumChild() {
		return new Button(this, getLocator(this, "ClickNumChild"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNumChild2")
	protected Button ClickNumChild2() {
		return new Button(this, getLocator(this, "ClickNumChild2"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtNumChild3")
	protected Button ClickNumChild3() {
		return new Button(this, getLocator(this, "ClickNumChild3"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#cuponcode")
	protected EditField InputCoupon() {
		return new EditField(this, getLocator(this, "InputCoupon"));
	}

	// ComboBox from Destination
	@WebElementLocator(webDesktop = "#EtSearchHotels")
	protected Button SearchButton() {
		return new Button(this, getLocator(this, "SearchButton"));
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