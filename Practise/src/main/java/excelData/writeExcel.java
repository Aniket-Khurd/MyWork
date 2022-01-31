package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeExcel {

//	public static void main(String[] args) throws Exception {
//		
//		File src = new File("E:\\\\demo\\\\ExcelData\\\\Data.xlsx");
//		
//		FileInputStream fin = new FileInputStream(src);
//		
//		XSSFWorkbook wb = new XSSFWorkbook(fin);
//		
//		XSSFSheet sheet = wb.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		//to add cell data
//		sheet.getRow(0).createCell(3).setCellValue("1");
//		sheet.getRow(1).createCell(3).setCellValue("2");
//		sheet.getRow(2).createCell(3).setCellValue("3");
//		
//		//to update cell data
//		sheet.getRow(0).getCell(0).setCellValue("Aniket");
//		
//		//to remove cell data
//		XSSFCell cell = sheet.getRow(0).getCell(3);
////		if(cell.getCellType()!= CellType.BLANK) {
////			cell.setCellType(CellType.BLANK);
////		}
//		/* code to add/edit/remove sheet
//		wb.createSheet("sheet5");
//		wb.removeSheetAt(4);*/
//		
//		cell = row.getCell(0);
//		
//		XSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
//		cellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
//		cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
//		cell.setCellStyle(cellStyle);
//		
//		FileOutputStream fout = new FileOutputStream(src);
//		
//		wb.write(fout);
//		
//		wb.close();
//		System.out.println("Process completed, workbook closed");
//
//	}
	
	public static void addCellData(XSSFWorkbook workBook) {
		XSSFSheet sheet = workBook.getSheetAt(0);
		sheet.getRow(0).createCell(3).setCellValue("1");
		sheet.getRow(1).createCell(3).setCellValue("2");
		sheet.getRow(2).createCell(3).setCellValue("3");
		sheet.createRow(3).createCell(0).setCellValue("Testrig");
		try {
			LoadExcel.writeXcel(workBook);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		}
	}
	
	public static void updateCellData(XSSFWorkbook workBook) {
		XSSFSheet sheet = workBook.getSheetAt(0);
		sheet.getRow(2).getCell(0).setCellValue("Somnath");
		try {
			LoadExcel.writeXcel(workBook);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		}
		
	}
	
	public static void removeCellData(XSSFWorkbook workBook) {
		XSSFSheet sheet = workBook.getSheetAt(0);
		XSSFCell cell = sheet.getRow(0).getCell(4);
		if(cell != null) {
			if(cell.getCellType()!= CellType.BLANK) {
				cell.setCellType(CellType.BLANK);
			}
		}
		else {
			System.out.println("Cell is already blank");
		}
		
		try {
			LoadExcel.writeXcel(workBook);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		}
	}
	
	

	public static void createSheet(XSSFWorkbook workBook,String sheetName) {
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		List<String> allSheetNames = new ArrayList<String>();
		
		for(int i=0; i<workBook.getNumberOfSheets(); i++) {
			allSheetNames.add(workBook.getSheetName(i));
		}
		System.out.println(allSheetNames);
		
		if(allSheetNames.contains(sheetName)) {
			System.out.println(sheetName+" already exists");
		}
		else {
			workBook.createSheet(sheetName);
		}

		try {
			LoadExcel.writeXcel(workBook);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		}

	}
	
	
	
	public static void removeSheet(XSSFWorkbook workBook, int removeSheetNumber) {
		try{
			int totalSheets = workBook.getNumberOfSheets();
			if(totalSheets >= removeSheetNumber) {
				workBook.removeSheetAt(removeSheetNumber-1);
			}
			else {
				System.out.println("sheet"+removeSheetNumber+" not exists");
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		
		try {
			LoadExcel.writeXcel(workBook);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		}
	}
//	
	public static void setBackgroundColor(XSSFWorkbook workBook) {
		XSSFSheet sheet = workBook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		
		XSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.BLUE.index);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);
		
		try {
			LoadExcel.writeXcel(workBook);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		}
	
	}

}
