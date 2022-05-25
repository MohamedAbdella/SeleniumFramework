package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegestirationTestWithDDTandCSV extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;

	CSVReader reader;

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException {
		// get path of csv file
		String csvFile = System.getProperty("user.dir" + "\\src\\test\\java\\data\\userDataa.csv");
		reader = new CSVReader(new FileReader(csvFile));

		String[] csvcell;
		// While loop will be executed till the lastvalue in csv fle
		while ((csvcell = reader.readNext()) != null) {
			String fn = csvcell[0];
			String ln = csvcell[1];
			String email = csvcell[2];
			String pass = csvcell[3];
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

}
