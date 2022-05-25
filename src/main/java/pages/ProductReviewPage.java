package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends pagebase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement ReviewTitleTxtBox;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewTextTxtBox;

	@FindBy(id = "addproductrating_3")
	WebElement reviewRadioBtn;

	@FindBy(name = "add-review")
	WebElement submitReview;

	@FindBy(css = "div.result")
	public WebElement reviewNotification;

	public void AddReview(String reviewTitle, String reviewMessage) {
		setTextElementText(ReviewTitleTxtBox, reviewTitle);
		setTextElementText(ReviewTextTxtBox, reviewMessage);
		ClickBtn(reviewRadioBtn);
		ClickBtn(submitReview);

	}

}
