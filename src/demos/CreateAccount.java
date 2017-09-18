package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount
{

	public static void main(String[] args)
	{
	// 1. Create WebDriver
		System.setProperty("webdriver.gecko.driver", "/Users/colinknecht/Desktop/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
	//2. Naviaget to account management page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		driver.findElement(By.linkText("Create Account")).click();
		
	//3. fill out form
		//how to locate elements
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Tommy Thompson");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("tt@testemail.com");
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("123-456-1987");
		
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("ttpass");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("ttpass");
		
		//how to interact with other html elements
		driver.findElement(By.id("MainContent_Female")).click();
//		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
		
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("United States");
		
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
	//4. get confirmation
		String confirm = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("Confirmation message = " +  confirm);
		
	//5. close browser
		driver.close();

	}

}
