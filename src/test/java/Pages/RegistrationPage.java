package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getUsernameField() {
		return driver.findElement(By.id("sign-username"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("sign-password"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//button[text()='Sign up']"));
	}
}
