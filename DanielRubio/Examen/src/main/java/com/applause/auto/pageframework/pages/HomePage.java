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

@WebDesktopImplementation(DesktopHomePage.class)
@WebTabletImplementation(TabletHomePage.class)
@WebPhoneImplementation(PhoneHomePage.class)
public abstract class HomePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getSearchInput());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
	public void enterSearchAndConfirm(String Search) {
		getSearchInput().setText(Search);
		getOption().click();
	}
	public boolean resultPage() {
		return getSearch().exists();
	}


	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//input[@class='gLFyf gsfi']")
	protected EditField getSearchInput() {
		return new EditField(this, getLocator(this, "getSearchInput"));
	}
	@WebElementLocator(webDesktop = "//li[@class='sbct']")
	protected Link getOption() {
		return new Link(this, getLocator(this, "getOption"));
	}
	@WebElementLocator(webDesktop = "//*[contains(text(),'qa automation')]")
	protected Text getSearch() {
		return new Text(this, getLocator(this, "getSearch"));
	}	

	/*
	 * Private Helpers
	 */

}

/**
 * Desktop Implementation for HomePage
 */
class DesktopHomePage extends HomePage {

}

/**
 * Tablet Implementation for HomePage
 */
class TabletHomePage extends HomePage {
}

/**
 * Phone Implementation for HomePage
 */
class PhoneHomePage extends HomePage {

}