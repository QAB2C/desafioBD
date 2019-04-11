package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

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

@WebDesktopImplementation(DesktopGLandingPage.class)
@WebTabletImplementation(TabletGLandingPage.class)
@WebPhoneImplementation(PhoneGLandingPage.class)
public abstract class GoogleLandingPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
	//	dismissPopup();
	}

	public void SearchGoogle(String SearchItem) {
		LOGGER.info(String.format("Entering Item %s into search field", SearchItem));
		getSearchGoogle().setText(SearchItem);
		getSearchGoogle().sendKey(Keys.ENTER);
	}
	public GoogleResultsPage GResultPage() {
		return PageFactory.create(GoogleResultsPage.class);
	}


	@WebElementLocator(webDesktop = "input.gLFyf")
	protected EditField getSearchGoogle() {
		return new EditField(this, getLocator(this, "getSearchGoogle"));
	}
	
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopGLandingPage extends GoogleLandingPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGLandingPage extends GoogleLandingPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGLandingPage extends GoogleLandingPage {

}