package com.applause.auto.pageframework.pages;

import com.sun.deploy.ref.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google {

    private WebDriver driver;

    public Google(WebDriver driver) {
        this.driver = driver;
    }
// Aqui es para darle un tiempo a la pagina de mostrar los resultados

    public static void sleep(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Aqui mi resultado esperado es cuando este en la pagina de resultados y esta sea igual a mi busqueda
    public boolean searchgoogle(String titulo) {

        String actualResult;
        String expectedResult = "automation - Google Search";
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys(titulo);
        searchbox.submit();
        Helpers helpers = new Helpers();
        sleep(5000);
        actualResult = driver.getTitle();

        return expectedResult.contentEquals(expectedResult);

    }


}

