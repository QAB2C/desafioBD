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

@WebDesktopImplementation(DesktopGooglePage.class)
@WebTabletImplementation(TabletGooglePage.class)
@WebPhoneImplementation(PhoneGooglePage.class)
public abstract class GooglePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
	}

	public void search(String value) {
		LOGGER.info(String.format("Ingresamos la palabra %s", value));
		SearchText().click();
		SearchText().setText(value);
	}

	public GoogleResultPage tabButton() {
		LOGGER.info(String.format("Hacemos click sobre el botón de Buscar en Google"));
		ClickButton().click();
		return PageFactory.create(GoogleResultPage.class);
	}

	@WebElementLocator(webDesktop = ".gLFyf")
	private EditField SearchText() {
		return new EditField(this, getLocator(this, "SearchText"));
	}

	@WebElementLocator(webDesktop = "//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div/center/input[1]")
	private Button ClickButton() {
		return new Button(this, getLocator(this, "ClickButton"));
	}
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopGooglePage extends GooglePage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGooglePage extends GooglePage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGooglePage extends GooglePage {

}