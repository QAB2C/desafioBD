package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.AccountChunk;
import com.applause.auto.pageframework.helpers.BDTravelTestHelper;
import com.applause.auto.pageframework.pages.AddNewUserPage;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.UsersCatalogPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class AdminUsersTest extends BaseTest {

	private LandingPage landingPage;
	private AccountChunk accountChunk;
	private UsersCatalogPage usersCatalogPage;
	private AddNewUserPage addNewUserPage;

	@Test(groups = { TestNGGroups.ADMIN_USER }, description = "9483")
	public void testAddUserBbTravel() {

		LOGGER.info("1. Navigate to index page.");
		landingPage = navigateToLandingPage();

		// Assertions
		Assert.assertNotNull(landingPage, "Failed to navigate to the landing page.");

		LOGGER.info("2. login landing page.");
		landingPage.loginLandingPage(TestConstants.TestData.USERNAME, TestConstants.TestData.PASSWORD);

		LOGGER.info("3. Navigate to users Profile.");
		accountChunk = landingPage.navigateToUserProfile();
		// Assertions
		Assert.assertNotNull(accountChunk, "Failed Navigate To Users Catalog.");

		LOGGER.info("4. Navigate to users catalog");
		usersCatalogPage = accountChunk.navigateToUsersCatalog();

		// Assertions
		Assert.assertNotNull(usersCatalogPage, "Failed Users Catalog  page.");

		LOGGER.info("5. Navigate to add user page");
		addNewUserPage = usersCatalogPage.navigateToNewUserPage();

		LOGGER.info("6. Navigate to add user page");
		addNewUserPage.addNewUser(BDTravelTestHelper.getDataUser(TestConstants.TestData.NAMES),
				BDTravelTestHelper.getDataUser(TestConstants.TestData.SURNAME));

	}
}
