package tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.testng.Assert;



@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	String gender;
	String password;
	String country;
	boolean weeklyEmail;
	boolean monthlyEmail;
	boolean occasionalEmail;

	//This is out test method
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD " + name + " " + email + " " + phone + " " + gender + " "+ password + " " + country + " " + weeklyEmail 
				+ " " +monthlyEmail + " " + occasionalEmail);

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
