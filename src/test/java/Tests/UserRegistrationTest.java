package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegistrationPage;

public class UserRegistrationTest {
	private WebDriver driver;
	private HomePage homePage;
	private RegistrationPage registrationPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../DemoBlaze/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com");
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
	}

	@Test
	public void testUserRegistration() {
		homePage.getSignInButton().click();
		registrationPage.getUsernameField().sendKeys("newUser");
		registrationPage.getPasswordField().sendKeys("password123");
		registrationPage.getSignUpButton().click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
