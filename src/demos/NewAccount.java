package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount
{

	public static void main(String[] args)
	{
		String name= "Tommy Thompson";
		String email = "tt@testemail.com";
		String password = "ttpass";
		String country = "United States";
		String phoneNumber = "123-456-1987";
		String browserType = "chrome";
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occastionalEmail = true;
	// 1. Create WebDriver
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		driver.findElement(By.linkText("Create Account")).click();
		
		//Define Web Elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement confirmPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));

	//2. Navigate to account management page

		
	//3. fill out form
		//how to locate elements
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		
		passwordElement.sendKeys(password);
		confirmPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		if (gender.equalsIgnoreCase("Male")){
			maleRadio.click();
		} else {
			femaleRadio.click();
		}
		
		//Check box algorithms
		if (weeklyEmail){
			 if (!weeklyCheckbox.isSelected()){
				 weeklyCheckbox.click();
			 }
		} else{
			if (weeklyCheckbox.isSelected()){
				weeklyCheckbox.click();
			}
		}
		
//		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();

//		weeklyCheckbox.click();	
		
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
	//4. get confirmation
		String confirm = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (confirm.contains(expected)){
			System.out.println("Confirmation message = " +  confirm);
		} else {
			System.out.println("Test Failed");
		}
		
		
	//5. close browser
		driver.close();

	}

}
