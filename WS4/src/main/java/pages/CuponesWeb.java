package pages;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CuponesWeb {
    private WebDriver driver;

    public CuponesWeb (WebDriver driver){
        this.driver = driver;

    }

    public void finaliceWebClient() {
        driver.quit();
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

    public boolean reporteVentas() {

        driver.findElement(By.linkText("Reportes")).click();
        Helpers helpers = new Helpers();
        Helpers.sleep(4000);
        driver.findElement(By.linkText("Reporte de Ventas Diarias Reps")).click();
        try {
            driver.findElement(By.id("Reporte"));
            Select combo = new Select(driver.findElement(By.id("ctl00_SampleContent_ddlReps")));
            combo.selectByValue("9999");
            driver.findElement(By.name("ctl00$SampleContent$btnReporte")).click();
            Helpers.sleep(10000);
            // Si llega aqui es que el Reporte existe
            driver.findElement(By.id("ctl00_SampleContent_crystalReportViewer"));


            return true;

        } catch (NoSuchElementException ex) {
            // No ingreso en la pagina
            return false;

        }
    }
}
