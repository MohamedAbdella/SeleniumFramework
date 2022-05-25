package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerOgject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();

	}

	@When("I click on the register link")
	public void i_click_on_the_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));

	}

	/*
	 * @When("I enterd the user data") public void i_enterd_the_user_data() {
	 * registerOgject = new UserRegisterationPage(driver);
	 * registerOgject.userRegistiration("mohamed", "bebo", "bebidwdw211@est.com",
	 * "12345678");
	 * 
	 * }
	 */

	@When("I enterd {string},{string},{string},{string}")
	public void i_enterd(String firstname, String lastname, String email, String pass) {
		registerOgject = new UserRegisterationPage(driver);
		registerOgject.userRegistiration(firstname, lastname, email, pass);

	}

	@Then("the registration page displayed successully")
	public void the_registration_page_displayed_successully() {
		registerOgject = new UserRegisterationPage(driver);
		registerOgject.UserLogOut();

	}

}
