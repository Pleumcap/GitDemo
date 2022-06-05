package Academy;

import java.io.IOException;
import java.util.concurrent.locks.Condition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

//adding log
//generating html reports
//screenshot on failure
//jenkins integration

public class validateNavigationBarTest extends base
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test()
	public void validateAppNavBar() throws IOException
	{
		//one is heritance
		//creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);	
		//compare the text from the browser with actual text-error...
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");
		//Assert.assertFalse(false);
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
