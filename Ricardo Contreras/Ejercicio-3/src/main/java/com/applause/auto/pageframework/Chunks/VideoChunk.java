package com.applause.auto.pageframework.Chunks;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;

@WebDesktopImplementation(DesktopAccountChunk.class)
@WebTabletImplementation(TabletAccountChunk.class)
@WebPhoneImplementation(MobileAccountChunk.class)
public class VideoChunk extends AbstractPage {

	@Override
	protected void waitUntilVisible() {
		syncHelper.suspend(1000);
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get Text of userName
	 * 
	 * @return Username text
	 */
	public void ClickButtonPlay() {
		syncHelper.waitForElementToAppear(getButton());
		ButtonSaltar().click();
		getButton().click();
	}

	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = ".ytp-svg-fill")
	protected Button getButton() {
		return new Button(this, getLocator(this, "getButton"));
	}

	@WebElementLocator(webDesktop = "#ad-text:t")
	protected Button ButtonSaltar() {
		return new Button(this, getLocator(this, "ButtonSaltar"));
	}

}

/**
 * 
 * Desktop Implementation for Account Chunk
 */
class DesktopAccountChunk extends VideoChunk {

}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletAccountChunk extends VideoChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class MobileAccountChunk extends VideoChunk {

}