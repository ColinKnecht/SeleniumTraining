package stepImplementation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {

	WebDriver driver;
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page(){
		System.out.println("User is on the login page");
		//open driver
		driver = utilities.DriverFactory.open("chrome");
		driver.manage().window().maximize();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//navigate to login page
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password(){
		System.out.println("User enters correct username and password");
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		driver.findElement(By.name("MainContent_btnLogin")).click();	
	}
	
	@When("^user enters email(.*)$")
	public void user_enters_username(String username){
		System.out.println("Testing Username");
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
	}
	
	@And ("^user enters password(.*)$")
	public void user_enters_password(String password){
		System.out.println("Testing Password");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("MainContent_btnLogin")).click();
	}
	
//	@And("user clicks login button")
//	public void user_clicks_login_button(){
//		driver.findElement(By.name("MainContent_btnLogin")).click();
//	}
	
	@Then("^user gets confiramtion$")
	public void user_gets_confirmation(){
		System.out.println("User gets confirmation");
		driver.findElement(By.id("conf_message")).getText();
		Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
	}
	
	@After 
	public void tearDown(){
		driver.quit();
	}
}
