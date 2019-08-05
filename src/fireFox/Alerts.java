package fireFox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.MILLISECONDS);
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		Thread.sleep(5);
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		alert.dismiss();
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		System.out.println(alert.getText());
		WebDriverWait wait = new WebDriverWait(driver, 9);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).click();
		
	}

}
