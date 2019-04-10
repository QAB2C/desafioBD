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

@WebDesktopImplementation(MyBookingsAurora.class)
@WebTabletImplementation(MyBookingsAurora.class)
@WebPhoneImplementation(MyBookingsAurora.class)
public class MyBookingsAurora extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		// syncHelper.suspend(1000);
		// syncHelper.waitForElementToAppear(getMyBooking());
	}

	/*
	 * Public Actions
	 */
	public LandingPageAurora IngresarMR() {
		getMyBooking().click();
		return PageFactory.create(LandingPageAurora.class);
	}

	public LandingPageAurora AllMR() {
		getTodaMisReservas().click();
		return PageFactory.create(LandingPageAurora.class);
	}

	/*
	 * Protected Getters
	 */
	// a[@href='/MyBookings/List' and text()='']
	// a[@href='/MyBookings/List' and contains(text(),' Mis reservas')]
	@WebElementLocator(webDesktop = "//a[@href='/MyBookings/List' and contains(text(),' Mis reservas')]")
	protected Button getMyBooking() {
		return new Button(this, getLocator(this, "getMyBooking"));
	}

	@WebElementLocator(webDesktop = "#All")
	protected Button getTodaMisReservas() {
		return new Button(this, getLocator(this, "getTodaMisReservas"));
	}
}