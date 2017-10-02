package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class Login { //Using page object model
	
	@Test
	public void loginTestPOM(){
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.manage().window().maximize();
		//initialize Driver
		LoginPage loginPage = new LoginPage(driver);
		//enter login info
		loginPage.setUserName("Johnny");
		//get confirmation
		
		//close the driver
//		driver.quit();
	}


}
