package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends pagebase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement ProductNameBreadCrumb;

	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement EmailfriendBtn;

	@FindBy(css = "span.price-value-4")
	public WebElement productPrice;

	@FindBy(linkText = "Add your review")
	WebElement AddreviewLink;

	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addWishlistBtn;

	@FindBy(linkText = "wishlist")
	WebElement WishlistLink;

	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompareBtn;

	@FindBy(id = "add-to-cart-button-4")
	WebElement AddtoCartBtn;

	@FindBy(linkText = "shopping cart")
	WebElement shoppingCartLink;

	public void OpenSendEmail() {
		ClickBtn(EmailfriendBtn);
	}

	public void OpenAddReview() {
		ClickBtn(AddreviewLink);
	}

	public void AddproductToWishlist() {
		ClickBtn(addWishlistBtn);
	}

	public void OpenWishlist() {
		ClickBtn(WishlistLink);
	}

	public void AddToCompareList() {
		ClickBtn(AddToCompareBtn);
	}

	public void addToCart() {
		ClickBtn(AddtoCartBtn);
	}

	public void OpenMyCart() {
		ClickBtn(shoppingCartLink);
	}

}
