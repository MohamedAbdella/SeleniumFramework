package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObect;
	ProductDetailsPage detailsObject;

	@Test
	public void userCanSearchForProduct() {
		SearchObect = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		SearchObect.ProductSearch(productName);
		SearchObect.OpenProductDetailPage();
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}

}
