package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;


import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(SearchGoogleResultsPage.class)

public class SearchGoogleResultsPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

	}

}