package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(DesktopNavigateToRandomPage.class)

public class NavigateToRandomPage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() { }

    @WebElementLocator(webDesktop = "#mat-input-0")
    protected EditField getPapi() {
        return new EditField(this, getLocator(this, "getPapi"));
    }

    @WebElementLocator(webDesktop = "#mat-input-0")
    protected EditField getHijo() {
        return new EditField(getPapi(),  getLocator(this, "getHijo"));
    }
}

class DesktopNavigateToRandomPage extends NavigateToRandomPage {

}
