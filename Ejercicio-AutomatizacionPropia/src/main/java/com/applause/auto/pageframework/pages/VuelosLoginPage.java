package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopVuelosLoginPage.class)
@WebTabletImplementation(TabletVuelosLoginPage.class)
@WebPhoneImplementation(PhoneVuelosLoginPage.class)
public abstract class VuelosLoginPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// dismissPopup();
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

	public void enterUser(String userName) {
		LOGGER.info(String.format("Entering user %s into search field", userName));
		getUserTextBox().setText(userName);
		// syncHelper.waitForElementToAppear(getDropdownItem());
		getUserTextBox().click();
	}

	public void enterPassword(String passwordName) {
		LOGGER.info(String.format("Entering password %s into search field", passwordName));
		getPasswordTextBox().setText(passwordName);
		getPasswordTextBox().click();
	}

	public CotizacionPage IngresarButton() {
		getButtonIngresar().click();
		LOGGER.info("Click button Ingresar");
		return PageFactory.create(CotizacionPage.class);
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "#tbUser")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	@WebElementLocator(webDesktop = "#tbPassword")
	protected EditField getPasswordTextBox() {
		return new EditField(this, getLocator(this, "getPasswordTextBox"));
	}

	@WebElementLocator(webDesktop = "#btnLogin")
	protected Button getButtonIngresar() {
		return new Button(this, getLocator(this, "getButtonIngresar"));
	}

	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for VuelosLoginPage
 */
class DesktopVuelosLoginPage extends VuelosLoginPage {

}

/**
 * Tablet Implementation for VuelosLoginPage
 */
class TabletVuelosLoginPage extends VuelosLoginPage {
}

/**
 * Phone Implementation for VuelosLoginPage
 */
class PhoneVuelosLoginPage extends VuelosLoginPage {

}