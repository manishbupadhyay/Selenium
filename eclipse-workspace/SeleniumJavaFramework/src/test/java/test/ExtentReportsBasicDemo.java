package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

		private static WebDriver driver = null;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// create Extentreports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google Search Test one","This test is validate to test.");
		
		// set project path
		String projectPath = System.getProperty("user.dir");
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		test1.log(Status.INFO, "Starting test case");
		
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation");
		test1.pass("Entered text in textbox");
		
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).sendKeys(Keys.RETURN);
		test1.pass("pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Closed browser");
		
		test1.info("test completed");
		
		ExtentTest test2 = extent.createTest("Google Search Test Two","This test is validate to test.");
		
		// set project path
		//String projectPath1 = System.getProperty("user.dir");
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		test2.log(Status.INFO, "Starting test case");
		
		driver.get("https://google.com");
		test2.pass("Navigated to google.com");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation");
		test2.pass("Entered text in textbox");
		
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).sendKeys(Keys.RETURN);
		test2.fail("pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		test2.pass("Closed browser");
		
		test1.info("test completed");
		
		extent.flush();
	}

}
