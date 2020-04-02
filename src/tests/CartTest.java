package tests;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartPage;
import pages.StoreItemPage;
import utils.ExcelUtils;

public class CartTest extends TestTemplateClass {

	final String dataSource = "tables/pet-store-data.xlsx";
	
	SoftAssert sa = new SoftAssert();
	
	
	@Test
	public void cartTest() throws InterruptedException {
		
		ExcelUtils.setExcell(dataSource);
		ExcelUtils.setWorkSheet(0);

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {

			StoreItemPage sip = new StoreItemPage(driver, selectors, locators, waiter);
			CartPage cp = new CartPage(driver, selectors, locators, waiter);
			
			//gets item ID from table
			String itemId = ExcelUtils.getDataAt(i, 0);
			
			//gets item link from table
			String excelItem = ExcelUtils.getDataAt(i, 1);
			
			//click on item in excel table
			this.driver.navigate().to(excelItem);
			
			sip.addItemToCart();
		
			//checks if item is addad to the cart
			sa.assertTrue(cp.isItemInCart(itemId));
		}
	
		sa.assertAll();
	}

	@Test
	public void clearCookiestest() {

		CartPage cp = new CartPage(driver, selectors, locators, waiter);
			
		cp.openCart();
		this.driver.manage().deleteAllCookies();
		this.driver.navigate().refresh();
		sa.assertTrue(cp.isCartEmpty());
		
	}
	

}
