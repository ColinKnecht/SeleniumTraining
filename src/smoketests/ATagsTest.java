package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running Test"); 
		boolean createAccountPresent = false;
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
		
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		int numberOfAElements = aElements.size();
		System.out.println("Number of a tags = " + numberOfAElements);
		
		for (WebElement aElement : aElements){
			System.out.println(aElement.getText());
			if (aElement.getText().equals("CREATE ACCOUNT")); {
				createAccountPresent = true;
			}
		}
		
		Assert.assertTrue(createAccountPresent);

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
  @Test
  public void aTagsLinksTest() {
	  
  }
}
