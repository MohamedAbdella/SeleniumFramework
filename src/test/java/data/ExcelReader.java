package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {

		String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.xlsx";
		File srcFile = new File(filepath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file not found     " + e.getMessage());
			System.exit(0);

		}
		return fis;
	}

	public Object[][] getExcelData() throws IOException {
		fis = getFileInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int totalNumOfRows = (sheet.getLastRowNum() + 1);
		int totalNumOfColumns = 4;

		String[][] arrayOfExcelData = new String[totalNumOfRows][totalNumOfColumns];

		for (int i = 0; i < totalNumOfRows; i++) {
			for (int j = 0; j < totalNumOfColumns; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayOfExcelData[i][j] = row.getCell(j).toString();

			}
		}
		workbook.close();
		return arrayOfExcelData;

	}

}
