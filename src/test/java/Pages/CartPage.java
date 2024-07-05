package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void placeOrder(String name, String country, String city, String card, String month, String year) {
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("card")).sendKeys(card);
		driver.findElement(By.id("month")).sendKeys(month);
		driver.findElement(By.id("year")).sendKeys(year);
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	}
}
