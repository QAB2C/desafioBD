package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class GoogleSearchTests extends BaseTest {

	private HomePage homePage;

	@Test(groups = { TestNGGroups.GOOGLE }, description = "666")
	public void testSearchGoogle() {

		LOGGER.info("1. Navigate to home page");
		homePage = navigateGoogle();
		
		homePage.enterSearchAndConfirm(TestConstants.TestData.BUSQUEDA);
		
		Assert.assertTrue(homePage.resultPage());

	}
}
