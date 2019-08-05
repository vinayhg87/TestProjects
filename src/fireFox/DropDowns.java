package fireFox;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/VinayVinay/Desktop/Vinay%20Docs/Eclipse/Selenium_projects/Selenium_Test_project/Selenium_html/DropDown.html");
		WebElement drowdown = driver.findElement(By.name("Cars"));
		Select se = new Select(drowdown);
		se.selectByValue("mercedes");
		se.selectByValue("Bugaati");
		Thread.sleep(3000);
		
		/* Listing all the options in the dropdown */
		/* NOTE: The normal For loop may not work in this flow. only the advanced For loop can be used */
		List<WebElement> dropdownoptions = se.getOptions();
		System.out.println("The size of DropDown is "+dropdownoptions.size());
		for (WebElement options : dropdownoptions )
		{
			String Cars = options.getText();
			if(Cars.equals("maserati"))
			{
				se.selectByValue("maserati");
			}		
		}
		
		
		/* Selecting multiple options */
		driver.get("file:///C:/Users/VinayVinay/Desktop/Vinay%20Docs/Eclipse/Selenium_projects/Selenium_Test_project/Selenium_html/DropDown_multiple.html");
		Thread.sleep(3000);
		WebElement drowdown1 = driver.findElement(By.name("Cars"));
		Select se1 = new Select(drowdown1);
		boolean Ismultiple = se1.isMultiple();
		if(Ismultiple)
		{
			/* inorder to select multiple options, we need to use getOptions() only */
			System.out.println("This dropdown as multiple select option");
			List <WebElement> selectoptions=se1.getOptions();
			
			for(int i=0;i<selectoptions.size();i++)
			{
				WebElement options = selectoptions.get(i);
				String Cars = options.getText();
				System.out.println(Cars);
				se1.selectByIndex(i);
			}
			Thread.sleep(2000);			
			
			/* Print the first selected option */
			WebElement selected = se1.getFirstSelectedOption();
			System.out.println("Selected option from getFirstSelectedOption()");
			System.out.println(selected.getText());
			se1.deselectAll();
		}
		else
		{
			System.out.println("This dropdown doesnot have multiple select option");
		}
		
		
		
		
		
		//driver.close();		
	}
}
