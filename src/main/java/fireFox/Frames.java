package fireFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames implements Commons {
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", currentDir+"/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();//upcasting
		driver.switchTo().frame("String");
		driver.switchTo().frame("Webelement");
		driver.switchTo().frame("int");
		driver.switchTo().defaultContent();		
	}

}
