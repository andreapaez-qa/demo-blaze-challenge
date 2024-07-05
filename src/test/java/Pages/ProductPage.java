package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public ProductPage(WebDriver driver) {
		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void addToCart() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[onclick='addToCart(1)']")));
		driver.findElement(By.cssSelector("a[onclick='addToCart(1)']")).click();
	}

	public void proceedToCheckout() {
		driver.findElement(By.cssSelector("button[data-target='#orderModal']")).click();
	}

	public List<WebElement> getProductElements() {
		return driver.findElements(By.cssSelector(".card-block"));
	}

	public String getProductName(WebElement product) {
		return product.findElement(By.cssSelector(".card-title a")).getText();
	}

	public String getProductPrice(WebElement product) {

		WebElement priceElement = product.findElement(By.tagName("h5"));
		return priceElement.getText();
	}

	public String getProductLink(WebElement product) {
		return product.findElement(By.cssSelector(".card-title a")).getAttribute("href");
	}
}
