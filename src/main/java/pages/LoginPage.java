package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pagebase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement EmailTxtBox;

	@FindBy(id = "Password")
	WebElement PassTxtBox;

	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;

	public void UserLogin(String email, String Passwprd) {
		setTextElementText(EmailTxtBox, email);
		setTextElementText(PassTxtBox, Passwprd);
		ClickBtn(loginBtn);

	}

}
