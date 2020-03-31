package pages;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utils.ExcelUtils;

public class SignInPage extends AttributesClass
{
	

	private final String dataSource = "tables/pet-store-data.xlsx";

	public SignInPage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
	
	}
	
	
	public WebElement getUserName()
	{
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword()
	{
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginBtn()
	{
		return this.driver.findElement(By.xpath(this.selectors.getProperty("loginBtn")));
	}
	
	public WebElement getWelcomeMessage()
	{
		return this.driver.findElement(By.xpath(this.selectors.getProperty("welcome")));
	}
	
	//sign in with valid userName and password
	public void signIn()
	{
		ExcelUtils.setExcell(dataSource);
		ExcelUtils.setWorkSheet(1);
		
		SoftAssert sa = new SoftAssert();

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) { 

			this.driver.navigate().to(this.locators.getProperty("signInPage"));

			String userName = ExcelUtils.getDataAt(i, 2) + i*3;
		
			String password = ExcelUtils.getDataAt(i, 1);
		
		this.getUserName().sendKeys(userName);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		
		this.getLoginBtn().click();
		
		sa.assertTrue(validateSignIn());
		}
		
		sa.assertAll();
		
	}
	
	//sign in without userName or password
	public void invalidSignIn() {
		this.getUserName().clear();
		this.getPassword().clear();
		
		this.getLoginBtn().click();
		
		Assert.assertTrue(validateSignIn());
	}
	
	public boolean validateSignIn() {
		boolean isUserSignedIn = true;
		try {
			this.getWelcomeMessage().isDisplayed();
		}
		catch (Exception e) {
			System.out.println("User not saved");
			isUserSignedIn = false;
		}
		return isUserSignedIn;
	}

}
