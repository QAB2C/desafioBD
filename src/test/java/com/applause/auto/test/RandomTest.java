package com.applause.auto.test;

import com.applause.auto.pageframework.pages.RandomPage;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.annotations.Test;

public class RandomTest extends BaseTest {

    private RandomPage pagInicio;



    @Test(groups = {TestNGGroups.LOGIN})
    public void Login() {

        LOGGER.info("1. Navigate to page");
        pagInicio = navigateToRandom();



    }
}
