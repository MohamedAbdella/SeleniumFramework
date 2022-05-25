package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.shoppingCartPage;

public class AddToCartTest extends TestBase {

	ProductDetailsPage detailsObject;
	shoppingCartPage cartObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void suercanSearchWithAutoSuggest() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}

	@Test(priority = 2)
	public void UserCanAddtocart() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addToCart();
		detailsObject.OpenMyCart();
		cartObject = new shoppingCartPage(driver);
		Assert.assertTrue(cartObject.nameOfProduct.getText().contains(productName));

	}

	@Test(priority = 3)
	public void UserCanRemoveFromMyCart() {
		cartObject = new shoppingCartPage(driver);
		cartObject.removeProductFromCart();
		Assert.assertTrue(cartObject.Notification.getText().contains("Your Shopping Cart is empty!"));
	}

}
