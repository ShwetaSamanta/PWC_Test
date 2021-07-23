package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productPageLocator {
	public WebDriver driver;
	//By allmobiles= By.xpath("//div[@class='_4rR01T']");
	//By allmobiles= By.className("_4rR01T");
	By allmobiles= By.cssSelector("._4rR01T");
	
	
	By Cart= By.cssSelector("._2KpZ6l._2U9uOA._3v1-ww");
	public productPageLocator(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public List<WebElement> allmobiles()
	{
		return driver.findElements(allmobiles);
	}
	public WebElement CartButton()
	{
		return driver.findElement(Cart);
	}
	
}
