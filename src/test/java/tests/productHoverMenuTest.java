package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class productHoverMenuTest extends TestBase {
	HomePage homeObject;

	@Test
	public void UserCanSelectSubCategoryFromMAinMenu() {
		homeObject = new HomePage(driver);
		homeObject.selectNoteBoxMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

	}

}
