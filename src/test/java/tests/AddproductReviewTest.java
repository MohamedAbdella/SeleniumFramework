package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddproductReviewTest extends TestBase {

	UserRegisterationPage registrationObject;
	HomePage homeObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObect;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	// 1-regiseter 2-search 3-addreview 4- logout
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration("Mohamed", "bebo", "test30001@gmail.com", "123456789");
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration"));
	}

	@Test(priority = 2)
	public void suercanSearchWithAutoSuggest() throws InterruptedException {
		SearchObect = new SearchPage(driver);
		SearchObect.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}

	@Test(priority = 3)
	public void userCanAddReview() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.OpenAddReview();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddReview("bebo", "this is good");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added."));

	}

	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registrationObject.UserLogOut();
	}

}
