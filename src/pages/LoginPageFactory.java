package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory{

	WebDriver driver;
	
	@FindBy(id="MainContent_txtUserName")
	WebElement userNameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement submitButton;
	
	public LoginPageFactory(WebDriver driver){ //constructor
		this.driver = driver;
	}
	
	public void setUserName(String userName){
		userNameBox.sendKeys(userName);
	}
	
	public void setPassword(String password){
		passwordBox.sendKeys(password);
	}
	
	public void clickSubmit(){
		submitButton.click();
	}
	
	public void login(String username, String password){
		setUserName(username);
		setPassword(password);
		clickSubmit();
	}

}
