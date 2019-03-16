package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver = null;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		// create Extentreports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		// set project path
		String projectPath = System.getProperty("user.dir");
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() {
		ExtentTest test = extent.createTest("Google Search Test one","This test is validate to test.");
		test.log(Status.INFO, "Starting test case");
		test.info("this step shows usage of info details");
		driver.get("https://www.google.com");
		test.pass("Navigate to google.com website");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation step by step");
		test.pass("Entered text in textbox");
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).sendKeys(Keys.RETURN);
		test.pass("Pressed keyboard enter key");
		try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		test.pass("browser closed");
		driver.quit();
		test.info("test complated");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
