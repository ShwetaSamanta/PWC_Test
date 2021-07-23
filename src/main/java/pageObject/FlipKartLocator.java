package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class FlipKartLocator{
	public WebDriver driver;
	
	By searchproduct= By.xpath("//input[@name='q']");
	By Submit= By.xpath("//button[@type='submit']");
	
	By pageTitle= By.xpath("//div[@class='_3g_HeN']");
	By CartPageproduct= By.xpath("//a[@class='_2Kn22P gBNbID']");

	
	public FlipKartLocator(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement searchproduct()
	{
		return driver.findElement(searchproduct);
	}
	public WebElement Submit()
	{
		return driver.findElement(Submit);
	}
	
	
	public WebElement pageTitle()
	{
		return driver.findElement(pageTitle);
	}
	
	
	public WebElement CartPageproduct()
	{
		return driver.findElement(CartPageproduct);
	}
	
	
}
