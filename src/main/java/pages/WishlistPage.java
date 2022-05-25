package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends pagebase {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement NameOfPRoduct;

	@FindBy(id = "updatecart")
	WebElement upadteWishlist;

	@FindBy(css = "button.remove-btn")
	WebElement RemoveFromCartCheck;

	@FindBy(css = "div.no-data")
	public WebElement Notification;

	public void RemoveProductFromWishlist() {
		ClickBtn(RemoveFromCartCheck);

	}

}
