package com.applause.auto.pageframework.Chunks;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopGChunk.class)
@WebTabletImplementation(TabletGChunk.class)
@WebPhoneImplementation(MobileGChunk.class)
public class GoogleChunk extends AbstractPage {

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getUsername());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get Text of userName
	 * 
	 * @return Username text
	 */
	public String getUsernameText() {
          return getUsername().getText();
	}

	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = "div > h2", webTablet = "div > h2", webMobile = "div > h2")
	protected Text getUsername() {
		return new Text(this, getLocator(this, "getUsername"));
	}
}

/**
 * 
 * Desktop Implementation for Account Chunk
 */
class DesktopGChunk extends GoogleChunk {

}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletGChunk extends GoogleChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class MobileGChunk extends GoogleChunk {

}