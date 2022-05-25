package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends pagebase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changePassLink;

	@FindBy(id = "OldPassword")
	WebElement oldPassTxtBox;

	@FindBy(id = "NewPassword")
	WebElement newPassTxtBox;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPassTxtBox;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changepassBtn;

	@FindBy(css = "p.content")
	public WebElement PassChangedTxt;

	@FindBy(css = "span.close")
	public WebElement cancelPassChangedTxt;

	public void openChangepasslink() {
		ClickBtn(changePassLink);
	}

	public void changePass(String oldPass, String newPass) {
		setTextElementText(oldPassTxtBox, oldPass);
		setTextElementText(newPassTxtBox, newPass);
		setTextElementText(confirmPassTxtBox, newPass);
		ClickBtn(changepassBtn);

	}

	public void cancelpassChangedMessage() {
		ClickBtn(cancelPassChangedTxt);
	}
}
