package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelUtils;

public class CartPage extends AttributesClass{
	
	private final String dataSource = "tables/pet-store-data.xlsx";

	public CartPage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
		
	}
	
	public WebElement getCart() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("cartBtn")));
	}
	
	public void openCart() {
		this.getCart().click();
	}

	public void addToCart() {
		ExcelUtils.setExcell(dataSource);
		ExcelUtils.setWorkSheet(0);
		
		StoreItemPage sip = new StoreItemPage(driver, selectors, locators, waiter);
		
		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			
			String excelItem = ExcelUtils.getDataAt(i, 1);
			this.driver.navigate().to(excelItem);
			sip.addItemToCart();
			
		}
	}
}
