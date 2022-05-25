package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegestirationWithDDTandPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;
	String fn = LoadProperties.userData.getProperty("firstname");
	String ln = LoadProperties.userData.getProperty("Lastname");
	String email = LoadProperties.userData.getProperty("Email");
	String pass = LoadProperties.userData.getProperty("Pass");

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {

		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration(fn, ln, email, pass);
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
