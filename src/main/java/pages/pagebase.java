package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pagebase {
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Select select2;
	public Actions action;

	// create constructor
	public pagebase(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	protected static void ClickBtn(WebElement Button) {
		Button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}

	public void ScrollToBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}

}
