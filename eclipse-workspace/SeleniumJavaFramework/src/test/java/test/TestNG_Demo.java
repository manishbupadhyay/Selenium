package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo { 
	
	 WebDriver driver= null;
	// when we use TestNG no need to add main method
	 public static String browserName = null;
	
	@BeforeTest
	public void setUpTest() {
		// set project path
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			// set chrome driver
			System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+ "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
			
		
		
	}
	
	@Test
	public void googleSearch() {
		
		// goto google.com
		driver.get("https://www.google.com/");
		
		// enter text in search textbox
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation step by step");
		
		// click on search button
		//driver.findElement(By.name("btnK")).click();
		
		// press enter on keyboard
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).sendKeys(Keys.RETURN);
		
	}
	// close the test
	@AfterTest
	public void tearDownTest() {
		// close browser
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
}
