import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		
		//DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setCapability("ignoreProtectedModeSetting", true);
		
		System.setProperty("webdriver.ie.driver", projectPath+ "/drivers/IEDriverServer_x64_3.14.0/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Manish");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
	}

}
