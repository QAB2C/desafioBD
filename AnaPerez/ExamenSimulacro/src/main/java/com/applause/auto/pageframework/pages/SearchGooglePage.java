package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;
import org.openqa.selenium.NoSuchElementException;
import com.applause.auto.framework.pageframework.devicecontrols.Link;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;


public class SearchGooglePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getResultsData());
	}

	/*
	 * Public Actions
	 */

	/*
	 *Metodo boolean 
	 * 
	 */
	public Boolean validateResults () {
		if (getResultsData().getText().contains("Cerca")) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = ".resultStats")
	protected Text getResultsData() {
		return new Text(this, getLocator(this, "getResultsData"));
	}

}



