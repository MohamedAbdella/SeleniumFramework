package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegestirationTestWithDDTandExcel extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException {
		// get data feom excel reader class

		ExcelReader ER = new ExcelReader();

		return ER.getExcelData();

	}

	@Test(priority = 1, dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String fn, String ln, String email, String pass) {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration(fn, ln, email, pass);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration"));
		registrationObject.UserLogOut();
		homeObject.OpenLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, pass);
		Assert.assertTrue(registrationObject.logOutBtn.getText().contains("Log out"));
		registrationObject.UserLogOut();

	}

}
