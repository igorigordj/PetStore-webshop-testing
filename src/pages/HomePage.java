package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AttributesClass
{	

	public HomePage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
		
	}

	public WebElement getEnterBtn() 
	{
		return this.driver.findElement(By.xpath(selectors.getProperty("enterTheStore")));
	}
	
	public void enterTheStore()
	{
		this.getEnterBtn().click();
	}
	
	
}
