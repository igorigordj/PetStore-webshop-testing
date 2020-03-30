package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PetStoreMenuTest extends TestTemplateClass {
	

	@Test
	public void urlStatusAndMenuTest() 
	{
		this.driver.navigate().to(this.locators.getProperty("menuPage"));

		// go through left menu
		goThroughCategories("categoriesLeft");

		// go through upper menu
		goThroughCategories("categoriesUpper");

		// go through central menu
		goThroughCategories("categoriesCentral");

	}


	@Test
	public void signInTest() 
	{
		this.driver.navigate().to(this.locators.getProperty("menuPage"));
		
		WebElement signInBtn = this.driver.findElement(By.xpath(selectors.getProperty("signInBtn")));

		signInBtn.click();
		
		WebElement signInMessage = this.driver.findElement(By.xpath(this.selectors.getProperty("signInMessage")));
		
		boolean signInPageOn = true;
		
		try
		{
			signInMessage.isDisplayed();
		}
		catch (Exception e)
		{
			signInPageOn = false;
		}
		
		Assert.assertTrue(signInPageOn);
		
	}

	//help methods
	//going throug categories and test
	public void goThroughCategories(String selector) {
		List<WebElement> categories = driver.findElements(By.xpath(selectors.getProperty(selector)));

		for (int i = 0; i < categories.size(); i++) {
			categories = driver.findElements(By.xpath(selectors.getProperty(selector)));
			WebElement category = categories.get(i);
			String categoryHref = category.getAttribute("href");
			
			System.out.println("Url status: " +
				verifyURLStatus(category.getAttribute("href")));
			
			category.click();
			
			WebElement title = this.driver.findElement(By.xpath(this.selectors.getProperty("pageTitle")));
			
			Assert.assertTrue(categoryHref.contains((title.getText().toUpperCase())));
			
			WebElement returnTo = this.driver.findElement(By.xpath(this.selectors.getProperty("return")));
			returnTo.click();
		}
	}

	//verifying url status of a page
	public static int verifyURLStatus(String urlString) {
		int status = 404;
		try {                         
			URL link = new URL(urlString);
			HttpURLConnection hConn = null;
			hConn = (HttpURLConnection) link.openConnection();
			hConn.setRequestMethod("GET");
			hConn.connect();
			status = hConn.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

}
