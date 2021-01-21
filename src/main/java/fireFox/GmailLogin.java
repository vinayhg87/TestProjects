package fireFox;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailLogin implements Commons{
	
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.gecko.driver", currentDir+"/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		GmailLogin gl = new GmailLogin();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='identifierId']")).sendKeys("vinayhg@gmail.com");
		Thread.sleep(2000);
		gl.takeScreenshot(driver, "scr1");
		driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test1111");
		Thread.sleep(2000);
		gl.takeScreenshot(driver, "scr2");
		driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		/*
		WebDriverWait wait =  new WebDriverWait(driver, 9);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
		*/
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText();
		alert.sendKeys("");
		
		
		driver.close();
		
	}
	
	public void takeScreenshot( WebDriver driver, String filename) throws IOException
	{
		/*File scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshot, new File(".//Screenshots//"+filename+".jpg"));	*/
		
		//OR
		
		 TakesScreenshot scr = (TakesScreenshot)driver; //upcasting
		 File Scrshot = scr.getScreenshotAs(OutputType.FILE);
		 File Descloc = new File(".//Screenshots//"+filename+".jpg");
		 FileUtils.copyFile(Scrshot, Descloc);
		
	}

}
