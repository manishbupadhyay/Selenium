package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGListenerDemo2 {
	
	@Test
	public void test1(){
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2(){
		System.out.println("I am inside Test 2");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com"); 
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium Automation");
		driver.findElement(By.xpath("//input[@name='abcd']")).sendKeys("Selenium Automation");
		
		driver.close();
		
	}
	
	@Test
	public void test3(){
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skippped");
	}

}
