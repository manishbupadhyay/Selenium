package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// call function
		googleSearch();

	}

	public static void googleSearch() {
		// set project path
		String projectPath = System.getProperty("user.dir");
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// goto google.com
		driver.get("https://www.google.com/");
		
		// enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Selenium");
		
		// find element from GoogleSearchTest class
		GoogleSearchPage.textbox_search(driver).sendKeys("Selenium automation");
		
		// click on search button
		//driver.findElement(By.name("btnK")).click();
		
		// press enter on keyboard
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		// find button from GoogleSearchTest class
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		// close browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}
}
