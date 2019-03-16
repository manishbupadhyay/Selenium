package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		// set project path
		String projectPath = System.getProperty("user.dir");
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// goto google.com
		driver.get("https://www.google.com/");
		
		GoogleSearchPageObject googleSearchPageObj = new GoogleSearchPageObject(driver);
		
		driver.get("https://google.com");
		
		googleSearchPageObj.setTextInSearchBox("Automation");
		
		googleSearchPageObj.clickSearchButton();
		
		driver.close();
	}

}
