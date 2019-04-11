package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.util.queryhelpers.WebElementQueryHelper;
import com.applause.auto.framework.pageframework.util.synchronization.WebSyncHelper;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.util.drivers.DriverWrapper;
import com.applause.auto.framework.pageframework.util.drivers.DriverWrapperManager;
import com.applause.auto.framework.pageframework.util.environment.EnvironmentUtil;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import com.applause.auto.pageframework.helpers.BestDayTestHelper;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;

@WebDesktopImplementation(DesktopLandingPageD.class)
@WebTabletImplementation(TabletLandingPageD.class)
@WebPhoneImplementation(PhoneLandingPageD.class)
public abstract class LandingDrakkars extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// dismissPopup();
		// syncHelper.waitForElementToAppear(getDestinationTextBox());
	}

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopLandingPageD extends LandingDrakkars {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletLandingPageD extends LandingDrakkars {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneLandingPageD extends LandingDrakkars {

}