package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.GooglePage;
import com.applause.auto.pageframework.pages.GoogleResultPage;

public class TestGoogle extends BaseTest {

	public GooglePage googlepage;
	public GoogleResultPage googlesearchpage;

	@Test(description = "Test Google")
	public void TestGoogle() {

		LOGGER.info(String.format("Se ingresa a la pagina de Google"));
		googlepage = navigateToGooglePage();

		LOGGER.info(String.format("Ingresamos la palabra a buscar enla pagina"));
		googlepage.search("Hola mundo.");

		LOGGER.info(String.format("Hacemos click en buscar"));
		googlesearchpage = googlepage.tabButton();

		LOGGER.info(String.format("Buscamos que nos regrese resultados."));
		googlesearchpage.getSearchResultsSummaryText();

	}

}
