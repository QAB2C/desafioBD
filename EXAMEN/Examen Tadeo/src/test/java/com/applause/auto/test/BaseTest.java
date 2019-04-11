package com.applause.auto.test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import com.applause.auto.pageframework.pages.GoogleLandingPage;
import com.applause.auto.pageframework.pages.RandomLandingPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.applause.auto.framework.pageframework.util.drivers.DriverWrapper;
import com.applause.auto.framework.pageframework.util.drivers.DriverWrapperManager;
import com.applause.auto.framework.pageframework.util.environment.EnvironmentUtil;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.util.queryhelpers.WebElementQueryHelper;
import com.applause.auto.framework.pageframework.util.synchronization.WebSyncHelper;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.test.listeners.TestListener;
import com.applause.auto.pageframework.helpers.BestDayTestHelper;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.testdata.CustomerConfig;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;

@Listeners(TestListener.class)
public class BaseTest {

	protected static final LogController LOGGER;

	@SuppressWarnings("unused")
	private static CustomerConfig config;

	protected static DriverWrapper driverWrapper;
	protected static WebDriver driver;
	protected static WebSyncHelper syncHelper;
	protected static WebElementQueryHelper queryHelper;
	protected static EnvironmentUtil env;
	protected BestDayTestHelper templateTestHelper;

	static {
		config = new CustomerConfig();
		env = EnvironmentUtil.getInstance();
		LOGGER = new LogController(MethodHandles.lookup().lookupClass());
	}

	/**
	 * Get a new WebDriver at the start of each test.
	 */
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		String runId = String.format("%s:%s", method.getName(), System.currentTimeMillis());
		LOGGER.debug(String.format("Setting runId to %s", runId));
		System.setProperty("runId", runId);
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

		driverWrapper = new DriverWrapper(EnvironmentUtil.getDriver(), env.getDriverProvider());
		driver = (WebDriver) driverWrapper.getDriver();
		syncHelper = (WebSyncHelper) driverWrapper.getSyncHelper();
		queryHelper = (WebElementQueryHelper) driverWrapper.getQueryHelper();

		templateTestHelper = new BestDayTestHelper();

		// Maximize the browser for desktop platforms
		if (!env.getIsMobileWebTest()) {
			driver.manage().window().maximize();
		}

		LOGGER.info("Test case setup complete.");
	}

	/**
	 * Destroy the WebDriver at the end of the test.
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
		DriverWrapperManager.getInstance().deregisterDriver(driverWrapper);
		LOGGER.info("Test case teardown complete.");
	}

	/*
	 * Platform Agnostic Test Helpers
	 */

	protected LandingPage navigateToLandingPage() {
		LOGGER.info(String.format("Navigating to the landing page '%s'", TestData.RANDOM_PAGE_URL));
		driver.navigate().to(TestData.LANDING_PAGE_URL);
		return PageFactory.create(LandingPage.class);
	}

	protected RandomLandingPage navigateToRandomPage() {
		LOGGER.info(String.format("Navigating to the landing page '%s'", TestData.RANDOM_PAGE_URL));
		driver.navigate().to(TestData.RANDOM_PAGE_URL);
		return PageFactory.create(RandomLandingPage.class);
	}

	protected GoogleLandingPage navigateToGooglePage() {
		LOGGER.info(String.format("Navigating to the landing page '%s'", TestData.GOOGLE_PAGE_URL));
		driver.navigate().to(TestData.GOOGLE_PAGE_URL);
		return PageFactory.create(GoogleLandingPage.class);
	}

	public int devolverEntero() {
		LOGGER.info("hola mundo");
		return 6;
	}

	public Boolean devolverBolean() {
		LOGGER.info("hola mundo2");
		return true;
	}

	public String devolverString() {
		LOGGER.info("hola mundo3");
		return "Tadeo valenzuela";
	}

	public RandomLandingPage devolverPaginaLanding() {
		LOGGER.info("hola mundo4");
		driver.navigate().to(TestConstants.TestData.RANDOM_PAGE_URL);
		return PageFactory.create(RandomLandingPage.class);
	}



}