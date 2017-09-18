package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login
{

	public static void main(String[] args)
	{
		// 1. Open the web browser
		System.setProperty("webdriver.chrome.driver", "/Users/colinknecht/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		// 2.Navigate to the web application
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//Find Elements
			//Locate the element, determine the action, pass any parameters
		
		// 3. Enter Email Address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		
		// 4. Enter Password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		
		// 5. Click Login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		// 6. Get Confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
//		if (pageTitle == "SDET Training | Account Management"){
//			System.out.println("Page Title Test Passed");
//		} else {
//			System.out.println("Page Title Test FAILED");
//		}
		// 7. Close Browser
//		driver.close();//closes the browser
//		driver.quit();//quits entire session

	}

}
