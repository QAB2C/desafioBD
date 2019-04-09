package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopHomePage.class)
@WebTabletImplementation(TabletRandomPage.class)
@WebPhoneImplementation(PhoneRandomPage.class)
public abstract class HomePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		//syncHelper.waitForElementToAppear(ingresarDatos());

	}

	public WelcomePage ingresarDatos(String Usuario, String Password) {
		getUserTextBox().setText(Usuario);
		getPasswordTextBox().setText(Password);
		getLoginButton().click();
		LOGGER.info("Tap on ingresar Button");
		return PageFactory.create(WelcomePage.class);
	}

	@WebElementLocator(webDesktop = "#userLogin")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	@WebElementLocator(webDesktop = "#passwordLogin")
	protected EditField getPasswordTextBox() {
		return new EditField(this, getLocator(this, "getPasswordTextBox"));
	}

	@WebElementLocator(webDesktop = "#form_btn_log")
	protected Button getLoginButton() {
		return new Button(this, getLocator(this, "getLoginButton"));
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