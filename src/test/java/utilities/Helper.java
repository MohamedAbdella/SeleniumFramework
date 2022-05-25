package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	// Method to take screenshots when the test cases fail

	public static void captureScreenShot(WebDriver driver, String screenshotName) {

		Path destination = Paths.get("./screenshots", screenshotName + ".png");
		try {

			Files.createDirectories(destination.getParent());
			FileOutputStream outputStream = new FileOutputStream(destination.toString());
			outputStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screenshots" + e.getMessage());
		}
	}

}
