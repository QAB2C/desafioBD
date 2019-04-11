package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.NoSuchElementException;
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

@WebDesktopImplementation(DesktopGooglePage.class)
@WebTabletImplementation(TabletGooglePage.class)
@WebPhoneImplementation(PhoneGooglePage.class)
public class GooglePage extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// TODO Auto-generated method stub
		syncHelper.waitForElementToAppear(getSearchTextBox());

	}

	public void enterdata(String SearchData) {
		LOGGER.info(String.format("Entering search data %s into search field", SearchData));
		getSearchTextBox().setText(SearchData);
		syncHelper.waitForElementToAppear(getDropdownItem());
		getDropdownItem().click();
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
	
	public SearchGooglePage ButtonGoogle() {
		getSearchButtonGoogle().click();
		return PageFactory.create(SearchGooglePage.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = ".gLFyf gsfi")
	protected EditField getSearchTextBox() {
		return new EditField(this, getLocator(this, "getSearchTextBox"));
	}

	@WebElementLocator(webDesktop = "#suggestions-inner-container")
	protected Link getDropdownItem() {
		return new Link(this, getLocator(this, "getDropdownItem"));
	}

	@WebElementLocator(webDesktop = "#btnK")
	protected Button getSearchButtonGoogle() {
		return new Button(this, getLocator(this, "getSearchButtonGoogle"));
	}
}

/**
 * Desktop Implementation for GooglePage
 */
class DesktopGooglePage extends GooglePage {

}

/**
 * Tablet Implementation for GooglePage
 */
class TabletGooglePage extends GooglePage {
}

/**
 * Phone Implementation for GooglePage
 */
class PhoneGooglePage extends GooglePage {

}
