package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import com.applause.auto.pageframework.helpers.KRHelper;

@WebDesktopImplementation(DesktopHotelListKR.class)
@WebTabletImplementation(TabletHotelListKR.class)
@WebPhoneImplementation(PhoneHotelListKR.class)
public class HotelListKR extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		syncHelper.suspend(5000);
		syncHelper.waitForElementToAppear(getSearchFirstPriceResult());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get the text from the search results summary for verification
	 * 
	 * @return the text from the search results summary
	 */
	public String getSearchFirstResult() {
		// System.out.println(getSearchFirstPriceResult().getText());
		return getSearchFirstPriceResult().getText();
	}

	public RoomListKR getResultListAndSelect() {
		Map<Integer, WebElement> lhp = new HashMap<Integer, WebElement>();
		Iterator<Integer> lsht1 = priceList().stream().map(x -> Integer.parseInt(x.getText().replaceAll("[^\\d.]", "")))
				.iterator();

		Iterator<WebElement> llsht2 = hotelList().iterator();

		while (lsht1.hasNext() && llsht2.hasNext()) {
			lhp.put(lsht1.next(), llsht2.next());
		}

		/*
		 * for (Map.Entry<Integer, WebElement> entry : lhp.entrySet()) {
		 * System.out.println(entry.getValue().getText() + " $" +
		 * entry.getKey()); }
		 */

		int Value = (Collections.min(lhp.keySet()));
		for (Map.Entry<Integer, WebElement> entry : lhp.entrySet()) {
			if (entry.getKey() == Value) {
				// System.out.println(entry.getKey() + " " + entry.getValue());
				LOGGER.info(String.format("The most cheapest hotel is: %s with the following price %5d",
						entry.getValue().getText(), entry.getKey()));
				KRHelper.VerticalScroll(getDriver(), entry.getValue().getLocation().y);
				entry.getValue().click();
			}
		}
		return PageFactory.create(RoomListKR.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = ".kdo-product--main-price")
	protected Text getSearchFirstPriceResult() {
		return new Text(this, getLocator(this, "getSearchFirstPriceResult"));
	}

	@WebElementLocator(webDesktop = "//*[@id='hotelBook-ui']/div/a/p[@class='kdo-color-text--dark kdo-product--main-price']")
	protected List<WebElement> priceList() {
		return getDriver().findElements(By.xpath(getLocator(this, "priceList")));
	}

	@WebElementLocator(webDesktop = "//h4[@class='kdo-product-box__product-name']/a") //// *[@id='hotelName-ui']/h4/a
	protected List<WebElement> hotelList() {
		return getDriver().findElements(By.xpath(getLocator(this, "hotelList")));
	}

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopHotelListKR extends HotelListKR {
}

/**
 * Tablet Implementation for LandingPage
 */
class TabletHotelListKR extends HotelListKR {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneHotelListKR extends HotelListKR {
}