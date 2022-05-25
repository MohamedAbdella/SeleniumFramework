package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.EmailAfriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;
import pages.shoppingCartPage;

public class RegisteredUserCheckOutPrpduct extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registrationObject;
	LoginPage LoginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObect;
	ProductDetailsPage detailsObject;
	EmailAfriendPage emailObject;
	shoppingCartPage cartObject;
	CheckOutPage chechoutObject;
	OrderDetailsPage orderObject;

	// 1-user registration

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegisterationPage(driver);
		registrationObject.userRegistiration("Mohamed", "bebo", "test85101@gmail.com", "123456789");
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

	@Test(priority = 3)
	public void UserCanAddtocart() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addToCart();
		detailsObject.OpenMyCart();
		cartObject = new shoppingCartPage(driver);
		Assert.assertTrue(cartObject.nameOfProduct.getText().contains(productName));

	}

	@Test(priority = 4)
	public void UsercancheckOutProduct() throws InterruptedException {
		cartObject = new shoppingCartPage(driver);
		cartObject.OpencheckOut();
		chechoutObject = new CheckOutPage(driver);
		chechoutObject.RegisteredUserCheckOutProduct();
		Assert.assertTrue(chechoutObject.successfulMessagElement.getText()
				.contains("Your order has been successfully processed!"));
		chechoutObject.OpenOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver);
		orderObject.downoadPdf();
		orderObject.PrintOrderDetails();
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void RegisteredUserCanLogout() {
		registrationObject.UserLogOut();
	}

}
