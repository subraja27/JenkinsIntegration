package day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelIntegration {

	public static String[][] readExcelData(String excelFileName) throws IOException  {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+excelFileName+".xlsx");// "+EditLead+"
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		System.out.println("The total number of rows: "+rowCount);
		short columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("The total number of columns: "+columnCount);
		
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				String stringCellValue = eachRow.getCell(j).getStringCellValue();
				data[i-1][j]=stringCellValue;//data[1-1][0] = "TestLeaf"
				
			}
		}
        wb.close();
        return data;
	}

}