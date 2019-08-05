package fireFox;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Download {
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.seleniumhq.org/download/");
		//driver.get("https://www.seleniumhq.org/download/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			WebElement li = links.get(i);
			String link = li.getText();
			//System.out.println(link);
			if(link.equals("Download"))
			{
				System.out.println(link);
			}
		}
		
		driver.quit();
	}
}
