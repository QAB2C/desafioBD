package cupones.receptivo.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CuponesWeb;
import pages.PageLogin;

class CuponesWebTest {
    private static CuponesWeb cuponesWeb;
    private static PageLogin pageLogin;
    private static WebDriver driver;
    private static final String URL = "https://cuponeras.bestday.com/cupones/";

    @BeforeAll
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        pageLogin = new PageLogin(driver);
        cuponesWeb = new CuponesWeb(driver);
        //PageLogin pageLogin = new PageLogin(driver);
        assert pageLogin.login("BMXPRUEBA9", "temporal1");
    }

    @AfterAll
    public static void finalice() {

        cuponesWeb.finaliceWebClient();
    }

    @Test
    void reporteVentas() {

        assert cuponesWeb.reporteVentas();
    }
}