package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		// call function
		googleSearch();

	}

	public static void googleSearch() {
		// set project path
		String projectPath = System.getProperty("user.dir");
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// goto google.com
		driver.get("https://www.google.com/");
		
		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		// click on search button
		//driver.findElement(By.name("btnK")).click();
		
		// press enter on keyboard
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		// close browser
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
}
