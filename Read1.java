package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read1 {
	
	public void eread(String Filename, String Filepath, String Sheetname) throws IOException{
	File file = new File(Filepath +"//" + Filename)	;
	FileInputStream FIS = new FileInputStream(file);
	Workbook WB = null;
	String FileExtension  = Filename.substring(Filename.indexOf("."));
	if (FileExtension.equals(".xlsx"))	{
		
		WB = new XSSFWorkbook(FIS);
	}
	else if (FileExtension.equals(".xls"))	{
		WB = new HSSFWorkbook(FIS);
	}
		
Sheet WS = WB.getSheet(Sheetname);
int Rowcount = WS.getLastRowNum()-WS.getFirstRowNum();
for (int i=0; i<Rowcount+1; i++){
	Row rownum = WS.getRow(i);
	
	for ( int j=0; j<rownum.getLastCellNum(); j++){
		System.out.println(rownum.getCell(j).getStringCellValue() +"||");
	}
	System.out.println();
}
	
	
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Read1 rd = new Read1();
		String Filepath = System.getProperty("user.dir")+ "\\src\\excelExportAndFileIO";
		rd.eread("ExportExcel.xlsx", Filepath, "ExcelGuru99Demo");
		
	}

}
