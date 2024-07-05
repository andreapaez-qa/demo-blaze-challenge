package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void goToNextPage() {
		WebElement nextPageButton = driver.findElement(By.id("next2"));
		nextPageButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public List<WebElement> getProductElements() {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".hrefch")));
		return driver.findElements(By.cssSelector(".hrefch"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("signin2"));
	}

	public void navigateToCart() {
		driver.findElement(By.id("cartur")).click();
	}

	public void selectCategory(String category) {
		WebElement categoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(category)));
		categoryLink.click();
	}

	public boolean isProductDisplayed(String productName) {
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + productName + "')]")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
