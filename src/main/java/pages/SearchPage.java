package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends pagebase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id = "ui-id-1")
	List<WebElement> productList;

	@FindBy(css = "h2.product-title")
	WebElement ProductTitle;

	public void ProductSearch(String ProductName) {
		setTextElementText(searchTxtBox, ProductName);
		ClickBtn(searchBtn);
	}

	public void OpenProductDetailPage() {
		ClickBtn(ProductTitle);
	}

	public void ProductSearchUsingAutoSuggest(String searchTxt) throws InterruptedException {
		setTextElementText(searchTxtBox, searchTxt);
		Thread.sleep(2000);
		productList.get(0).click();
	}

}
