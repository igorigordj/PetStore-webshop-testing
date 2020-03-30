package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends AttributesClass
{

	public SignInPage(WebDriver driver, Properties selector) {
		super(driver, selector);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getUserName()
	{
		return this.driver.findElement(By.xpath(this.selector.getProperty("userName")));
	}
	
	public WebElement getPassword()
	{
		return this.driver.findElement(By.xpath(this.selector.getProperty("password")));
	}
	
	public WebElement getLoginBtn()
	{
		return this.driver.findElement(By.xpath(this.selector.getProperty("loginBtn")));
	}
	
	public void signIn(String userName, String password)
	{
		this.getUserName().sendKeys(userName);
		this.getPassword().sendKeys(password);
		
		this.getLoginBtn().click();
	}

}
