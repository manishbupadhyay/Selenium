import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath+ "/drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.edge.driver", projectPath+ "/drivers/edgedriver/MicrosoftWebDriver.exe");
		//WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com"); 
		//WebElement textbox = driver.findElement(By.className("gLFyf"));
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium Automation");;
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int inputCount = listOfInputElements.size();
		System.out.println("input text box count is " + inputCount);
		//Thread.sleep(3000);
	
		//driver.close();
		//driver.quit();
	}
}
