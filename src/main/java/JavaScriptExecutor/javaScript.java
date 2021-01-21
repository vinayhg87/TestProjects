package JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class javaScript {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", ".//Selenium_Test_project/Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
			
		
	}
}
