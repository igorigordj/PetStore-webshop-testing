package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage extends AttributesClass{
	
	

	public CartPage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
		
	}
	
	public WebElement getCart() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("cartBtn")));
	}
	
	public void openCart() {
		this.getCart().click();
	}

	//gets items list from the cart
	public List<WebElement> getItems() {
		return this.driver.findElements(By.xpath(this.selectors.getProperty("items")));
	}
	
	
	//checks if item is added to the cart
	public boolean isItemInCart(String itemId) {
		boolean isInCart = false;
		 List <WebElement> items = this.getItems();
			for (int i = 0; i < items.size(); i++) {
				if(this.getItems().get(i).getText().contains(itemId)){
					isInCart = true;
				}
			}
		return isInCart;
	}
	
	//checks if cart is empty
	public boolean isCartEmpty() {
		boolean isEmpty = false;
		List <WebElement> items = this.getItems();
		if(items.isEmpty()) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
}
