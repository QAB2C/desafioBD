package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(GoogleResultsPage.class)
@WebTabletImplementation(GoogleResultsPage.class)
@WebPhoneImplementation(GoogleResultsPage.class)
public class GoogleResultsPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		//syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(getResult());
	}


	public Boolean containItem() {
		if (getResult().exists()) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "div.srg > div.g")
	protected Dropdown getResult() {
		return new Dropdown(this, getLocator(this, "getResult"));
	}
}
