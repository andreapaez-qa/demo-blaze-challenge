package Tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;

public class CategoryNavigationTest {
	private WebDriver driver;
	private HomePage homePage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "../DemoBlaze/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com");
		homePage = new HomePage(driver);
	}

	@Test
	public void testCategoryNavigation() {
		homePage.selectCategory("Phones");
		assertTrue(homePage.isProductDisplayed("Samsung galaxy s6"),
				"Samsung Galaxy S6 should be displayed under Phones category");

		homePage.selectCategory("Laptops");
		assertTrue(homePage.isProductDisplayed("Sony vaio i5"),
				"Sony vaio i5 should be displayed under Laptops category");

		homePage.selectCategory("Monitors");
		assertTrue(homePage.isProductDisplayed("Apple monitor 24"),
				"Apple monitor 24 should be displayed under Monitors category");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}