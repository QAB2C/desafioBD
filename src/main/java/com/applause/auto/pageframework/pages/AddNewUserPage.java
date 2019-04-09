package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.pageframework.testdata.TestConstants;

@WebDesktopImplementation(DesktopAddNewUserPage.class)
@WebTabletImplementation(TabletAddNewUserPage.class)
@WebPhoneImplementation(PhoneAddNewUserPage.class)
public abstract class AddNewUserPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getUserNameTextBox());
	}

	public void addNewUser(String name, String lastName) {
		LOGGER.info("6.1 user data is filled");
		getUserNameTextBox().setText(name);
		getUserLastNameTextBox().setText(lastName);
		getUserEmailTextBox().setText(name + "." + lastName + "@QAtest.com");
		getUserWebPageTextBox().setText(TestConstants.TestData.DOMAIN);
		getUserAffiliateTextBox().setText(TestConstants.TestData.AFILIATTE);
		getUserTypeDropDown().click();
		getAddUserButton().click();
		LOGGER.info("6.2 A new user is added");
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "#Name")
	protected EditField getUserNameTextBox() {

		return new EditField(this, getLocator(this, "getUserNameTextBox"));
	}

	@WebElementLocator(webDesktop = "#LastName")
	protected EditField getUserLastNameTextBox() {

		return new EditField(this, getLocator(this, "getUserLastNameTextBox"));
	}

	@WebElementLocator(webDesktop = "#Mail")
	protected EditField getUserEmailTextBox() {

		return new EditField(this, getLocator(this, "getUserEmailTextBox"));
	}

	@WebElementLocator(webDesktop = "#Domain")
	protected EditField getUserWebPageTextBox() {

		return new EditField(this, getLocator(this, "getUserWebPageTextBox"));
	}

	@WebElementLocator(webDesktop = ".ui-igcombo-field")
	protected EditField getUserAffiliateTextBox() {

		return new EditField(this, getLocator(this, "getUserAffiliateTextBox"));
	}

	@WebElementLocator(webDesktop = ".ui-igcombo-field")
	protected Button getUserAffiliateDropDown() {

		return new Button(this, getLocator(this, "getUserAffiliateDropDown"));
	}

	@WebElementLocator(webDesktop = "#TypeUser")
	protected Link getUserTypeDropDown() {

		return new Link(this, getLocator(this, "getUserTypeDropDown"));
	}

	@WebElementLocator(webDesktop = "#btnAddNewUser")
	protected Button getAddUserButton() {

		return new Button(this, getLocator(this, "getAddUserButton"));
	}
}

/**
 * Desktop Implementation for AddNewUserPage
 */
class DesktopAddNewUserPage extends AddNewUserPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletAddNewUserPage extends AddNewUserPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneAddNewUserPage extends AddNewUserPage {

}