package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;

import java.lang.invoke.MethodHandles;




@WebDesktopImplementation(RandomLandingPage.class)
@WebTabletImplementation(RandomLandingPage.class)
@WebPhoneImplementation(RandomLandingPage.class)
public class RandomLandingPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		//dismissPopup();
		//syncHelper.waitForElementToAppear(getDestinationTextBox());
	}
}

class DesktopRandomLandingPage extends RandomLandingPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletRandomLandingPage extends RandomLandingPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneRandomLandingPage extends RandomLandingPage {

}




