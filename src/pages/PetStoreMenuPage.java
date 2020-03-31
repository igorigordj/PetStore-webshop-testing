package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PetStoreMenuPage extends AttributesClass
{
	private List<WebElement> categories;
	
	public PetStoreMenuPage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
		
		this.categories = new ArrayList<WebElement>();
	}

	

	
	
	public List<WebElement> getCategoriesLeft()
	{
		return this.driver.findElements(By.xpath(this.selectors.getProperty("categoriesLeft")));
	}
	
	public List<WebElement> getCategoriesUpper()
	{
		return this.driver.findElements(By.xpath(this.selectors.getProperty("categoriesUpper")));
	}
	
	public List<WebElement> getCategoriesCentral()
	{
		return this.driver.findElements(By.xpath(this.selectors.getProperty("categoriesCentral")));
	}
	
	public void getLeftMenuCategories()
	{
		for (int i = 0; i < this.getCategoriesLeft().size(); i++) 
		{
			WebElement categorie = this.getCategoriesLeft().get(i);

		}
	}
	
	public void getUpperMenuCategories()
	{
		for (int i = 0; i < this.getCategoriesUpper().size(); i++) 
		{
			WebElement categorie = this.getCategoriesUpper().get(i);

		}
	}
	
	public void getCentralMenuCategories()
	{
		for (int i = 0; i < this.getCategoriesLeft().size(); i++) 
		{
			WebElement categorie = this.getCategoriesLeft().get(i);

		}
	}
	
	
}
