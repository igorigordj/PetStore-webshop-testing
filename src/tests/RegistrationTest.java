package tests;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;

public class RegistrationTest extends TestTemplateClass {

	SoftAssert sa = new SoftAssert();
	
	@Test
	// Regular registration test (Expected: successful registration)
	public void registrationTest() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));
		
		this.driver.manage().getCookies().clear();

		RegistrationPage rp = new RegistrationPage (driver, selectors, locators, waiter);
		rp.completeRegistrationForm();

		sa.assertTrue(rp.validateRegistration());
		sa.assertAll();
	}

	@Test
	//Registration test without User name(Expected: registration fail)
	public void registrationTestWithoutUserName() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));
		
		this.driver.manage().getCookies().clear();

		
		SoftAssert sa = new SoftAssert();

		RegistrationPage rp = new RegistrationPage (driver, selectors, locators, waiter);
		rp.completeRegistrationFormWithoutUserName();

		sa.assertTrue(rp.validateRegistration());
		sa.assertAll();
	}
	
	@Test
	// Registration test only with User name and password, without aditional data(Expected: registration fail)
	public void registrationTestWithOnlyUserNameAndPassword() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));
		
		this.driver.manage().getCookies().clear();

		
		SoftAssert sa = new SoftAssert();

		RegistrationPage rp = new RegistrationPage (driver, selectors, locators, waiter);
		rp.completeRegistrationFormWithoutData();

		sa.assertTrue(rp.validateRegistration());
		sa.assertAll();
	}
	
	
}
