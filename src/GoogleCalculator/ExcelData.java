package GoogleCalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	
	static String ExcelPath = "C:\\Users\\VinayVinay\\Desktop\\Vinay Docs\\Eclipse\\Selenium_projects\\Selenium_Test_project\\src\\TestData.xlsx";
	
	public int ReadExcelData(String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(ExcelPath));
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rownum);
		Cell ce = rw.getCell(cellnum);
		int result = (int) ce.getNumericCellValue();
		
		return result;
		
	}
	
	public void WirteExcelData(String sheetName, int rownum, int cellnum, String data) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(ExcelPath));
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rownum);
		Cell ce = rw.createCell(cellnum);
		ce.setCellValue(data);
		
		FileOutputStream fwrite = new FileOutputStream(ExcelPath);
		wb.write(fwrite);
	}

}
