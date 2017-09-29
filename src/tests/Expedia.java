package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "chrome";
	@Test
	public void hotelReservation(){
		//1. Search
		
		//2.Modify Search results page
		
		//3. analyze the results and make our selection
		
		///4. book reservation
		
		//5. fill out contact + billing
		
		//6. get confirmation
	}
	
	@BeforeMethod
	public void setup(){
		driver = utilities.DriverFactory.open(browserType);
		driver.get("https://www.expedia.com/");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}//class
