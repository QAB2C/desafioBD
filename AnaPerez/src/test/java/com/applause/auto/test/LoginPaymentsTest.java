package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingPaymentsPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestPageConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;


public class LoginPaymentsTest extends BasePaymentsTest {
	
	private LandingPaymentsPage landingPaymentsPage;

	public void testLoginPayments() {	
		
		LOGGER.info("1. Navigate to landingPaymentsFilters page");
		landingPaymentsPage = navigateToPaymentsFiltersPage();
		landingPaymentsPage.enterLogin(TestPageConstants.TestPaymentsData.USERNAME,TestPageConstants.TestPaymentsData.PASSWORD);
	}
	

}
