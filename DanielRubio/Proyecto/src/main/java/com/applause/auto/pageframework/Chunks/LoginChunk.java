package com.applause.auto.pageframework.Chunks;

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
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopLoginChunk.class)
@WebTabletImplementation(TabletLoginChunk.class)
@WebPhoneImplementation(MobileLoginChunk.class)
public class LoginChunk extends AbstractPage {
	
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getUserName());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get Text of userName
	 * 
	 * 
	 */
	public String getSearchEmailText() {
		
		return getSearchEmail().getAttributeValue("innerHTML");
	}
	
	public void enterUserAndConfirm(String information) {
		LOGGER.info(String.format("Entering user ", information));
		getUserName().setText(information);
		syncHelper.waitForElementToAppear(getUserName());
		getButtonNext().click();
	}
	public void enterPassAndConfirm(String information) {
		LOGGER.info(String.format("Entering password ", information));
		syncHelper.waitForElementToAppear(getUserPass());
		getUserPass().setText(information);
		getButtonNext().click();
		syncHelper.waitForElementToAppear(getButtonNext());
		getButtonNext().click();
	}
	public boolean errorName() {
		LOGGER.info("Validating User");
		syncHelper.waitForElementToAppear(getUserName());
		syncHelper.waitForElementToAppear(getButtonNext());
		return getUserNameError().exists();
	}
	public boolean errorPass() {
		LOGGER.info("Validating Password");
		return getUserPassError().exists();
	}
	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = "#i0116")
	protected EditField getUserName() {
		return new EditField(this, getLocator(this, "getUserName"));
	}
	@WebElementLocator(webDesktop = "#i0118")
	protected EditField getUserPass() {
		return new EditField(this, getLocator(this, "getUserPass"));
	}
	@WebElementLocator(webDesktop = "#idSIButton9")
	protected Button getButtonNext() {
		return new Button(this, getLocator(this, "getButtonNext"));
	}
	@WebElementLocator(webDesktop = "//span[@class='email']")
	protected Link getSearchEmail() {
		return new Link(this, getLocator(this, "getSearchEmail"));
	}
	@WebElementLocator(webDesktop = "#usernameError")
	protected Text getUserNameError() {
		return new Text(this, getLocator(this, "getUserNameError"));
	}
	@WebElementLocator(webDesktop = "#passwordError")
	protected Text getUserPassError() {
		return new Text(this, getLocator(this, "getUserPassError"));
	}
}

/**
 * 
 * Desktop Implementation for Account Chunk
 */
class DesktopLoginChunk extends LoginChunk {

}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletLoginChunk extends LoginChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class MobileLoginChunk extends LoginChunk {

}