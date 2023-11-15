package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	static FileInputStream fc;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public String getUsername(int row, int column) {
		try {
			fc = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\Login.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();
	}

	public String getPassword(int row, int column) {
		try {
			fc = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\Login.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();
	}

	public String getInputStringData(int row, int column) {
		try {
			fc = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\Login.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheet("ManageDeliveryBoy");
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();
	}

	public int getInputNumData(int row, int column) {
		try {
			fc = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\Login.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheet("ManageDeliveryBoy");
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return (int) c.getNumericCellValue();

	}
}