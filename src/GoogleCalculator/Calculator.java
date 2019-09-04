package GoogleCalculator;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calculator {
	
	public static void main(String[] args) throws InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		
		ExcelData excel = new ExcelData();
		long num1 = excel.ReadExcelData("Sheet1", 1, 0);
		long num2 = excel.ReadExcelData("Sheet1", 1, 1);;
		String Sign = "+";
		Robot robot =  new Robot();
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("google calculator");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][contains(text(),'"+num1+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='XRsWPe MEdqYd'][contains(text(),'"+Sign+"')]")).click();
		driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][contains(text(),'"+num2+"')]")).click();
		//driver.findElement(By.xpath("//div[@class='XRsWPe UUhRt'][contains(text(),'"+equals+"')]")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		String res = driver.findElement(By.xpath("//div[@class='z7BZJb XSNERd']")).getText();
		System.out.println(res);
		excel.WirteExcelData("Sheet1", 1, 3, res);
		
	}

}
