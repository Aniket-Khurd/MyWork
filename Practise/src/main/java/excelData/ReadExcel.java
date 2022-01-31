package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel extends ReadExcelTest{
	//static XSSFSheet sheet;



	//	String data = sheet.getRow(0).getCell(0).getStringCellValue();
	//	System.out.println(data);



	public static boolean searchData(XSSFWorkbook workBook, String search) {
	XSSFSheet	sheet = workBook.getSheetAt(0);
		int numofRows = sheet.getLastRowNum()+1;

		XSSFRow row = sheet.getRow(0);
		int numofColumns = row.getLastCellNum();


		boolean found = false;
		int r=0,c=0;
		for (int i = 0; i < numofRows; i++) {
			for (int j = 0; j < numofColumns; j++) {
				//your comparison code goes here
				boolean   flag = sheet.getRow(i).getCell(j).getStringCellValue().equals(search);
				//sheet.getRow(i).getCell(j).getCellType().equals(CellType.NUMERIC);
				if(flag == true) {
					r =i;
					c =j;
					found = true;
					break;
				}
			}
		}
		

		if(found==true) {
			System.out.println(search+" Found at: row"+r+","+c);
		}
		else {
			System.out.println("Not found");
		}
		
		return found;
		
		//System.out.println("___________________________");
	}





	public static void readAllRecord(XSSFWorkbook workBook) {

		XSSFSheet sheet = workBook.getSheetAt(0);
		int numofSheets = workBook.getNumberOfSheets();
		System.out.println("Number of sheets = "+numofSheets);

		int numofRows =  sheet.getLastRowNum()+1;
		System.out.println("Number of rows = "+numofRows);


		XSSFRow row = sheet.getRow(0);
		int numofColumns = row.getLastCellNum();
		System.out.println("Number of Columns = "+numofColumns);


		for(int i=0; i<numofRows; i++) {

			for(int j=0; j<numofColumns; j++) {

				String data0 = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data0+" ");
			}
			System.out.println();
		}
		
		System.out.println("_______________________________");
	}


	public static boolean checkFlag(XSSFWorkbook workBook, String flagValue) {
		XSSFSheet sheet = workBook.getSheetAt(0);
		int numofRows = sheet.getLastRowNum()+1;

		XSSFRow row = sheet.getRow(0);
		int numofColumns = row.getLastCellNum();
		
		System.out.println("Records with "+flagValue+" flag");
		boolean dataWithFlag = false;
		int yFlagCnt=0;
		for(int l=0; l<numofRows; l++ ) {
			for(int m=0; m<numofColumns; m++) {
				boolean flag = sheet.getRow(l).getCell(m).getStringCellValue().equalsIgnoreCase(flagValue);

				if(flag == true) {

					dataWithFlag = true;
					for(int n=0; n<numofColumns-1; n++) {
						String value = sheet.getRow(l).getCell(n).getStringCellValue();
						System.out.print(value+" ");
					}
					System.out.println();
					yFlagCnt++;

				}
			}
		}

		System.out.println("Total number of records with "+flagValue+" flag: "+yFlagCnt);
		return dataWithFlag;
	}
	
	
	
}
	
