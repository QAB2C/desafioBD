package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(DesktopBusquedaGooglePage.class)

public abstract class BusquedaGooglePage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        //syncHelper.waitForElementToAppear(getDestinationTextBox());
    }


    public void enterWordTestAndConfirm(String wordTest) {
        LOGGER.info(String.format("Entering word test %s into search field", wordTest));
        getSearchTextBox().setText(wordTest);
        syncHelper.waitForElementToAppear(getDropdownItem());
        getDropdownItem().click();
    }

    public GoogleSearchResultPage tapSearchButton() {
        getSearchButton().click();
        LOGGER.info("Tap on Search Button");
        return PageFactory.create(GoogleSearchResultPage.class);
    }



    @WebElementLocator(webDesktop = ".gLFyf")
    protected EditField getSearchTextBox() {
        return new EditField(this, getLocator(this, "getSearchTextBox"));
    }

    @WebElementLocator(webDesktop = ".erkvQe")
    protected Link getDropdownItem() {
        return new Link(this, getLocator(this, "getDropdownItem"));
    }

    @WebElementLocator(webDesktop = ".jhp input[value=\"Me siento con suerte \"]")
    protected Button getSearchButton() {
        return new Button(this, getLocator(this, "getSearchButton"));
    }
}

class DesktopBusquedaGooglePage extends BusquedaGooglePage {

}
