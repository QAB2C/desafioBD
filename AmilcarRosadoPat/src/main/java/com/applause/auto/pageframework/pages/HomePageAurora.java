package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(HomePageAurora.class)
@WebTabletImplementation(HomePageAurora.class)
@WebPhoneImplementation(HomePageAurora.class)
public class HomePageAurora extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		// syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(getDestinoTextBox());
	}

	/*
	 * Public Actions
	 */
	public void Destination(String Destino) {
		LOGGER.info(String.format("Entering destination %s into search field", Destino));
		getDestinoTextBox().setText(Destino);
	}

	public boolean ListHotels() {
		boolean Lista = true;

		/*
		 * List<String> ListaAjax = new ArrayList<String>();
		 * 
		 * for (int f = 0; f <= 10; f++) { ListaAjax.add(getListAjax().getText());
		 * 
		 * }
		 * 
		 * System.out.println(ListaAjax);
		 */
		syncHelper.waitForElementToAppear(getListAjax());
		System.out.println(getListAjax().getWebElement().getText());
		if (getListAjax().getText().contains("No se encontraron resultados")) {
			Lista = false;
		}
		return Lista;

	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//input[@id='destinationHotel']")
	protected EditField getDestinoTextBox() {
		return new EditField(this, getLocator(this, "getDestinoTextBox"));
	}

	@WebElementLocator(webDesktop = "//ul[@id='ui-id-2']")
	protected Dropdown getListAjax() {
		return new Dropdown(this, getLocator(this, "getListAjax"));
	}

}