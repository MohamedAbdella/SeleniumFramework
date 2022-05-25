package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends pagebase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement fullnameTxt;

	@FindBy(id = "Email")
	WebElement EmailTxt;

	@FindBy(id = "Enquiry")
	WebElement enquiryTxt;

	@FindBy(name = "send-email")
	WebElement SubmitBtn;

	@FindBy(css = "div.result")
	public WebElement successMessage;

	public void ContactUs(String fullName, String Email, String Message) {

		setTextElementText(fullnameTxt, fullName);
		setTextElementText(EmailTxt, Email);
		setTextElementText(enquiryTxt, Message);
		ClickBtn(SubmitBtn);

	}

}
