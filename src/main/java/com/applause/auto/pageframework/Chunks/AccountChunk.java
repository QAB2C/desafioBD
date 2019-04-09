package com.applause.auto.pageframework.Chunks;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.pageframework.pages.UsersCatalogPage;

@WebDesktopImplementation(DesktopAccountChunk.class)
@WebTabletImplementation(TabletAccountChunk.class)
@WebPhoneImplementation(MobileAccountChunk.class)
public class AccountChunk extends AbstractPage {

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getNavigateToUsersCatalog());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Navigate to NavigateToUsers
	 */
	public UsersCatalogPage navigateToUsersCatalog() {

		getNavigateToUsersCatalog().click();
		return PageFactory.create(UsersCatalogPage.class);
	}

	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = "//a[@href='#accountUsersCatalog']")
	protected Button getNavigateToUsersCatalog() {
		return new Button(this, getLocator(this, "getNavigateToUsersCatalog"));
	}
}

/**
 * 
 * Desktop Implementation for Account Chunk
 */
class DesktopAccountChunk extends AccountChunk {

}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletAccountChunk extends AccountChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class MobileAccountChunk extends AccountChunk {

}