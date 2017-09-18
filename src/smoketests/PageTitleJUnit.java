package smoketests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

	@Test
	public void pageTitleTest() {
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get(webUrl);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		
		Assert.assertEquals(expectedTitle, actualTitle);
//		Assert.fail("we intentionally failed the test");
	}
}
