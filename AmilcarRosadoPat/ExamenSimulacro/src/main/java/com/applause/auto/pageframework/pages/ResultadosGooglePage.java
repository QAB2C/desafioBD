package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(ResultadosGooglePage.class)
@WebTabletImplementation(ResultadosGooglePage.class)
@WebPhoneImplementation(ResultadosGooglePage.class)
public class ResultadosGooglePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(getResultadoBusqueda());
	}

	/*
	 * Public Actions
	 */
	public boolean ListHotels() {

		boolean Lista = true;

		System.out.println(Busqueda());
		if (Busqueda().contains("amilcar antonio rosado pat - Senior QA Tester - Best / Day | LinkedIn")) {
			Lista = false;
		}
		return Lista;

	}

	/**
	 * Get the text from the search results summary for verification
	 * 
	 * @return the text from the search results summary
	 */
	public String Busqueda() {

		return getResultadoBusqueda().getText();
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/h3")
	protected Text getResultadoBusqueda() {
		return new Text(this, getLocator(this, "getResultadoBusqueda"));
	}
}