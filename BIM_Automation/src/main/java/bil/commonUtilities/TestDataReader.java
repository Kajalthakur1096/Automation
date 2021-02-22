package bil.commonUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {
	protected FileInputStream objectOfFileInputStream;
	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;

	public XSSFSheet getExcelSheetAccess(String sheetName) throws IOException {
		objectOfFileInputStream = new FileInputStream(ConfigFileReader.INSTANCE.getExcelTestDataPath());
		workbook = new XSSFWorkbook(objectOfFileInputStream);
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName)) {
				sheet = workbook.getSheetAt(i);
			} else {
				// -->##write a code for sheet not found
			}
		}
		return sheet;

	}

	public String[][] getLoginData(String sheetName) throws IOException {
		sheet = getExcelSheetAccess(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows() - 1;
		Row row1 = sheet.getRow(0);
		int columnCount = row1.getLastCellNum();
		String[][] cred = new String[rowCount][columnCount];
		if (rowCount > 0) {
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i + 1);
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					try{
					cred[i][j] = cell.getStringCellValue();
					}
					catch(IllegalStateException e){
						cred[i][j] = String.valueOf((int)cell.getNumericCellValue());					
					}
					catch(NullPointerException e){
						
					}
				}
			}
		}

		return cred;
	}

	/*
	 * public void getAssignmentData() {
	 * 
	 * }
	 */
}