package com.applause.auto.test;

import com.applause.auto.pageframework.pages.Google;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


class GoogleTest {

    private static Google google;
    private static WebDriver driver;
    private static final String URL = "https://www.google.com/";


    @BeforeAll
    public static void setup() {
        // Indico donde esta el chromedriver y la cual es la URL

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }

    @AfterAll
    public static void finalice() {
        // Una vez ejecutada mi test se cierre el driver

        driver.quit();
    }

    @Test
    void search() {

        // Mi test es pasar el nombre de la busqueda al metodo serchgoogle para ser ejecutado

        google = new Google(driver);
        assert google.searchgoogle("Automation");

    }
}