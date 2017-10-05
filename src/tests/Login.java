package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
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
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();
		
		//get confirmation
		DashboardPage dashboardPage = new DashboardPage(driver);
		String confirm = dashboardPage.printConfirmation();
		System.out.println(confirm);
		Assert.assertTrue(confirm.contains("Success"));
		
		//close the driver
//		driver.quit();
	}


}
