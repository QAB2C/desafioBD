package com.applause.auto.pageframework.Chunks;

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
import com.applause.auto.pageframework.pages.HomePageAurora;

@WebDesktopImplementation(DesktopAuroraChunk.class)
@WebTabletImplementation(TabletAuroraChunk.class)
@WebPhoneImplementation(MobileAuroraChunk.class)

public class LoginAuroraChunk extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	/*
	 * Public Actions
	 */

	public void UserPassword(String User, String Password) {
		LOGGER.info(String.format("Entering destination %s into search field", User));
		getUserTextBox().setText(User);

		LOGGER.info(String.format("Entering destination %s into search field", Password));
		getPasswordTextBox().setText(Password);
	}

	public HomePageAurora IngresarButtom() {
		getIngresarButton().click();
		LOGGER.info("Ingresar Button");
		return PageFactory.create(HomePageAurora.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//*[@id=\"userLogin\"]")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	@WebElementLocator(webDesktop = "#passwordLogin")
	protected EditField getPasswordTextBox() {
		return new EditField(this, getLocator(this, "getPasswordTextBox"));
	}

	@WebElementLocator(webDesktop = "#form_btn_log")
	protected Button getIngresarButton() {
		return new Button(this, getLocator(this, "getIngresarButton"));
	}

	@Override
	protected void waitUntilVisible() {
		// TODO Auto-generated method stub

	}

}

/**
 * 
 * Desktop Implementation for Account Chunk
 */
class DesktopAuroraChunk extends LoginAuroraChunk {

}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletAuroraChunk extends DesktopAuroraChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class MobileAuroraChunk extends DesktopAuroraChunk {

}