package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegestirationTestWithJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;

	Faker faker = new Faker();
	String fn = faker.name().firstName();
	String ln = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String pass = faker.number().digits(8).toString();

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration(fn, ln, email, pass);
		System.out.println("the user data is :  " + fn + "  " + ln + "   " + email + "   " + pass + "   ");
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration"));
	}

	@Test(dependsOnMethods = { "UserCanRegisterSuccessfully" })
	public void RegisteredUserCanLogout() {
		registrationObject.UserLogOut();
	}

	@Test(dependsOnMethods = { "RegisteredUserCanLogout" })
	public void userCanLogin() {
		homeObject.OpenLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, pass);
		Assert.assertTrue(registrationObject.logOutBtn.getText().contains("Log out"));
	}

	@Test(priority = 4)
	public void RegisteredUsercanLogout() {
		registrationObject.UserLogOut();
	}

}
