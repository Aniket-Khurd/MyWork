package excelData;

import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;

public class writeExcelTest {
	XSSFWorkbook workBook;
	
  @Test(enabled = false)
  public void test1() {
	  writeExcel.addCellData(workBook);
  }
  
  
  @Test(enabled = false)
  public void test2() {
	  writeExcel.updateCellData(workBook);
  }
  
  
  @Test(enabled = false)
  public void test3() {
	  writeExcel.removeCellData(workBook);
  }
  
  
  @Test(enabled = true)
  public void test4() {
	  writeExcel.createSheet(workBook, "sheet5");
  }
  
  
  @Test(enabled = false)
  public void test5() {
	  writeExcel.removeSheet(workBook,4);
  }
  
  
  @Test(enabled = false)
  public void test6() {
	  writeExcel.setBackgroundColor(workBook);
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  try {
		workBook = LoadExcel.loadFile();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }

}
