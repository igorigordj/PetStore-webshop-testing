package tests;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;
import utils.ExcelUtils;

public class RegistrationTest extends TestTemplateClass {

	final String dataSource = "tables/pet-store-data.xlsx";
	SoftAssert sa = new SoftAssert();

	@Test
	// Regular registration test (Expected: successful registration)
	public void registrationTest() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));

		this.driver.manage().deleteAllCookies();

		RegistrationPage rp = new RegistrationPage(driver, selectors, locators, waiter);

		ExcelUtils.setExcell(dataSource);
		ExcelUtils.setWorkSheet(1);

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {

			driver.navigate().to(this.locators.getProperty("registrationPage"));

			String userId = ExcelUtils.getDataAt(i, 2) + i * 3;
			rp.setUserId(userId);
			ExcelUtils.setDataAt(i, 0, userId);

			String password = ExcelUtils.getDataAt(i, 1);
			rp.setPassword(password);

			rp.setPasswordRp(ExcelUtils.getDataAt(i, 1));
			rp.setFirstName(ExcelUtils.getDataAt(i, 2));
			rp.setLastName(ExcelUtils.getDataAt(i, 3));
			rp.setEmail(ExcelUtils.getDataAt(i, 4));
			rp.setPhone(ExcelUtils.getDataAt(i, 5));
			rp.setAddress(ExcelUtils.getDataAt(i, 6));
			rp.setAddress2(ExcelUtils.getDataAt(i, 7));
			rp.setCity(ExcelUtils.getDataAt(i, 8));
			rp.setState(ExcelUtils.getDataAt(i, 9));
			rp.setZip(ExcelUtils.getNumData(i, 10));
			rp.setCountry(ExcelUtils.getDataAt(i, 11));
			rp.selectLanguage(ExcelUtils.getDataAt(i, 11));
			rp.selectCategory();
			rp.setEnableList();
			rp.setEnableBaner();

			rp.setSaveAccount();

			sa.assertTrue(rp.validateRegistration());

		}

		sa.assertAll();
	}

	@Test
	// Registration test without User name(Expected: registration fail)
	public void registrationTestWithoutUserName() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));

		this.driver.manage().deleteAllCookies();

		RegistrationPage rp = new RegistrationPage(driver, selectors, locators, waiter);
		ExcelUtils.setExcell(dataSource);
		ExcelUtils.setWorkSheet(1);

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {

			driver.navigate().to(this.locators.getProperty("registrationPage"));

			rp.getUserId().clear();

			String password = ExcelUtils.getDataAt(i, 1);
			rp.setPassword(password);

			rp.setPasswordRp(ExcelUtils.getDataAt(i, 1));
			rp.setFirstName(ExcelUtils.getDataAt(i, 2));
			rp.setLastName(ExcelUtils.getDataAt(i, 3));
			rp.setEmail(ExcelUtils.getDataAt(i, 4));
			rp.setPhone(ExcelUtils.getDataAt(i, 5));
			rp.setAddress(ExcelUtils.getDataAt(i, 6));
			rp.setAddress2(ExcelUtils.getDataAt(i, 7));
			rp.setCity(ExcelUtils.getDataAt(i, 8));
			rp.setState(ExcelUtils.getDataAt(i, 9));
			rp.setZip(ExcelUtils.getNumData(i, 10));
			rp.setCountry(ExcelUtils.getDataAt(i, 11));
			rp.selectLanguage(ExcelUtils.getDataAt(i, 11));
			rp.selectCategory();
			rp.setEnableList();
			rp.setEnableBaner();

			rp.setSaveAccount();

			sa.assertTrue(rp.validateRegistration());
		}

		sa.assertAll();
	}

	@Test
	// Registration test only with User name and password, without aditional
	// data(Expected: registration fail)
	public void registrationTestWithOnlyUserNameAndPassword() throws IOException, InterruptedException {
		this.driver.navigate().to(this.locators.getProperty("registrationPage"));

		this.driver.manage().deleteAllCookies();

		RegistrationPage rp = new RegistrationPage(driver, selectors, locators, waiter);
		ExcelUtils.setExcell(dataSource);
		ExcelUtils.setWorkSheet(1);

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {

			driver.navigate().to(this.locators.getProperty("registrationPage"));

			String userId = ExcelUtils.getDataAt(i, 2) + i * 2;
			rp.setUserId(userId);
			ExcelUtils.setDataAt(i, 0, userId);

			String password = ExcelUtils.getDataAt(i, 1);
			rp.setPassword(password);

			rp.setPasswordRp(ExcelUtils.getDataAt(i, 1));

			rp.getFirstName().clear();
			rp.getLastName().clear();
			rp.getEmail().clear();
			rp.getPhone().clear();
			rp.getAddress().clear();
			rp.getAddress2().clear();
			rp.getCity().clear();
			rp.getState().clear();
			rp.getZip().clear();
			rp.getCountry().clear();

			rp.setSaveAccount();

			sa.assertTrue(rp.validateRegistration());
		}

		sa.assertAll();
	}

}
