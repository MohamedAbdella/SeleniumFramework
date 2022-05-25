package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends pagebase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement GenderRdoBtn;

	@FindBy(id = "FirstName")
	WebElement FirstNameTxtBox;

	@FindBy(id = "LastName")
	WebElement LastNameTxtBox;

	@FindBy(id = "Email")
	WebElement EmailTxtBox;

	@FindBy(id = "Password")
	WebElement passTxtbox;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassTxtBox;

	@FindBy(id = "register-button")
	WebElement RegisterBtn;

	@FindBy(css = "div.result")
	public WebElement successMessage;

	@FindBy(css = "a.ico-logout")
	public WebElement logOutBtn;

	@FindBy(linkText = "My account")
	WebElement MyaccountLink;

	public void userRegistiration(String firstName, String lastName, String email, String password) {

		ClickBtn(GenderRdoBtn);
		setTextElementText(FirstNameTxtBox, firstName);
		setTextElementText(LastNameTxtBox, lastName);
		setTextElementText(EmailTxtBox, email);
		setTextElementText(passTxtbox, password);
		setTextElementText(ConfirmPassTxtBox, password);
		ClickBtn(RegisterBtn);

	}

	public void UserLogOut() {
		ClickBtn(logOutBtn);
	}

	public void OpenMYAccount() {
		ClickBtn(MyaccountLink);
	}

}
