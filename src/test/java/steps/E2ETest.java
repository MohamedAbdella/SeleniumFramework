package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;
import pages.shoppingCartPage;
import tests.TestBase;

public class E2ETest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerOgject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	shoppingCartPage cartObject;
	CheckOutPage chechoutObject;
	OrderDetailsPage orderObject;
	String productname = "Apple MacBook Pro 13-inch";

	@Given("user is on home page")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));

	}

	@When("he search from {string}")
	public void he_search_from(String productname) throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(productname);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));

	}

	@When("choose to buy two item")
	public void choose_to_buy_two_item() {
		detailsObject.addToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");

	}

	@When("moves to checkout cart and ente personal details on checkout page nd place the order")
	public void moves_to_checkout_cart_and_ente_personal_details_on_checkout_page_nd_place_the_order()
			throws InterruptedException {
		cartObject = new shoppingCartPage(driver);
		cartObject.OpencheckOut();
		chechoutObject = new CheckOutPage(driver);
		chechoutObject.RegisteredUserCheckOutProduct();
		Assert.assertTrue(chechoutObject.successfulMessagElement.getText()
				.contains("Your order has been successfully processed!"));

	}

	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		chechoutObject.OpenOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver);
		orderObject.downoadPdf();
		orderObject.PrintOrderDetails();
		Thread.sleep(1000);

	}

}
