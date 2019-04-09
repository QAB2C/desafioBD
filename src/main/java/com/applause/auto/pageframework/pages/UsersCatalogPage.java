package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;

@WebDesktopImplementation(DesktopUsersCatalogPage.class)
@WebTabletImplementation(TabletUsersCatalogPage.class)
@WebPhoneImplementation(PhoneUsersCatalogPage.class)
public abstract class UsersCatalogPage extends AbstractPage {

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getAddUserPageButton());
	}

	public AddNewUserPage navigateToNewUserPage() {
		getAddUserPageButton().click();
		return PageFactory.create(AddNewUserPage.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//a[@href='/Security/AddNewUser']")
	protected Button getAddUserPageButton() {

		return new Button(this, getLocator(this, "getAddUserPageButton"));
	}
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopUsersCatalogPage extends UsersCatalogPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletUsersCatalogPage extends UsersCatalogPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneUsersCatalogPage extends UsersCatalogPage {

}