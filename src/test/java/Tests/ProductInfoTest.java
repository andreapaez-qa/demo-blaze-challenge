package Tests;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductPage;

public class ProductInfoTest {
	private WebDriver driver;
	private ProductPage productPage;
	private HomePage homePage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "../DemoBlaze/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		productPage = new ProductPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void extractProductInfo() throws IOException {
		FileWriter writer = new FileWriter("product_info.txt");
		try {
			for (int i = 0; i < 2; i++) {
				waitForElementsToLoad();
				List<WebElement> products = productPage.getProductElements();
				for (WebElement product : products) {
					String name = productPage.getProductName(product);
					String price = productPage.getProductPrice(product);
					String link = productPage.getProductLink(product);
					writer.write("Name: " + name + ", Price: " + price + ", Link: " + link + "\n");
				}

				if (i == 0) {
					homePage.goToNextPage();

					Thread.sleep(5000);
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Thread interrupted", e);
		} finally {
			writer.close();
		}
	}

	private void waitForElementsToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
