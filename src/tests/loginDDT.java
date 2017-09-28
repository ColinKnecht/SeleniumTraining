package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginDDT {
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password){
		System.out.println(name + " " + email + " " + password);
	}
	
	@DataProvider
	public String[][] getData(){
		String filename = "/Users/colinknecht/Desktop/Selenium/XcelTest.xls";
		return utilities.Excel.get(filename);
	}
}
