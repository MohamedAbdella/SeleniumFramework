package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends pagebase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;

	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement state;

	@FindBy(id = "BillingNewAddress_City")
	WebElement city;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zip;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneNumber;

	@FindBy(name = "save")
	WebElement continueBtn;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement ContinueShippingMethodBtn;

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement continuePayment;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement continueInformation;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	public WebElement successfulMessagElement;

	public @FindBy(linkText = "Click here for order details.") WebElement orderDetailsLink;

	public void RegisteredUserCheckOutProduct() throws InterruptedException {
		select = new Select(country);
		select.selectByIndex(1);
		Thread.sleep(1000);
		select2 = new Select(state);
		select2.selectByVisibleText("AA (Armed Forces Americas)");
		Thread.sleep(1000);
		setTextElementText(city, "alex");
		setTextElementText(address, "wjnje");
		setTextElementText(PhoneNumber, "65468465");
		setTextElementText(zip, "416541");
		ClickBtn(continueBtn);
		Thread.sleep(1000);
		ClickBtn(ContinueShippingMethodBtn);
		Thread.sleep(1000);
		ClickBtn(continuePayment);
		Thread.sleep(1000);
		ClickBtn(continueInformation);
		Thread.sleep(1000);
		ClickBtn(confirmBtn);

	}

	public void OpenOrderDetails() {
		ClickBtn(orderDetailsLink);
	}

}
