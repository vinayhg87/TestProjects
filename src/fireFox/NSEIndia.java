package fireFox;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NSEIndia {
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.nseindia.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='keyword']")).sendKeys("SBIN");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li[class='last']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/products.htm']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/global/content/about_us/about_us.htm']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/global/content/investor_rel/corporate_structure.htm']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.close();
	}
	
	
	public void takeScreenshot(WebDriver driver, String imageName) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(".//Screenshots//"+imageName+".jpg"));
	}
}
