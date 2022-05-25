package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutosuggest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObect;
	ProductDetailsPage detailsObject;

	@Test
	public void suercanSearchWithAutoSuggest() throws InterruptedException {
		SearchObect = new SearchPage(driver);
		SearchObect.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}

}
