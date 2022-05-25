package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAfriendPage extends pagebase {

	public EmailAfriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxTbox;

	@FindBy(id = "YourEmailAddress")
	WebElement YourEmailTxtBox;

	@FindBy(id = "PersonalMessage")
	WebElement PersonalPageTxtBox;

	@FindBy(name = "send-email")
	WebElement SendBtn;

	@FindBy(css = "div.result")
	public WebElement messageNotification;

	public void EmailaFriend(String friendEmail, String message) {
		setTextElementText(friendEmailTxTbox, friendEmail);
		setTextElementText(PersonalPageTxtBox, message);
		ClickBtn(SendBtn);

	}

}
