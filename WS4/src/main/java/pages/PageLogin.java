package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {

    private WebDriver driver;

    public PageLogin (WebDriver driver){
        this.driver = driver;

    }


    public boolean login(String username, String password) {
        String actualResult;
        String expectedResult = "Cupones BestDay";

        driver.findElement(By.name("txtClave")).sendKeys(username);
        driver.findElement(By.name("txtContrasena")).sendKeys(password);
        driver.findElement(By.name("ibAceptar")).click();
        actualResult = driver.getTitle();
        return actualResult.contentEquals(expectedResult);
    }

}

