package tests;

import org.testng.annotations.Test;

import pages.CartPage;


public class CartTest extends TestTemplateClass{

	@Test
	public void cartTest() throws InterruptedException {
		
		this.driver.manage().getCookies().clear();
		
		CartPage cp = new CartPage(driver, selectors, locators, waiter);
		
		
		cp.addToCart();

		cp.openCart();
	
		
	}
}
