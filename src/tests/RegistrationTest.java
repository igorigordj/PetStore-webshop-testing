package tests;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;

public class RegistrationTest extends TestTemplateClass {

	@Test
	public void registrationTest() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));
		
		this.driver.manage().getCookies().clear();

		
		SoftAssert sa = new SoftAssert();

		RegistrationPage rp = new RegistrationPage (driver, selectors, locators, waiter);
		rp.completeRegistrationForm();

		sa.assertAll();
	}

}
