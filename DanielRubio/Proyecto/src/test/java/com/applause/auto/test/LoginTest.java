package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.LoginChunk;
import com.applause.auto.pageframework.Chunks.MenuChunk;
import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginTest extends BaseTest {

	private LoginChunk loginChunk;
	private HomePage homePage;
	private MenuChunk menuChunk;

	@Test(groups = { TestNGGroups.LOGIN }, description = "9483")
	public void testLogin() {

		LOGGER.info("1. Navigate to revbi page");
		loginChunk = loginToRvbiPage();

		Assert.assertNotNull(loginChunk, "Failed to navigate to the landing page.");

		loginChunk.enterUserAndConfirm(TestConstants.TestData.USERNAME);

		Assert.assertFalse(loginChunk.errorName(), "User incorrect");

		loginChunk.enterPassAndConfirm(TestConstants.TestData.PASSWORD);

		Assert.assertFalse(loginChunk.errorPass(), "Pass incorrect");

		LOGGER.info("2. Login success revbi");
		Assert.assertTrue(loginChunk.getSearchEmailText().contains(TestConstants.TestData.USERNAME));

		menuChunk = loginChunk.menuRvbi();

		homePage = menuChunk.navigateToRvbi();

		homePage.enterClosePage();

	}
}
