package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class firstTest {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(
				"http://cuponerasprueb.bestday.com/OperacionesWebPCanaQA/Login.aspx?TabletID=faa26ffba85ef85a&ROL=A");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaUno() {
		driver.findElement(By.name("txtUsuario")).sendKeys("BMXDDT006040");
		driver.findElement(By.name("txtClave")).sendKeys("locked21");
		driver.findElement(By.id("cmdLogin")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.id("txtFiltroNombre")).sendKeys("jennifer");
		driver.findElement(By.xpath("//*[@id='Reservas']/div[1]/div[1]/div/div[1]/div/button")).click();
		driver.findElement(By.xpath("//*[@id='bookingListado15044201-1']/td[13]/button")).click();
		
	}

	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
