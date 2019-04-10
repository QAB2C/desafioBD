package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.BaseHtmlElement;
import com.applause.auto.pageframework.helpers.KRHelper;

@WebDesktopImplementation(DesktopTestSky.class)
@WebTabletImplementation(TabletTestSky.class)
@WebPhoneImplementation(PhoneTestSky.class)
public abstract class TestSky extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.suspend(5000);
		syncHelper.waitForElementToAppear(tapPlay());
	}

	// @param destinationName

	/*
	 * Private Helpers
	 */

	public void TapPlay() {
		tapPlay().click();
	}

	public void TapPause() {
		KRHelper.ModifyAttributeClass(getDriver(), progressBar().getWebElement().getAttribute("class"));
		syncHelper.waitForElementToAppear(tapPause());
		tapPause().click();
	}

	@WebElementLocator(webDesktop = "[title='Play Video']")
	protected Button tapPlay() {
		return new Button(this, getLocator(this, "tapPlay"));
	}

	@WebElementLocator(webDesktop = ".vjs-loading-spinner")
	protected BaseHtmlElement spinnerLoading() {
		return new BaseHtmlElement(this, getLocator(this, "spinnerLoading"));
	}

	@WebElementLocator(webDesktop = ".vjs-user-inactive")
	protected BaseHtmlElement progressBar() {
		return new BaseHtmlElement(this, getLocator(this, "progressBar"));
	}

	@WebElementLocator(webDesktop = "")
	protected Button tapPause() {
		return new Button(this, getLocator(this, "tapPause"));
	}
}

class DesktopTestSky extends TestSky {

}
class TabletTestSky extends TestSky {

}
class PhoneTestSky extends TestSky {

}