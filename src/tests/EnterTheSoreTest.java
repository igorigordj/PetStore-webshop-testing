package tests;


import org.testng.annotations.Test;

import pages.HomePage;



public class EnterTheSoreTest extends TestTemplateClass
{
	
	
	
	@Test
	public void enterTheStoreTest()
	{
		this.driver.navigate().to(this.locators.getProperty("url"));
		
		HomePage homePage = new HomePage(driver, selectors);
		homePage.enterTheStore();
	}
	
	
	
}
