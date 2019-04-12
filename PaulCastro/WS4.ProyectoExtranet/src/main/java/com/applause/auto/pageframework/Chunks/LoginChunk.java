package com.applause.auto.pageframework.Chunks;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopLoginChunk.class)
public class LoginChunk extends AbstractPage {

    @Override
    protected void waitUntilVisible() {

        syncHelper.waitForElementToAppear(getLoginTittle());
    }


    public String getLoginTittleText() {
        return getLoginTittle().getText();
    }

    @WebElementLocator(webDesktop = "div > h2")
    protected Text getLoginTittle() {
        return new Text(this, getLocator(this, "getLoginTittle"));
    }
}

class DesktopLoginChunk extends LoginChunk {

}
