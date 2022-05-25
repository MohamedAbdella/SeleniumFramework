package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;
	MyAccountPage MyaccountObject;
	String oldpass = "123456789";
	String newpass = "55555555";
	String firstName = "Mohamed";
	String lastName = "bebo";
	String email = "test111@gmail.com";

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration(firstName, lastName, email, oldpass);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration"));
	}

	@Test(dependsOnMethods = { "UserCanRegisterSuccessfully" })
	public void RegisteredUserCanChangePass() throws InterruptedException {
		MyaccountObject = new MyAccountPage(driver);
		registrationObject.OpenMYAccount();
		MyaccountObject.openChangepasslink();
		MyaccountObject.changePass(oldpass, newpass);
		Assert.assertTrue(MyaccountObject.PassChangedTxt.getText().contains("Password was changed"));
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = { "RegisteredUserCanChangePass" })
	public void RegisteredUserCanLogout() throws InterruptedException {
		MyaccountObject.cancelpassChangedMessage();
		Thread.sleep(2000);
		registrationObject.UserLogOut();
	}

	@Test(dependsOnMethods = { "RegisteredUserCanLogout" })
	public void userCanLogin() {
		homeObject.OpenLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, newpass);
		Assert.assertTrue(registrationObject.logOutBtn.getText().contains("Log out"));
	}

	@Test(priority = 5)
	public void RegisteredUsercanLogout() {
		registrationObject.UserLogOut();
	}

}
