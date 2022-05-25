package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObect;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 2)
	public void usercanChangeCurency() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}

	@Test(priority = 3)
	public void suercanSearchWithAutoSuggest() throws InterruptedException {
		searchObect = new SearchPage(driver);
		searchObect.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(detailsObject.productPrice.getText().contains("€"));
		System.out.println(detailsObject.productPrice.getText());

	}

}
