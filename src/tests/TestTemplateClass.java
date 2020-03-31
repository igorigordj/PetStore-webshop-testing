package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestTemplateClass 
{

	protected WebDriver driver;
	protected Properties locators;
	protected Properties selectors;
	protected WebDriverWait waiter;


	@BeforeClass
	public void setup() throws FileNotFoundException, IOException 
	{
		System.setProperty("webdriver.edge.driver", "driver-lib\\msedgedriver.exe");
		this.driver = new EdgeDriver();
		this.locators =  new Properties();
		locators.load(new FileInputStream("config/global.properties"));
		this.selectors = new Properties();
		selectors.load(new FileInputStream("config/selectors.properties"));
		
		driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}
	
	@AfterClass
	public void afterClass() 
	{
		this.driver.close();
	}

}
