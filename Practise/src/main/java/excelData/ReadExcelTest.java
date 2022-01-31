package excelData;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadExcelTest  {
	XSSFWorkbook workBook;
  @Test(priority = 1)
  public void test1() {
	  ReadExcel.readAllRecord(workBook);
  }
  
  @Test(priority = 2)
  public  void tes2() {
	 boolean found = ReadExcel.searchData(workBook, "Aniket");
	 Assert.assertTrue(found);
  }
  
  @Test(priority = 3)
  public void test3() {
	boolean dataWithFlagFound = ReadExcel.checkFlag(workBook,"y");
	Assert.assertTrue(dataWithFlagFound);
  }
  
  @BeforeClass
  public void beforeClass() {
	try {
		workBook = LoadExcel.loadFile();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  }
}
