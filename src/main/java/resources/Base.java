package resources;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties p;
	
	public WebDriver initialization() throws FileNotFoundException,IOException
	{
		p= new Properties();
		FileInputStream f= new FileInputStream("C:\\Users\\user\\PWC\\PWC\\src\\main\\java\\resources\\data.properties");
		p.load(f);
		String browserName= p.getProperty("Brower");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.geko.driver", "C:\\Work\\gekodriver.exe");
			driver= new FirefoxDriver();
		}
		return driver;
	}
	public String Screenshots(String testcasename, WebDriver driver) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Location= System.getProperty("user.dir")+"\\reports\\" + testcasename +".png";
		FileUtils.copyFile(src, new File(Location));
		return Location;
	}

	
}

