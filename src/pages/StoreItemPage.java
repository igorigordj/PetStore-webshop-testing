package pages;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoreItemPage extends AttributesClass{
	
	public StoreItemPage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
	}
	
	public WebElement getAddToCartBtn() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("addToCart")));
	}
	
	public void addItemToCart() {
		this.getAddToCartBtn().click();
	}

}
