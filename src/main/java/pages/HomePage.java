package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends pagebase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(css = "a.ico-login")
	WebElement LoginLink;

	@FindBy(linkText = "Contact us")
	WebElement contactUSLink;

	@FindBy(id = "customerCurrency")
	WebElement currencyDropDownList;

	@FindBy(linkText = "Computers ")
	WebElement computerMenu;

	@FindBy(linkText = "Notebooks")
	WebElement noteBoxMenu;

	public void OpenRegistrationPage() {
		ClickBtn(registerLink);
	}

	public void OpenLoginPage() {
		ClickBtn(LoginLink);
	}

	public void openContactPage() {
		ScrollToBottom();
	}

	public void ClickonContactUs() {
		ClickBtn(contactUSLink);
	}

	public void changeCurrency() {
		select = new Select(currencyDropDownList);
		select.selectByIndex(1);
	}

	public void selectNoteBoxMenu() {
		action.moveToElement(computerMenu).moveToElement(noteBoxMenu).click().build().perform();

	}

}
