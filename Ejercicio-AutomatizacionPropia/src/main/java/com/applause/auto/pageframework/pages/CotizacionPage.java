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

@WebDesktopImplementation(DesktopCotizacionPage.class)
@WebTabletImplementation(TabletCotizacionPage.class)
@WebPhoneImplementation(PhoneCotizacionPage.class)
public abstract class CotizacionPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// dismissPopup();
		// syncHelper.waitForElementToAppear(getDestinationTextBox());
	}

	/*
	 * Public Actions
	 */

	public void IngresarCotizar() {
		getButtonCotizar().click();
	}

	public void enterAsociado(String asociadoName) {
		LOGGER.info(String.format("Entering asociado %s into search field", asociadoName));
		// getAsociadoTextBox().click();
		getAsociadoTextBox().setText(asociadoName);
		getAsociadoTextBox().click();
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//*[@id=\"acAffiliates_input\"]")
	protected EditField getAsociadoTextBox() {
		// WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"acAffiliates_input\"]")));
		return new EditField(this, getLocator(this, "getAsociadoTextBox"));
	}

	@WebElementLocator(webDesktop = ".b2")
	protected Button getButtonCotizar() {
		return new Button(this, getLocator(this, "getButtonCotizar"));
	}

	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for CotizacionPage
 */
class DesktopCotizacionPage extends CotizacionPage {

}

/**
 * Tablet Implementation for CotizacionPage
 */
class TabletCotizacionPage extends CotizacionPage {
}

/**
 * Phone Implementation for CotizacionPage
 */
class PhoneCotizacionPage extends CotizacionPage {

}