package ExcelManager;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.PathHandler;
import LogManager.LogWriter;

public class Reader extends LogWriter{
	PathHandler ph;
	PathItems pi;
	LogWriter lw;
	
	XSSFWorkbook excelJTableImport ;
	XSSFSheet excelSheet1;
	
	public Reader(PathHandler ph){
		this.ph=ph;
	}
	
}
