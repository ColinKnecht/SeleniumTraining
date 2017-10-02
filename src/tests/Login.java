package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login { //Using page object model
	
	@Test
	public void loginTestPOM(){
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//initialize Driver
		
		//enter login info
		
		//get confirmation
		
		//close the driver
		driver.quit();
	}


}
