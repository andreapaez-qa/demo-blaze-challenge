package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;

public class PurchaseProductTest {
	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;
	private CartPage cartPage;
	private WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "../DemoBlaze/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com");
		homePage = new HomePage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void testPurchaseProduct() {
		homePage.getProductElements().get(0).click();
		productPage.addToCart();

		wait.until(ExpectedConditions.alertIsPresent()).accept();
		homePage.navigateToCart();
		productPage.proceedToCheckout();
		cartPage.placeOrder("Andrea Paez", "Argentina", "CABA", "1234567890123456", "12", "2025");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
