package fireFox;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesExample implements Commons{
	
	public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.gecko.driver", currentDir+"/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.get("http://demo.guru99.com/popup.php ");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		String MainWindow = driver.getWindowHandle();
		System.out.println(MainWindow);
		Set<String> multiWindows = driver.getWindowHandles();
		Iterator<String> itr = multiWindows.iterator();
		while(itr.hasNext())
		{
			String childWindow = itr.next();
			System.out.println(childWindow);
			if(!MainWindow.equalsIgnoreCase(childWindow))
			{	
				System.out.println("in child ");
				driver.switchTo().window(childWindow);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.name("emailid"))));
				driver.findElement(By.name("emailid")).sendKeys("jai@jai.com");
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
		driver.close();
	}
}