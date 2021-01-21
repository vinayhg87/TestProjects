package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;


public class TestNGExample {
	
	@Test
	public void GmailLogin() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='identifierId']")).sendKeys("vinayhg@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test1111");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		
		//Assert.fail(message); this is hard assert
		SoftAssert sa = new SoftAssert();
		sa.assertAll();
		
		
	}
	
	@Test
	public void test3()
	{
		System.out.println("test3 phrase");
		Reporter.log("Test3 from Reporter",true);
	}	
}
