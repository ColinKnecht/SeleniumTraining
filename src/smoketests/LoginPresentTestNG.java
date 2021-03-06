package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	WebDriver driver;
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running Test"); 
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
		
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Email Textbox present");
		Assert.assertTrue(passwordBox, "Password textbox present");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting Test");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing Test");
		driver.close();
	}
}
