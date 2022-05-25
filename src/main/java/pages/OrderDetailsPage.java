package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends pagebase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.button-2.print-order-button")
	WebElement PrintBtn;

	@FindBy(linkText = "PDF Invoice")
	WebElement pdfBtn;

	public void PrintOrderDetails() {
		ClickBtn(PrintBtn);
	}

	public void downoadPdf() throws InterruptedException {
		ClickBtn(pdfBtn);
		Thread.sleep(2000);
	}
}
