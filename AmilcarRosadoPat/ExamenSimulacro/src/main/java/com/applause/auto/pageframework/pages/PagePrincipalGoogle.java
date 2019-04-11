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

@WebDesktopImplementation(DesktopPagePrincipalGoogle.class)
@WebTabletImplementation(TabletPagePrincipalGoogle.class)
@WebPhoneImplementation(PhonePagePrincipalGoogle.class)
public abstract class PagePrincipalGoogle extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getInsertarBusqueda());

	}

	/*
	 * Public Actions
	 */

	/**
	 * Ingreso de mi palabra de busqueda
	 * 
	 * @param buscar
	 */
	public void IngresoBusqueda(String Buscar) {
		LOGGER.info(String.format("Ingresa la busqueda", Buscar));
		getInsertarBusqueda().setText(Buscar);
	}

	/**
	 * Taps the search button
	 * 
	 * @return a ResultadosGooglePage
	 */
	public ResultadosGooglePage tapSearchButton() {
		getBuscar().click();
		return PageFactory.create(ResultadosGooglePage.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//input[@class=\"gLFyf gsfi\"]")
	protected EditField getInsertarBusqueda() {
		return new EditField(this, getLocator(this, "getInsertarBusqueda"));
	}

	@WebElementLocator(webDesktop = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")
	protected Button getBuscar() {
		return new Button(this, getLocator(this, "getbuscar"));
	}

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopPagePrincipalGoogle extends PagePrincipalGoogle {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletPagePrincipalGoogle extends PagePrincipalGoogle {
}

/**
 * Phone Implementation for LandingPage
 */
class PhonePagePrincipalGoogle extends PagePrincipalGoogle {

}