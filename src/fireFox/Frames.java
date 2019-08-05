package fireFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames {
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", ".//Selenium_Test_project/Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();//upcasting
		driver.switchTo().frame("String");
		driver.switchTo().frame("Webelement");
		driver.switchTo().frame("int");
		driver.switchTo().defaultContent();		
	}

}
