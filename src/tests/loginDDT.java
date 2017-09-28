package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginDDT {
	WebDriver driver;
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password){
//		System.out.println(name + " " + email + " " + password);
		
//		System.setProperty("webdriver.chrome.driver", "/Users/colinknecht/Desktop/Selenium/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		// 2.Navigate to the web application
//		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//Find Elements
			//Locate the element, determine the action, pass any parameters
		
		// 3. Enter Email Address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		
		// 4. Enter Password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		
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
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		// 2.Navigate to the web application
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData(){
		String filename = "/Users/colinknecht/Desktop/Selenium/XcelTest.xls";
		return utilities.Excel.get(filename);
	}
}
