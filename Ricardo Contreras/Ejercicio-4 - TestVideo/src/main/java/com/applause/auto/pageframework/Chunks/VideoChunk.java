package com.applause.auto.pageframework.Chunks;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
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

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

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
	public void ClickButtonSkip() {
		if (BarPadding().exists()) {
			LOGGER.info(String.format("Esperamos ah que pasen los 5 segundos para omitir el anuncio."));
			syncHelper.waitForElementToAppear(ButtonSaltar());
			LOGGER.info(String.format("Damos click en el botón para saltar el anuncio."));
			ButtonSaltar().click();
		} else {
			LOGGER.info(String.format("No se encontro un anuncio."));
		}
	}

	public void ClickButtonPausa() {
		LOGGER.info(String.format("Esperamos ah que pasen los 15 segundos para pausar el video."));
		syncHelper.suspend(5000);
		LOGGER.info(String.format("Damos click sobre el video para pausarlo."));
		ButtonPausa().click();
	}

	public void ClickButtonPlay() {
		LOGGER.info(String.format("Esperamos ah que pasen los 5 segundos para dar play al video."));
		syncHelper.suspend(5000);
		LOGGER.info(String.format("Damos click sobre el botón de play para seguir reproduciendo el video."));
		ButtonPlay().click();
	}

	@WebElementLocator(webDesktop = ".ytp-ad-skip-button-icon")
	protected Button ButtonSaltar() {
		return new Button(this, getLocator(this, "ButtonSaltar"));
	}

	@WebElementLocator(webDesktop = "#movie_player")
	protected Button ButtonPausa() {
		return new Button(this, getLocator(this, "ButtonPausa"));
	}

	@WebElementLocator(webDesktop = ".ytp-play-button")
	protected Button ButtonPlay() {
		return new Button(this, getLocator(this, "ButtonPlay"));
	}

	@WebElementLocator(webDesktop = ".ytp-ad-preview-container")
	protected Button BarPadding() {
		return new Button(this, getLocator(this, "BarPadding"));
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