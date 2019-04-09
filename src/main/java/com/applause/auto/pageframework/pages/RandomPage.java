package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

import java.lang.invoke.MethodHandles;
import java.util.Random;

@WebDesktopImplementation(DesktopRandomPage.class)
@WebTabletImplementation(TabletRandomPage.class)
@WebPhoneImplementation(PhoneRandomPage.class)
public abstract class RandomPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		//syncHelper.waitForElementToAppear(ingresarDatos());

	}


}

/**
 * Desktop Implementation for RandonPage
 */
class DesktopRandomPage extends RandomPage {

}

/**
 * Tablet Implementation for RandomPage
 */
class TabletRandomPage extends RandomPage {
}

/**
 * Phone Implementation for RandonPage
 */
class PhoneRandomPage extends RandomPage {

}