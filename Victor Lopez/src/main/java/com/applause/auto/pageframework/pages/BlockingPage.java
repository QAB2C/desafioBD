package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;

@WebDesktopImplementation(BlockingPage.class)

public class BlockingPage extends AbstractPage {

    @Override
    protected void waitUntilVisible() {

        syncHelper.suspend(15000);


    }
}
