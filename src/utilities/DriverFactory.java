package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public static WebDriver open(String browserType){
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/colinknecht/Desktop/Selenium/geckodriver");
			return new FirefoxDriver();
		}else if (browserType.equalsIgnoreCase("IE")){
			//JUST AN EXAMPLE....NOT INSTALLED
			System.setProperty("webdriver.id.driver", "/Users/colinknecht/Desktop/Selenium/IEDriverServer");
			return new InternetExplorerDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "/Users/colinknecht/Desktop/Selenium/chromedriver");
			return new ChromeDriver();	
		}
	}
}
