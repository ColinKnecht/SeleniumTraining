package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name,email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameElement, emailElement, phoneElement, passwordElement, confirmPasswordElement, countryElement, maleRadio,
	femaleRadio, weeklyCheckbox, monthlyCheckbox, occasionalCheckbox, submitButton;
	

	WebDriver driver;

	//This is out test method
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD " + name + " " + email + " " + phone + " " + gender + " "+ password + " " + country + " " + weeklyEmail 
				+ " " +monthlyEmail + " " + occasionalEmail);
				
		defineWebElements();
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		
		passwordElement.sendKeys(password);
		confirmPasswordElement.sendKeys(password);
		
		new Select(countryElement).selectByVisibleText(country);
		
		if (gender.equalsIgnoreCase("Male")){
			maleRadio.click();
		} else {
			femaleRadio.click();
		}
		
		if (weeklyEmail){
			 if (!weeklyCheckbox.isSelected()){
				 weeklyCheckbox.click();
			 }
		} else{
			if (weeklyCheckbox.isSelected()){
				weeklyCheckbox.click();
			}
		}
		if (monthlyEmail){
			 if (!monthlyCheckbox.isSelected()){
				 monthlyCheckbox.click();
			 }
		} else {
			if (monthlyCheckbox.isSelected()){
				monthlyCheckbox.click();
			}
		}
		if (occasionalEmail) {
			 if (!occasionalCheckbox.isSelected()){
				 occasionalCheckbox.click();
			 }
		} else {
			if (occasionalCheckbox.isSelected()){
				occasionalCheckbox.click();
			}
		}
			 
		
		
		submitButton.click();
	}
	
	@Before
	public void setUp(){
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	public void defineWebElements(){
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		confirmPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		femaleRadio = driver.findElement(By.id("MainContent_Female"));
		weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		monthlyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
		occasionalCheckbox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
		submitButton = driver.findElement(By.name("ctl00$MainContent$btnSubmit"));
	}
	//This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("/Users/colinknecht/Desktop/Selenium/RegisterTest.rtf");
	}
	
	//Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email,String phone, String gender, String password, String country, String weeklyEmail,
			String monthlyEmail, String occasionalEmail){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if (weeklyEmail.equalsIgnoreCase("TRUE")) {
			this.weeklyEmail = true;
		} else {
			this.weeklyEmail = false;
		}
		
		if (monthlyEmail.equalsIgnoreCase("TRUE")) {
			this.monthlyEmail = true;
		} else {
			this.monthlyEmail = false;
		}
		if (occasionalEmail.equalsIgnoreCase("TRUE")) {
			this.occasionalEmail = true;
		} else {
			this.occasionalEmail = false;
		}
	}
}
