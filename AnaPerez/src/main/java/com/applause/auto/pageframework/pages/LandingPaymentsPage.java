package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopLandingPaymentsPage.class)
@WebTabletImplementation(TabletLandingPaymentsPage.class)
@WebPhoneImplementation(PhoneLandingPaymentsPage.class)
public abstract class LandingPaymentsPage extends AbstractPage {
	
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// TODO Auto-generated method stub
		syncHelper.waitForElementToAppear(getButtonLogin());
	}
	/*
	 * Public Actions
	 */

	public void enterLogin(String Username, String Password) {
		
		LOGGER.info(String.format("Entering username", Username));
		getTextUserName().enterText(Username);
		syncHelper.waitForElementToAppear(getButtonLogin());
		LOGGER.info(String.format("Entering Password", Username));
		getTextPassword().enterText(Password);
		syncHelper.waitForElementToAppear(getButtonLogin());
		getButtonLogin().click();
	}
	
	
	@WebElementLocator(webDesktop = "#fadeIn third ng-dirty ng-valid ng-touched")
	protected TextBox getTextPassword() {
		return new TextBox(getLocator(this, "getTextPassword"));
	}
	
	@WebElementLocator(webDesktop = "#fadeIn second ng-dirty ng-valid ng-touched")
	protected TextBox getTextUserName() {
		return new TextBox(getLocator(this, "getTextUserName"));
	}
	@WebElementLocator(webDesktop = "#fadeIn fifth")
	protected Button getButtonLogin() {
		return new Button(this, getLocator(this, "getButtonLogin"));
	}
}
	
	/**
	 * Desktop Implementation for PaymentsPage
	 */
	class DesktopLandingPaymentsPage extends LandingPaymentsPage {

	}

	/**
	 * Tablet Implementation for PaymentsPage
	 */
	class TabletLandingPaymentsPage extends LandingPaymentsPage {
	}

	/**
	 * Phone Implementation for PaymentsPage
	 */
	class PhoneLandingPaymentsPage extends LandingPaymentsPage {

	}

