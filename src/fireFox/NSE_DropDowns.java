package fireFox;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NSE_DropDowns {
	
	public static void main(String[] args) throws InterruptedException 
	{	
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.acceptInsecureCerts();
		@SuppressWarnings("deprecation")
		WebDriver driver = new FirefoxDriver(Capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.nseindia.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("QuoteSearch")).click();
		WebElement QuoteSearch = driver.findElement(By.id("QuoteSearch"));
		
		/* DropDown */
		Select search =  new Select(QuoteSearch);
		List<WebElement> optionsList = search.getOptions();	
		for(WebElement options : optionsList)
		{
			if(options.getText().equals("Equity Derivatives"))
			{
				search.selectByVisibleText("Equity Derivatives");
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='fokeyword']")).sendKeys("SBIN");
		Thread.sleep(2000);
		
		/* Action class to press Enter key */
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();;
		Thread.sleep(2000);		
		
		/* Fetch Stock Data */
		String LastPrice = driver.findElement(By.id("lastPrice")).getText();
		System.out.println("The last Price is "+LastPrice);	
		String OpenPrice = driver.findElement(By.id("open")).getText();
		System.out.println("The Open Price is "+OpenPrice);	
		String HighPrice = driver.findElement(By.id("dayHigh")).getText();
		System.out.println("The High Price is "+HighPrice);	
		String DayLow = driver.findElement(By.id("dayLow")).getText();
		System.out.println("The Low Price is "+DayLow);	
		
		driver.close();
		
	}
}
