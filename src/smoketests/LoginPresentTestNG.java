package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPresentTestNG {

	@Test
	public void loginElementsPresentTest() {
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		
	}
}
