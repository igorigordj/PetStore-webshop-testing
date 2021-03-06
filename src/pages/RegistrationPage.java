package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage extends AttributesClass{

	
	public RegistrationPage(WebDriver driver, Properties selectors, Properties locators, WebDriverWait waiter) {
		super(driver, selectors, locators, waiter);
		
	}


	//userId
	public WebElement getUserId() {
		return this.driver.findElement(By.name("username"));
	}

	public void setUserId(String ID) {
		this.getUserId().clear();
		this.getUserId().sendKeys(ID);
	}

	//password
	public WebElement getPassword() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("password")));
	}

	public void setPassword(String password) {
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
	}

	//password repeat
	public WebElement getPasswordRp() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("passwordRp")));
	}

	public void setPasswordRp(String password) {
		this.getPasswordRp().clear();
		this.getPasswordRp().sendKeys(password);
	}

	//firstName
	public WebElement getFirstName() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("firstName")));
	}

	public void setFirstName(String firstName) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
	}

	//lastName
	public WebElement getLastName() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("lastName")));
	}

	public void setLastName(String lastName) {
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
	}

	//email
	public WebElement getEmail() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("email")));
	}

	public void setEmail(String email) {
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
	}

	//phone
	public WebElement getPhone() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("phone")));
	}

	public void setPhone(String phone) {
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
	}

	//address
	public WebElement getAddress() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("address")));
	}

	public void setAddress(String address) {
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
	}

	//address2
	public WebElement getAddress2() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("address2")));
	}

	public void setAddress2(String address2) {
		this.getAddress2().clear();
		this.getAddress2().sendKeys(address2);
	}

	//city
	public WebElement getCity() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("city")));
	}

	public void setCity(String city) {
		this.getCity().clear();
		this.getCity().sendKeys(city);
	}

	//state
	public WebElement getState() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("state")));
	}

	public void setState(String state) {
		this.getState().clear();
		this.getState().sendKeys(state);
	}

	//zip
	public WebElement getZip() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("zip")));
	}

	public void setZip(int zip) {
		WebElement zipCode = this.getZip();
		zipCode.clear();
		String zipString = "";
		zipString += zip;
		zipCode.sendKeys(zipString);
	}

	//country
	public WebElement getCountry() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("country")));
	}

	public void setCountry(String country) {
		this.getCountry().clear();
		this.getCountry().sendKeys(country);
	}

	//language
	public WebElement getLanguage() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("language")));
	}

	public void selectLanguage(String country) {
		if (this.getCountry().getText().equals("Japan")) {
			this.getLanguage().sendKeys(Keys.ARROW_DOWN);
			this.getLanguage().click();
		}

	}

	//favouriteCategory
	public List<WebElement> getFavouriteCategory() {
		return this.driver.findElements(By.xpath(this.selectors.getProperty("favouriteCategory")));
	}

	public void selectCategory() {
		List<WebElement> favouriteCategory = this.getFavouriteCategory();
		chooseRandomCategory();
		for (int i = 0; i < favouriteCategory.size(); i++) {
			if (chooseRandomCategory().equals(favouriteCategory.get(i).getText())) {
				WebElement category = favouriteCategory.get(i);
				category.click();
			}
		}
	}

	//enableList
	public WebElement getEnableList() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("enableList")));
	}

	public void setEnableList() {
		if (!this.getEnableList().isSelected()) {
			this.getEnableList().click();
		}
	}

	//enableBaner
	public WebElement getEnableBaner() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("enableBaner")));
	}

	public void setEnableBaner() {
		if (!this.getEnableBaner().isSelected()) {
			this.getEnableBaner().click();
		}
	}

	//saveAccount
	public WebElement getSaveAccount() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("saveAccount")));
	}

	public void setSaveAccount() {
		this.getSaveAccount().click();
	}
	
	//main image
	public WebElement getMainImg() {
		return this.driver.findElement(By.xpath(this.selectors.getProperty("mainImg")));
	}

		
		//validate registration
		public boolean validateRegistration() {
			boolean isUserSaved = true;
			try {
				this.getMainImg().isDisplayed();
			}
			catch (Exception e) {
				System.out.println("User not saved");
				isUserSaved = false;
			}
			return isUserSaved;
		}

	// choose random category
	public String chooseRandomCategory() {
		String category;
		double num = Math.random() * 5;
		int numer = (int) num;
		switch (numer) {
		case 1:
			category = "DOGS";
			break;
		case 2:
			category = "REPTILES";
			break;
		case 3:
			category = "CATS";
			break;
		case 4:
			category = "BIRDS";
			break;
		default:
			category = "FISH";
		}
		return category;
	}

}
