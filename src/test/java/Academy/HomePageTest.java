package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePageTest extends base
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializeDriver();
	driver.manage().window().maximize();
	

	}
	
	@Test(dataProvider ="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		
		//one is heritance
		//creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);	
		//l.closepopup().click();
		l.getLogin().click(); //driver.findElement(By.css()
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys("Password");
		//System.out.println(text);
		log.info(text);
//		lp.getLogin().click();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//row stand for how many different data type test should run
		//column stand for how many value per each test
		
		//array size is 2
		//0,1
		Object[][] data =new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]="Non restricted User";
	
		return data;
	}
}
