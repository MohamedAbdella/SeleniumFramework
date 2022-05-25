package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegestirationWithDataDrivenAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;

	@DataProvider(name = "TestData")
	public static Object[][] userData() {
		return new Object[][] { { "bebo", "mohmed", "wjewe01211@gmail.com", "555555555" },
				{ "ahmed", "mostafa", "cqdqw10010@test.com", "00000000" } };

	}

	@Test(priority = 1, dataProvider = "TestData")
	public void UserCanRegisterSuccessfully(String firstname, String lstname, String email, String password) {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration(firstname, lstname, email, password);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration"));
		registrationObject.UserLogOut();
		homeObject.OpenLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, password);
		Assert.assertTrue(registrationObject.logOutBtn.getText().contains("Log out"));
		registrationObject.UserLogOut();

	}

}
