package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import com.applause.auto.pageframework.Chunks.CancellationPoliciesKRChunk;

@WebDesktopImplementation(DesktopRoomListKR.class)
@WebTabletImplementation(TabletRoomListKR.class)
@WebPhoneImplementation(PhoneRoomListKR.class)
public class RoomListKR extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		syncHelper.suspend(3000);
		syncHelper.waitForElementToAppear(getHotelName());
	}

	// Espera a que se muestre el nombre del hotel
	public String getName() {
		return getHotelName().getText();
	}

	// Hace click en la seccion Habitaciones
	public void tapRooms() {
		tapButtonRooms().click();
	}

	// Hace click en el primer enlace para mostrar las politicas de cancelacion
	public CancellationPoliciesKRChunk tapCancellationPolicy() {
		cancellationPoliciesList().stream().findFirst().get().click();
		return PageFactory.create(CancellationPoliciesKRChunk.class);
	}

	@WebElementLocator(webDesktop = "#sectionTitle")
	protected Text getHotelName() {
		return new Text(this, getLocator(this, "getHotelName"));
	}

	@WebElementLocator(webDesktop = ".icono-bed")
	protected Button tapButtonRooms() {
		return new Button(this, getLocator(this, "tapButtonRooms"));
	}

	@WebElementLocator(webDesktop = "//a[@class='kdo--modal__toggle-modal LinkPolicyPrivacy']") //// *[@id='hotelName-ui']/h4/a
	protected List<WebElement> cancellationPoliciesList() {
		return getDriver().findElements(By.xpath(getLocator(this, "cancellationPoliciesList")));
	}
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopRoomListKR extends RoomListKR {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletRoomListKR extends RoomListKR {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneRoomListKR extends RoomListKR {

}
