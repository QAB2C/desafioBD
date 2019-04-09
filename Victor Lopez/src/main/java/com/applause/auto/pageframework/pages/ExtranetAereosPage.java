package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;
import org.openqa.selenium.NoSuchElementException;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;

import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopExtranetAereosPage.class)
public abstract class ExtranetAereosPage extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	/*
	 * Public Actions
	 */

	@Override
	protected void waitUntilVisible() {
		//dismissPopup();

	}

	public void enterUser(String user) {
		LOGGER.info(String.format("Entering user %s into search field", user));
		getUserTextBox().setText(user);
		getUserTextBox().click();
	}
	public void enterPassword(String pass) {
		LOGGER.info(String.format("Entering Password %s into search field", pass));
		getPasswordTextBox().setText(pass);
		getPasswordTextBox().click();
	}

	public void enterDomain(String domain) {
		LOGGER.info(String.format("Entering Domain %s into search field", domain));
		getDomainTextBox().setText(domain);
		getDomainTextBox().click();
	}

	public StatusBlockingsPage LogingEnterButton () {
		getLoginButton().click();
		LOGGER.info("Tap on Login Button");
		return PageFactory.create(StatusBlockingsPage.class);
	}

	public BlockingPage getPageBlocking() {
		getLinkBlocking().click();
		LOGGER.info("Tap on  Blocking Link");
		return PageFactory.create(BlockingPage.class);
	}


	@WebElementLocator(webDesktop = "input[name='Email']")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	@WebElementLocator(webDesktop = "input[name='Password']")
	protected EditField getPasswordTextBox() {
		return new EditField(this, getLocator(this, "getPasswordTextBox"));
	}

	@WebElementLocator(webDesktop = "input[name='Domain']")
	protected EditField getDomainTextBox() {
		return new EditField(this, getLocator(this, "getDomainTextBox"));
	}

	@WebElementLocator(webDesktop = "#loginBtn")
	protected Button getLoginButton() {
		return new Button(this, getLocator(this, "getLoginButton"));
	}


	@WebElementLocator(webDesktop = "#Blocking")
	protected Link getLinkBlocking() {
		return new Link(this, getLocator(this, "getLinkBlocking"));
	}





}

class DesktopExtranetAereosPage extends ExtranetAereosPage {

}







