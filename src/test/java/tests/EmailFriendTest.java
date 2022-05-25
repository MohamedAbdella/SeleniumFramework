package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailAfriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObect;
	ProductDetailsPage detailsObject;
	EmailAfriendPage emailObject;

	// 1-user registration

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration("Mohamed", "bebo", "test25101@gmail.com", "123456789");
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration"));
	}
	// 2-search for product

	@Test(priority = 2)
	public void suercanSearchWithAutoSuggest() throws InterruptedException {
		SearchObect = new SearchPage(driver);
		SearchObect.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}

	// 3-Email to friend
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() throws InterruptedException {
		detailsObject.OpenSendEmail();
		emailObject = new EmailAfriendPage(driver);
		emailObject.EmailaFriend("aaa22@test.com", "Test automation framework");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
		Thread.sleep(1000);
	}

	// 4- user logout
	@Test(priority = 5)
	public void RegisteredUserCanLogout() {
		registrationObject.UserLogOut();
	}

}
