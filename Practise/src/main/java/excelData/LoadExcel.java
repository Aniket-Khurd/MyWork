package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class LoadExcel {
	
	static File src = new File(".//src//main//resources//Data.xlsx");
	static String path = ".//src//main//resources//Data.xlsx";
	
	public static XSSFWorkbook loadFile() throws Exception {

		FileInputStream fin = new FileInputStream(src);
		
		XSSFWorkbook workBook = new XSSFWorkbook(fin);
		
		
		return workBook;
	}
	
	public static void writeXcel(XSSFWorkbook workBook) throws Exception {
		FileOutputStream fout = new FileOutputStream(path);
		
		workBook.write(fout);
		
	}
	
//	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
//	}

}
