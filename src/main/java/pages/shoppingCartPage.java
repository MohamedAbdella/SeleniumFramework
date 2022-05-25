package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage extends pagebase {

	public shoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement nameOfProduct;

	@FindBy(name = "updatecart")
	WebElement removeBtn;

	@FindBy(css = "div.no-data")
	public WebElement Notification;

	@FindBy(id = "checkout")
	WebElement CheckoutBtn;

	@FindBy(name = "termsofservice")
	WebElement agreementBtn;

	public void removeProductFromCart() {
		ClickBtn(removeBtn);
	}

	public void OpencheckOut() {
		ClickBtn(agreementBtn);
		ClickBtn(CheckoutBtn);
	}

}
