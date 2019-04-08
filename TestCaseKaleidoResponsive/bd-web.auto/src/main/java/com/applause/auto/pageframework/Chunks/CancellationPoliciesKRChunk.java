package com.applause.auto.pageframework.Chunks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;

@WebDesktopImplementation(DesktopCancellationPoliciesKRChunk.class)
@WebTabletImplementation(TabletCancellationPoliciesKRChunk.class)
@WebPhoneImplementation(PhoneCancellationPoliciesKRChunk.class)
public class CancellationPoliciesKRChunk extends AbstractPage {
	@Override
	protected void waitUntilVisible() {

		syncHelper.suspend(3000);
	}

	public String modalTitle() {
		String mCPT = ModalCancellationTitle().stream().findFirst().get().getText();
		System.out.println(mCPT);
		System.out.println(ModalCancellationContent().stream().findFirst().get().getText());
		return mCPT;
	}

	@WebElementLocator(webDesktop = "//div[@class='kdo--modal__title kdo-color-base--light kdo-color-border']/h4")
	protected List<WebElement> ModalCancellationTitle() {
		return getDriver().findElements(By.xpath(getLocator(this, "ModalCancellationTitle")));
	}

	@WebElementLocator(webDesktop = "//div[@class='kdo--modal__center-content']")
	protected List<WebElement> ModalCancellationContent() {
		return getDriver().findElements(By.xpath(getLocator(this, "ModalCancellationContent")));
	}
}

/**
 * 
 * Desktop Implementation for Account Chunk
 */
class DesktopCancellationPoliciesKRChunk extends CancellationPoliciesKRChunk {
}

/**
 * Tablet Implementation for Account chunk
 *
 */
class TabletCancellationPoliciesKRChunk extends CancellationPoliciesKRChunk {

}

/**
 * Mobile Implementation for Account Chunk
 *
 */
class PhoneCancellationPoliciesKRChunk extends CancellationPoliciesKRChunk {

}
