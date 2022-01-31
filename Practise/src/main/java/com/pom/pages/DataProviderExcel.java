package com.pom.pages;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderExcel {
	
	public  Object[][] readAllRecord() throws Exception {
		File source = new File(".//src//main//resources//Data2.xlsx");
		FileInputStream fin = new FileInputStream(source);
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(fin);

		XSSFSheet sheet = workBook.getSheetAt(0);
		int numofSheets = workBook.getNumberOfSheets();
		System.out.println("Number of sheets = "+numofSheets);

		int numofRows =  sheet.getLastRowNum()+1;
		System.out.println("Number of rows = "+numofRows);
		int totalRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count: "+totalRows);

		XSSFRow row = sheet.getRow(0);
		int numofColumns = row.getLastCellNum();
		System.out.println("Number of Columns = "+numofColumns);
		int totalColumns = row.getPhysicalNumberOfCells();
		System.out.println("Column count: "+totalColumns);
		Object[][] dataProvide = new Object[numofRows][numofColumns];

		for(int i=0; i<numofRows; i++) {

			for(int j=0; j<numofColumns; j++) {

				String data0 = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data0+" ");
				dataProvide[i][j]= data0;
			}
			System.out.println();
		}
		
		System.out.println("_______________________________");
		return dataProvide;
	}
	
	@DataProvider(name="excelData")
	public Object[][] provideData() throws Exception{
		Object[][] data = readAllRecord();
		return data;
	}
//	public static void main(String[] args) throws Exception {
//		readAllRecord();
//	}


}
