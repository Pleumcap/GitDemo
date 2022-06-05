package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By closepopup = By.xpath("//body/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[7]/div[1]/div[1]/div[2]");
	private By title=By.cssSelector(".text-center>h2");
	private By navBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header = By.cssSelector("div[class*=\"video-banner\"] h3");
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getNavigationBar()
	{
		System.out.println("Try to indentify navigation bar");
		return driver.findElement(navBar);
	}
	
	public WebElement closepopup()
	{
		return driver.findElement(closepopup);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
}
