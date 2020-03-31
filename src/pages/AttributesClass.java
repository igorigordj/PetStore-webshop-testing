package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AttributesClass 
{

	protected WebDriver driver;
	protected Properties selectors;
	protected Properties locators;
	protected WebDriverWait waiter;
	
	public AttributesClass(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
	
		this.driver = driver;
		this.selectors = selectors;
		this.locators = locators;
		this.waiter = waiter;
	}
	
	
	
	
}
