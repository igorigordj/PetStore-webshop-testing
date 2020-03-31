package tests;


import org.testng.annotations.Test;

import pages.SignInPage;


public class SignInTest extends TestTemplateClass 
{


	
	@Test
	//sign in with valid userName and password
	public void signInTest() 
	{
		this.driver.navigate().to(this.locators.getProperty("signInPage"));
	
	
		SignInPage sip = new SignInPage(driver, selectors, locators, waiter);
		
		sip.signIn();
	}
	
	@Test
	//sign in without userName or password
		public void invalidSignInTest() 
	{
		this.driver.navigate().to(this.locators.getProperty("signInPage"));
		
		SignInPage sip = new SignInPage(driver, selectors, locators, waiter);
		
		sip.invalidSignIn();
	}

}
