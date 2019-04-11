package com.applause.googleSearch.test;

import com.applause.auto.pageframework.pages.GoogleLandingPage;
import com.applause.auto.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.GoogleLandingPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class SearchGooglePage extends BaseTest {

	private GoogleLandingPage landingPage;
	// private SearchResultsPage searchResultsPage;

	protected int a = 8;
	private boolean b = true;
	public String c = "hola";
	private GoogleLandingPage aaaa;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")

	public void testSearchPageGoogle() {

		LOGGER.info("1. Navegar por Pagina GoogleLandingPage");
		aaaa = navigateToGooglePage();

		driver.findElement(By.xpath("//*[@id=\'tsf\']/div[2]/div/div[1]/div/div[1]/input")).sendKeys("ISTQB");
		driver.findElement(By.id("viewport")).click();
		driver.findElement(By.xpath("//*[@id=\'tsf\']/div[2]/div/div[3]/center/input[1]")).click();

	}



}
