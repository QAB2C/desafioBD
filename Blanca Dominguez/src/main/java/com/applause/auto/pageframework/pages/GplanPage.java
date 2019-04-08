package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopGplanPage.class)
@WebTabletImplementation(TabletGplanPage.class)
@WebPhoneImplementation(PhoneGplanPage.class)
public abstract class GplanPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// syncHelper.waitForElementToAppear(getDestinationTextBox());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 * 
	 * @param destinationName
	 */

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
	public void userName(String userName) {
		// LOGGER.info("Enter User");
		syncHelper.waitForElementToAppear(userNameTextBox());
		userNameTextBox().setText(userName);
	}

	public void passwordUser(String password) {
		// LOGGER.info("Enter Password");
		syncHelper.waitForElementToAppear(passwordTextBox());
		passwordTextBox().setText(password);
	}

	public void buttonSumitLogin() {
		LOGGER.info("Click Button");
		syncHelper.waitForElementToAppear(enterSubmitButton());
		enterSubmitButton().click();
	}

	public void menuLink() {
		LOGGER.info("Click Menu");
		syncHelper.waitForElementToAppear(menulinkHotel());
		menulinkHotel().click();
	}

	public void enterDestination(String destination) {
		// LOGGER.info("Entering destination");
		syncHelper.waitForElementToAppear(searchDestinationTextBox());
		searchDestinationTextBox().setText(destination);
	}

	public void tapClickDestination() {
		LOGGER.info("Entering click destination");
		syncHelper.waitForElementToAppear(selectDestinationTextBox());
		selectDestinationTextBox().click();
	}

	public void clickSearchHotel() {
		LOGGER.info("Entering click button search hotel");
		syncHelper.waitForElementToAppear(clickSearchHotelButton());
		clickSearchHotelButton().click();
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//form[@id='NewForm']/div[1]/input[1]")
	protected EditField userNameTextBox() {
		return new EditField(this, getLocator(this, "userNameTextBox"));
	}

	@WebElementLocator(webDesktop = "//form[@id='NewForm']/div[2]/input[@id='Password']")
	protected EditField passwordTextBox() {
		return new EditField(this, getLocator(this, "passwordTextBox"));
	}

	@WebElementLocator(webDesktop = "//form[@id='NewForm']/div[@class='btn']")
	protected Button enterSubmitButton() {
		return new Button(this, getLocator(this, "enterSubmitButton"));
	}

	@WebElementLocator(webDesktop = "//a[@class='menuLinkTxt cotizaBtn'][3]")
	protected Button menulinkHotel() {
		return new Button(this, getLocator(this, "menulinkHotel"));
	}

	@WebElementLocator(webDesktop = "//div[@class='rowLeft']/input[@id='txtDestination_']")
	protected EditField searchDestinationTextBox() {
		return new EditField(this, getLocator(this, "SearchDestinationTextBox"));
	}

	@WebElementLocator(webDesktop = "//li[@class='ui-menu-item'][1]/a[@id='ui-active-menuitem']")
	protected EditField selectDestinationTextBox() {
		return new EditField(this, getLocator(this, "SelectDestinationTextBox"));
	}

	@WebElementLocator(webDesktop = ".inputBtnSearch")
	protected EditField clickSearchHotelButton() {
		return new EditField(this, getLocator(this, "clickSearchHotelButton"));
	}

	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopGplanPage extends GplanPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGplanPage extends GplanPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGplanPage extends GplanPage {

}