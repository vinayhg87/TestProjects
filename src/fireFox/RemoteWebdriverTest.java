package fireFox;

import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebdriverTest {
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.acceptInsecureCerts();
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new FirefoxDriver(capabilities);
		//FirefoxDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com");
		//driver.get("https://www.google.com");
		Actions act = new Actions(driver);
		//driver.findElement(By.xpath("//input[@title='Search']")).click();
		//searchBox.sendKeys("Search Test");
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();	
	}
}
