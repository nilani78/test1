package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
  public void ewrite (String Filename, String Filepath, String sheetname, String[] writetodate) throws IOException{
	  File file = new File ( Filepath +"\\"+ Filename);
	  FileInputStream FIS = new FileInputStream((file));
	  Workbook WB = null;
	 String  Fileextension = Filename.substring(Filename.indexOf("."));
	 if ( Fileextension.equals(".xlsx")) {
		 WB = new XSSFWorkbook(FIS);
	 }
	 else  if ( Fileextension.equals(".xls")) {
		 WB = new HSSFWorkbook(FIS);
	 }	
	 Sheet WS = WB.getSheet(sheetname);
	 int rowcount = WS.getLastRowNum() -WS.getFirstRowNum();
	 
	 Row RC= WS.getRow(0);
	 Row nRC = WS.createRow(rowcount+1);
	 
	 for (int j=0; j<RC.getLastCellNum();j++){
		 Cell cell1 = nRC.createCell(j);
		 cell1.setCellValue(writetodate[j]);
		 
	 }
	 
	 FIS.close();
	 
	 FileOutputStream FOS = new FileOutputStream(file);
	 
	WB.write(FOS);
	FOS.close();
	 
  }
	
	
	
	
	
	public static void main(String...strings) throws IOException{
		// TODO Auto-generated method stub
		String[] writetodate = {"Mr.DD1", "DRF" };

		Write objExcelFile = new Write();
		
		objExcelFile.ewrite("ExportExcel.xlsx", "C:\\Users\\govindkx\\workspace\\Guru99\\src\\excelExportAndFileIO", "ExcelGuru99Demo", writetodate);
	}

}
