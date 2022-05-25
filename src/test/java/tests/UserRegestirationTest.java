package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegestirationTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration("Mohamed", "bebo", "test1000@gmail.com", "123456789");
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
		LoginObject.UserLogin("test1000@gmail.com", "123456789");
		Assert.assertTrue(registrationObject.logOutBtn.getText().contains("Log out"));
	}

	@Test(priority = 4)
	public void RegisteredUsercanLogout() {
		registrationObject.UserLogOut();
	}

}
