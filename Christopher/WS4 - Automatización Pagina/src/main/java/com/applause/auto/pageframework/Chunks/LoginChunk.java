package com.applause.auto.pageframework.Chunks;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopLoginChunk.class)
@WebTabletImplementation(TabletLoginChunk.class)
@WebPhoneImplementation(MobileLoginChunk.class)
public class LoginChunk extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	/*
	 * Public Actions
	 */

	/**
	 * Get Text of userName
	 * 
	 * @return Username text
	 */
    //Ingresa el Usuario
	public void enterUser(String User) {
		LOGGER.info(String.format("Entering a User", User));
		getUserTextBox().setText(User);
		syncHelper.waitForElementToAppear(getUserTextBox());
		getNextButton().click();
	}
    //Ingresa la contraseña
	public void enterPass(String Pass) {
		LOGGER.info(String.format("Entering a Password", Pass));
		getPassTextBox().setText(Pass);
		syncHelper.waitForElementToAppear(getPassTextBox());
		getNextButton().click();
		getNextButton().click();
	}

	/*
	 * Protected Getters
	 */
	// Edita el campo de Usuario
	@WebElementLocator(webDesktop = "#i0116")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	// Oprime Boton Next y SignIn
	@WebElementLocator(webDesktop = "#idSIButton9")
	protected Button getNextButton() {
		return new Button(this, getLocator(this, "getNextButton"));
	}

	// Edita el campo de la Contraseña
	@WebElementLocator(webDesktop = "#i0118")
	protected EditField getPassTextBox() {
		return new EditField(this, getLocator(this, "getPassTextBox"));
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
class DesktopLoginChunk extends LoginChunk {

}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletLoginChunk extends LoginChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class MobileLoginChunk extends LoginChunk {

}