package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopHomePage.class)
@WebTabletImplementation(TabletHomePage.class)
@WebPhoneImplementation(PhoneHomePage.class)
public abstract class HomePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getSearchClose());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the
	 * dropdown once it appears
	 * 
	 * @param destinationName
	 */
	public void enterClosePage() {
		System.out.print(getSearchClose().getAttributeValue("innerHTML"));
		LOGGER.info("Closing page");
		getSearchClose().click();
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//*[contains(text(),'Cerrar sesión')]")
	protected Text getSearchClose() {
		return new Text(this, getLocator(this, "getSearchClose"));
	}
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