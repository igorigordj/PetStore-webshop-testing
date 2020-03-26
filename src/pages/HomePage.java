package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AttributesClass
{

	
	
	public HomePage(WebDriver driver, Properties selector) {
		super(driver, selector);
		
	}

	public WebElement getEnterBtn() 
	{
		return this.driver.findElement(By.xpath(selector.getProperty("enterTheStore")));
	}
	
	public void enterTheStore()
	{
		this.getEnterBtn().click();
	}
	
	
}
