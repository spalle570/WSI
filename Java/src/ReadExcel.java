import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	private String testCaseName;

	static String filePath = "C:\\Users\\spalle\\Desktop\\Test_Data_1.xlsx";

	public String getClassName() {

		return testCaseName = this.getClass().getSimpleName();

	}

	@SuppressWarnings("deprecation")
	public static HashMap<String, String> readExcel(int rowNum, String testCaseName) throws IOException {

		File src = new File("C:\\Users\\spalle\\Desktop\\Test_Data_1.xlsx");

		HashMap<String, String> hMap = new HashMap<String, String>();

		// A FileInputStream obtains input bytes from a file in a file system.
		// What files are available depends on the host environment.
		// FileInputStream is meant for reading streams of raw bytes such as
		// image data. For reading streams of characters, consider using
		// FileReader.

		FileInputStream inputStream = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		String cellValue = null;
		// int j=0;
		String columnVals = null;
		System.out.println(rows);
		// for(int i=0;i<=rows;i++)
		// {
		for (int j = 0; j < cols; j++) {
			if (sheet.getRow(rowNum).getCell(0).getStringCellValue().equals(testCaseName)) {

				if (sheet.getRow(rowNum).getCell(j).getCellType() == XSSFCell.CELL_TYPE_STRING) {
					
					cellValue = sheet.getRow(rowNum).getCell(j).getStringCellValue();
					
				} else if (sheet.getRow(rowNum).getCell(j).getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					
					boolean value = sheet.getRow(rowNum).getCell(j).getBooleanCellValue();
					
					cellValue = Boolean.toString(value);// CELL_TYPE_NUMERIC
				} else if (sheet.getRow(rowNum).getCell(j).getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					
					double numeric = sheet.getRow(rowNum).getCell(j).getNumericCellValue();
					
					cellValue = Double.toString(numeric);

				} else if (sheet.getRow(rowNum).getCell(j).getCellType() == XSSFCell.CELL_TYPE_BLANK) {
					
					cellValue = "";
				} else if (sheet.getRow(rowNum).getCell(j).getCellType() == XSSFCell.CELL_TYPE_FORMULA) {

					cellValue = sheet.getRow(rowNum).getCell(j).getCellFormula();
				} else if (sheet.getRow(rowNum).getCell(j).getCellType() == XSSFCell.CELL_TYPE_ERROR) {

					cellValue = "";
				}

				hMap.put(sheet.getRow(0).getCell(j).getStringCellValue(), cellValue);
			}

		}

		return hMap;
	}

	public static int getRows(String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		return rows;
	}

	@Test
	public void test() throws IOException {
		ReadExcel obj = new ReadExcel();
		String val = getClassName();

		System.out.println("Class Value is " + val);
		HashMap<String, String> hMap = new HashMap<String, String>();
		int rowCount = getRows(filePath);
		for (int i = 0; i <= rowCount; i++) {
			hMap = readExcel(i, val);
			if (hMap.isEmpty() == false) {

				System.out.println("Final Hash Map" + hMap);
			}

		}
	}

}
