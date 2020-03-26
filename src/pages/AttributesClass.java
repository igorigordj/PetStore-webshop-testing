package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public abstract class AttributesClass 
{

	protected WebDriver driver;
	protected Properties selector;
	
	public AttributesClass(WebDriver driver, Properties selector) 
	{
		this.driver = driver;
		this.selector = selector;
	}
	
	
}
