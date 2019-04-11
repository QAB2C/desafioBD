package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import org.openqa.selenium.NoSuchElementException;
import com.applause.auto.pageframework.pages.HomePage;

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(DesktopHomePage.class)
@WebTabletImplementation(TabletHomePage.class)
@WebPhoneImplementation(PhoneHomePage.class)
public abstract class HomePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		//dismissPopup();
		//syncHelper.waitForElementToAppear(tapSearchButton());
	}


	/*
	 * Public Actions
	 */

	/**
	 * Taps the search button and expects to land at Search Results Page
	 *
	 * @return a SearchResultsPage
	 */
	public void ingresarDatos(String Busqueda) {
		getBusquedaTextBox().setText(Busqueda);
		getSearchButton().click();
		LOGGER.info("Tap on ingresar Button");

	}



	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//input[@title='Buscar']")
	protected EditField getBusquedaTextBox() {
		return new EditField(this, getLocator(this, "getBusquedaTextBox"));
	}

	@WebElementLocator(webDesktop = "//input[@name='btnK']")
	protected Button getSearchButton() {
		return new Button(this, getLocator(this, "getSearchButton"));
	}
/*
	@WebElementLocator(webDesktop = "#ui-active-menuitem")
	protected Link getDropdownItem() {
		return new Link(this, getLocator(this, "getDropdownItem"));
	}

	@WebElementLocator(webDesktop = "#btnSubmitHotels")
	protected Button getSearchButton() {
		return new Button(this, getLocator(this, "getSearchButton"));
	}

	@WebElementLocator(webDesktop = "#account-lightbox")
	protected Text getPopupWelcomeText() {
		return new Text(this, getLocator(this, "getPopupWelcomeText"));
	}

	@WebElementLocator(webDesktop = "#d-icon-header-login-close")
	protected Button getDismissPopupButton() {
		return new Button(this, getLocator(this, "getDismissPopupButton"));
	}
*/



}

/**
 * Desktop Implementation for HomePage
 */
class DesktopHomePage extends HomePage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletHomePage extends HomePage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneHomePage extends HomePage {

}