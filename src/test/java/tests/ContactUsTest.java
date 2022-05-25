package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage homePage;
	ContactUsPage contactUsPage;

	String email = "tsee311@test.com";
	String fullName = "Test User";
	String enquiry = "Hello, this is for test";

	@Test
	public void userCanContactUs() {
		homePage = new HomePage(driver);
		homePage.openContactPage();
		homePage.ClickonContactUs();
		contactUsPage = new ContactUsPage(driver);
		contactUsPage.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactUsPage.successMessage.getText().contains("Your enquiry has"));
	}

}
