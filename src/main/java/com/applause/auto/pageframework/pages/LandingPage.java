package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.pageframework.Chunks.AccountChunk;

@WebDesktopImplementation(DesktopLandingPage.class)
@WebTabletImplementation(TabletLandingPage.class)
@WebPhoneImplementation(PhoneLandingPage.class)
public abstract class LandingPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getIngresarButton());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 * 
	 * @param destinationName
	 */
	public void loginLandingPage(String user, String password) {

		LOGGER.info("2.1 Navigate to login page.");
		getIngresarButton().click();

		LOGGER.info("2.2 the user's data is filled in for the login.");
		getUserTextBox().sendKeys(user);
		getPasswordTextBox().sendKeys(password);
		getLoginIngresarButton().click();

	}

	public AccountChunk navigateToUserProfile() {

		getAccountButton().click();
		return PageFactory.create(AccountChunk.class);
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = ".btn-login")
	protected Button getIngresarButton() {
		return new Button(this, getLocator(this, "getIngresarButton"));
	}

	@WebElementLocator(webDesktop = "UserName")
	protected WebElement getUserTextBox() {
		return getDriver().findElement(By.name(getLocator(this, "getUserTextBox")));
	}

	@WebElementLocator(webDesktop = "Password")
	protected WebElement getPasswordTextBox() {
		return getDriver().findElement(By.name(getLocator(this, "getPasswordTextBox")));
	}

	@WebElementLocator(webDesktop = "#loginButton")
	protected Button getLoginIngresarButton() {
		return new Button(this, getLocator(this, "getLoginIngresarButton"));
	}

	@WebElementLocator(webDesktop = "//li[@class='submenu-link1 hidden-xs is-user-profile-link']/a")
	protected Button getAccountButton() {
		return new Button(this, getLocator(this, "getAccountButton"));
	}
	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopLandingPage extends LandingPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletLandingPage extends LandingPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneLandingPage extends LandingPage {

}