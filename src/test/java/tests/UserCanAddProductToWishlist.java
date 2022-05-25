package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class UserCanAddProductToWishlist extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObect;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;

	@Test(priority = 1)
	public void suercanSearchWithAutoSuggest() throws InterruptedException {
		SearchObect = new SearchPage(driver);
		SearchObect.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}

	@Test(priority = 2)
	public void useCanAddPrpductToWishlist() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddproductToWishlist();
		detailsObject.OpenWishlist();
		wishlistObject = new WishlistPage(driver);
		Assert.assertTrue(wishlistObject.NameOfPRoduct.getText().contains("Apple MacBook Pro 13-inch"));

	}

	@Test(priority = 3)
	public void UserCanRemoveProductFeomWishList() {
		wishlistObject = new WishlistPage(driver);
		wishlistObject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistObject.Notification.getText().contains("The wishlist is empty!"));

	}

}
