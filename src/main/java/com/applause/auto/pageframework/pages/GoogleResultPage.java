package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopGoogleResultPage.class)
@WebTabletImplementation(TabletGoogleResultPage.class)
@WebPhoneImplementation(PhoneGoogleResultPage.class)
public abstract class GoogleResultPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(SearchText());
	}

	public boolean getSearchResultsSummaryText() {
		boolean bandera;
		syncHelper.waitForElementToAppear(SearchText());
		if (SearchText().exists()) {
			LOGGER.info(String.format("Si se encuentra resultados."));
			bandera = true;
		} else {
			LOGGER.info(String.format("Fallo la busqueda."));
			bandera = false;
		}
		return bandera;
	}

	@WebElementLocator(webDesktop = "//*[@id=\"resultStats\"]")
	private EditField SearchText() {
		return new EditField(this, getLocator(this, "SearchText"));
	}
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopGoogleResultPage extends GoogleResultPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGoogleResultPage extends GoogleResultPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGoogleResultPage extends GoogleResultPage {

}