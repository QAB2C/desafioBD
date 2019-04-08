package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.BaseHtmlElement;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import com.applause.auto.pageframework.helpers.KRHelper;

@WebDesktopImplementation(DesktopSearchBoxKR.class)
@WebTabletImplementation(TabletSearchBoxKR.class)
@WebPhoneImplementation(PhoneSearchBoxKR.class)
public abstract class SearchBoxKR extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.suspend(1000);
	}

	// @param destinationName

	public void expandSearchBoxAjax() {
		LOGGER.info("Tap to expand Search Box");
		expandSearchBox().click();
		LOGGER.info("Tap on input to write destination");
		destinationInput().click();
	}

	public void enterDestination(String destinationName) {
		LOGGER.info("Enter destination");
		destinationInput().setText(destinationName);
		syncHelper.waitForElementToAppear(getDropdown());
		// LOGGER.info(String.format("Get hotel list from ajax: %s ",
		// getDropdown().getText()));
		getDestiny().stream().filter(x -> x.getText().contains(destinationName)).findFirst().get().click();
	}

	public void enterDates(LocalDate date) {
		// Evalua si hace click para expandir el calendario
		if (isCalendarVisible().isDisplayed() == false) {
			LOGGER.info("Tap to expand calendar");
			expandCalendar().click();
		}

		// Obtiene el nombre del mes en mayusculas de acuerdo al numero en la
		// fecha
		String monthName = KRHelper.MonthsNumberToName(date);
		List<WebElement> Calendar = null;
		String statusButtonNext = tapNextCalendar().getAttributeValue("class").toString();

		// Busca el mes de acuerdo al nombre y evalua si hace click
		// para avanzar al siguiente mes
		aux: while (getCalendarMonthNameLeft().getText().toUpperCase().equals(monthName) == false) {
			if (getCalendarMonthNameLeft().getText().toUpperCase().equals(monthName) == false
					&& !statusButtonNext.toUpperCase().contains("UI-STATE-DISABLED")) {
				tapNextCalendar().click();
			} else if (getCalendarMonthNameRight().getText().toUpperCase().equals(monthName)) {
				break aux;
			}
		}

		// Evalua dependiendo del mes encontrado el calendario donde buscaran
		// los dias
		if (getCalendarMonthNameLeft().getText().toUpperCase().equals(monthName)) {
			Calendar = getCalendarItemsLeft();
		} else if (getCalendarMonthNameRight().getText().toUpperCase().equals(monthName)) {
			Calendar = getCalendarItemsRight();
		}

		// Busca el dia en el calendario
		Calendar.stream().filter(x -> !x.getText().equals(" "))
				.filter(x -> Integer.parseInt(x.getText()) == date.getDayOfMonth()).findFirst().get().click();

	}

	public void selectAdults(int adults) {
		dropDownItemAdults().click();
		dropDownItemAdults().getOptions().stream().filter(x -> Integer.parseInt(x.getText()) == adults).findFirst()
				.get().select();
	}

	// Taps the search button and expects to land at Search Results Page

	// @return a SearchResultsPage

	public HotelListKR tapSearchButton() {
		getSearchButton().click();
		LOGGER.info("Tap on Search Button");
		return PageFactory.create(HotelListKR.class);
	}

	// Protected Getters

	// Elemento para expandir la caja de busqueda
	@WebElementLocator(webDesktop = "#changeSearchResume")
	protected Button expandSearchBox() {
		return new Button(this, getLocator(this, "expandSearchBox"));
	}

	// Elemento input destino
	@WebElementLocator(webDesktop = "#EtDestinyHtl")
	protected EditField destinationInput() {
		return new EditField(this, getLocator(this, "destinationInput"));
	}

	// Elemento donde se encuentran los destinos
	@WebElementLocator(webDesktop = ".EtBxAutoComplete")
	protected Dropdown getDropdown() {
		return new Dropdown(this, getLocator(this, "getDropdown"));
	}

	// Lista de elementos en el ajax
	@WebElementLocator(webDesktop = "//li[@class='ui-menu-item']")
	protected List<WebElement> getDestiny() {
		return getDriver().findElements(By.xpath(getLocator(this, "getDestiny")));
	}

	// Elemento para expandir el primer calendario
	@WebElementLocator(webDesktop = "#EtDateFromHotel")
	protected EditField expandCalendar() {
		return new EditField(this, getLocator(this, "expandCalendar"));
	}

	// Click para avanzar meses en el calendario
	@WebElementLocator(webDesktop = "#ui-datepicker-div")
	protected BaseHtmlElement isCalendarVisible() {
		return new BaseHtmlElement(this, getLocator(this, "isCalendarVisible"));
	}

	// Click para avanzar meses en el calendario
	@WebElementLocator(webDesktop = ".ui-datepicker-next")
	protected BaseHtmlElement tapNextCalendar() {
		return new BaseHtmlElement(this, getLocator(this, "tapNextCalendar"));
	}

	// Lista de nombres de calendario
	@WebElementLocator(webDesktop = "//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div[@class='ui-datepicker-title']/span")
	protected Text getCalendarMonthNameLeft() {
		return new Text(this, getLocator(this, "getCalendarMonthNameLeft"));
	}

	// Lista de nombres de calendario
	@WebElementLocator(webDesktop = "//div[@class='ui-datepicker-group ui-datepicker-group-last']/div/div[@class='ui-datepicker-title']/span")
	protected Text getCalendarMonthNameRight() {
		return new Text(this, getLocator(this, "getCalendarMonthNameRight"));
	}

	// Lista de elementos del primer calendario
	@WebElementLocator(webDesktop = "//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td")
	protected List<WebElement> getCalendarItemsLeft() {
		return getDriver().findElements(By.xpath(getLocator(this, "getCalendarItemsLeft")));
	}

	// Lista de elementos del segundo calendario
	@WebElementLocator(webDesktop = "//div[@class='ui-datepicker-group ui-datepicker-group-last']/table[@class='ui-datepicker-calendar']/tbody/tr/td")
	protected List<WebElement> getCalendarItemsRight() {
		return getDriver().findElements(By.xpath(getLocator(this, "getCalendarItemsRight")));
	}

	// Elemento para expandir el primer calendario
	@WebElementLocator(webDesktop = "#EtNumAdults1")
	protected Dropdown dropDownItemAdults() {
		return new Dropdown(this, getLocator(this, "dropDownItemAdults"));
	}

	// Boton para buscar
	@WebElementLocator(webDesktop = "#EtSearchHotels")
	protected Button getSearchButton() {
		return new Button(this, getLocator(this, "getSearchButton"));
	}

	/*
	 * Private Helpers
	 */

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopSearchBoxKR extends SearchBoxKR {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletSearchBoxKR extends SearchBoxKR {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneSearchBoxKR extends SearchBoxKR {

}