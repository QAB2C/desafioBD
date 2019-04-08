package com.applause.auto.pageframework.Chunks;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import com.applause.auto.pageframework.pages.HomePage;

@WebDesktopImplementation(DesktopMenuChunk.class)
@WebTabletImplementation(TabletMenuChunk.class)
@WebPhoneImplementation(MobileMenuChunk.class)
public class MenuChunk extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getSearchMenu());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get Text of userName
	 * 
	 * 
	 */
	public void getSearchMenuClick() {
		syncHelper.waitForElementToAppear(getSearchMenu());
		getSearchMenu().click();
	}

	public HomePage navigateToRvbi() {
		LOGGER.info("HomePage");
		return PageFactory.create(HomePage.class);
	}

	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = "div > h2", webTablet = "div > h2", webMobile = "div > h2")
	protected Text getUsername() {
		return new Text(this, getLocator(this, "getUsername"));
	}

	@WebElementLocator(webDesktop = "//a[contains(@href,'#!')]")
	protected Link getSearchMenu() {
		return new Link(this, getLocator(this, "getSearchMenu"));
	}

	@WebElementLocator(webDesktop = "//a[contains(text(),'Seguridad')]")
	protected Text getSearchSeguridad() {
		return new Text(this, getLocator(this, "getSearchSeguridad"));
	}

	@WebElementLocator(webDesktop = "//a[contains(text(),'Perfiles')]")
	protected Text getSearchPerfiles() {
		return new Text(this, getLocator(this, "getSearchPerfiles"));
	}
}

/**
 * 
 * Desktop Implementation for Menu Chunk
 */
class DesktopMenuChunk extends MenuChunk {

}

/**
 * Tablet Implementation for Menu chunk
 *
 */
class TabletMenuChunk extends MenuChunk {

}

/**
 * Mobile Implementation for Menu Chunk
 *
 */
class MobileMenuChunk extends MenuChunk {

}