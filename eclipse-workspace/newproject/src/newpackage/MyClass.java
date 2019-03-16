package newpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.PropertiesFile;

public class MyClass {
	public static String browser;
	static WebDriver driver;
	
	public static void main(String[] args) {
		//setBrowser();
		PropertiesFile.readPropertiesFile();
		setBrowserConfig();
		runTest();
		PropertiesFile.writePropertiesFile();
		
	}

	//setBrowser
	//setBrowserConfig
	//runTest

	public static void setBrowser() {
		browser = "Chrome";	
	}

	public static void setBrowserConfig() {
		if(browser.contains("Firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		if(browser.contains("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	}

	public static void runTest() {
		driver.get("https://www.seleniumhq.org/");
		driver.quit();
	}

} 
