package tests;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "chrome";
	String website = "https://www.expedia.com/";
	String city = "New York, NY";
	String checkIn = "10/10/2017";
	String checkOut = "10/17/2017";
	String numOfGuests = "2";
	String starRating = "star4";
	String searchResult = "1";
	@Test
	public void hotelReservation(){
		//1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		new Select(driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[4]/div[4]/label/select"))).selectByValue(numOfGuests);
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[9]/label/button")).click();
		
		String actualCity = driver.findElement(By.xpath("//*[@id='hotelResultTitle']/h1")).getText();
		System.out.println("CITY = " + actualCity);
		
		//2.Modify Search results page
		
		driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();
		
		//3. analyze the results and make our selection
//		driver.findElement(By.xpath("//*[@id='17117062']/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\'resultsContainer\']/section/article[" + searchResult +"]/div[2]/div/a")).click();
		
		//switch the window to the popup
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		//print hotel name and star rating
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		System.out.println("Hotel Name = " + hotelName);
		
		///4. book reservation
		driver.findElement(By.xpath("//*[@id='rooms-and-rates']/div/article/table/tbody/tr/td[5]/form/div[1]/button")).click();
		
		String price = driver.findElement(By.cssSelector("span[class='amount-value summary-total '")).getText();
		System.out.println("PRICE DUE = " + price);
		
		
		//5. fill out contact + billing
		
		//6. get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	
	@BeforeMethod
	public void setup(){
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().window().maximize();
		driver.get(website);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
//		driver.quit();
	}
}//class
