package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.VideoChunk;

public class Ejercicio_Video extends BaseTest {

	private VideoChunk videochuck;

	@Test(description = "Test HotelsResponsive 001")
	public void test() {

		LOGGER.info("Entramos al enlace video");
		videochuck = navigateToVideoPage();

		try {
			LOGGER.info("Saltamos el anuncio");
			videochuck.ClickButtonSkip();

			LOGGER.info("Pausamos el video");
			videochuck.ClickButtonPausa();

			LOGGER.info("Reproducimos el video");
			videochuck.ClickButtonPlay();
		} catch (Exception e) {
			LOGGER.error("No se pudo realizar el test correctamente.");
			e.printStackTrace();
		}

	}
}
