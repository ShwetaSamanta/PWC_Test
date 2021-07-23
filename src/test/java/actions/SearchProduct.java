package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.FlipKartLocator;
import pageObject.productPageLocator;
import resources.Base;

public class SearchProduct extends Base{
	
	public	WebDriver driver;
	String name="";
	
	
	@BeforeTest
	public void openURL() throws FileNotFoundException, IOException, InterruptedException
	{
		
		driver=initialization();
		String URL= p.getProperty("URL");
		driver.get(URL);
		driver.manage().window().maximize();
	//	Thread.sleep(1000);
		driver.findElement(By.cssSelector("._2KpZ6l._2doB4z")).click();
		
	}
	
	@Test
	public void mobileSearch() throws FileNotFoundException, IOException, InterruptedException
	{
		String product=p.getProperty("Product");
		System.out.println("product name:" +product);
		
		FlipKartLocator Flobj= new FlipKartLocator(driver);
		Actions action =new Actions(driver);
		action.moveToElement(Flobj.searchproduct()).click().sendKeys(product).build().perform();;
		Thread.sleep(1000);
		Flobj.searchproduct().sendKeys(product);
		Flobj.Submit().click();
		Thread.sleep(1000);
		
	
	}
	@Test
	public void addding_to_cart() throws InterruptedException 
	{
		productPageLocator pobj= new productPageLocator(driver);
		Thread.sleep(1000);
		List<WebElement> mobiles=pobj.allmobiles();
		for (WebElement mobilee:mobiles)
			{
				if (mobilee.getText().contains("realme"))
					{
						Thread.sleep(1000);
						name=mobilee.getText();
						mobilee.click();
						System.out.println("clicked on selected Iteam" + name);
						break;
					}
				else
				{
					System.out.println("not found");
				}
			}
		
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Set<String> winIDS= driver.getWindowHandles();
		Iterator<String> It= winIDS.iterator();
		
		String ParentId= It.next();
		String ChildID=It.next();
		driver.switchTo().window(ChildID);
		
		if(pobj.CartButton().isEnabled())
		{
		pobj.CartButton().click();
		}
		
		
	}
	
	
	
	@Test
	public void validateCart() throws InterruptedException 
	
		{
		Set<String> winIDS= driver.getWindowHandles();
		Iterator<String> It= winIDS.iterator();
		
		String ParentId= It.next();
		String ChildID=It.next();
		driver.switchTo().window(ParentId);
		driver.findElement(By.cssSelector("._3SkBxJ")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("._2Kn22P.gBNbID")).getText());
	
		WebDriverWait w= new WebDriverWait(driver,6);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("._2Kn22P.gBNbID")));
//		Assert.assertTrue(driver.findElement(By.cssSelector("._2Kn22P.gBNbID")).getText().contains("realme")); 
		
		}
	
	
	@AfterTest
	
	public void closeBrowser() {
	driver.close();
	}
	
}
