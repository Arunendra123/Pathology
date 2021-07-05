package ExcelManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.PathHandler;
import LogManager.LogWriter;
import ViewLayer.ComboBox;
import ViewLayer.Text;

public class Writer extends LogWriter{
	PathHandler ph;
	PathItems pi;
	LogWriter lw;
	FileOutputStream out;
	public Writer(){
	}
	public Writer(PathHandler ph){
        try {
			this.out = new FileOutputStream(new File(ph.getOutputDirectoryPath()));
		} catch (FileNotFoundException e) {
			 LogWriter.WriteLogs("Class:Writer,Method:Writer"+e);
		}
	}
    
	public void setPath(PathHandler ph) {
		try {
			this.out = new FileOutputStream(new File(ph.getOutputDirectoryPath()));
		} catch (FileNotFoundException e) {
			LogWriter.WriteLogs("Class:Writer,Method:setPath"+e);
		}
	}
	
	public FileOutputStream getOut(){
		return out;
	}
    
    @SuppressWarnings("resource")
	public void generateReport(List<PathItems> pil,String doctorName) throws Exception 
    {
    	
    	    ///////////////////////////////////////////////////////////////////////////////
	        XSSFWorkbook workbook=new XSSFWorkbook();
	        
	        //style1
	        CellStyle style1 = workbook.createCellStyle();
	        XSSFFont font1 = workbook.createFont();
			font1.setFontHeightInPoints((short) 18);
			font1.setFontName("New Roman");
			font1.setBold(true);
			font1.setColor(IndexedColors.GREEN.getIndex());
	        style1.setFont(font1);
	        style1.setAlignment(HorizontalAlignment.CENTER);
	       
	        
	        //style1
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName("New Roman");
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
	        style.setFont(font);
	        style.setAlignment(HorizontalAlignment.CENTER);
	        
	        style.setBorderBottom(BorderStyle.THICK);  
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderRight(BorderStyle.THICK);  
            style.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style.setBorderLeft(BorderStyle.THICK);  
            style.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style.setBorderTop(BorderStyle.THICK);  
            style.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
            style.setFillBackgroundColor(IndexedColors.SEA_GREEN.getIndex());
            style.setFillPattern(FillPatternType.LESS_DOTS);
            
            //style2
	        CellStyle style2 = workbook.createCellStyle();
	        XSSFFont font2 = workbook.createFont();
			font2.setFontHeightInPoints((short) 10);
			font2.setFontName("New Roman");
			font2.setColor(IndexedColors.BLACK.getIndex());
	        style2.setFont(font2);
	        style2.setAlignment(HorizontalAlignment.LEFT);
	        
	        style2.setBorderBottom(BorderStyle.THIN);  
            style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style2.setBorderRight(BorderStyle.THIN);  
            style2.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderLeft(BorderStyle.THIN);  
            style2.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderTop(BorderStyle.THIN);  
            style2.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
	        
            //first row...
			XSSFSheet spreadsheet = workbook.createSheet(doctorName);
	        XSSFRow row;
	        int rowid = 0;
	        row = spreadsheet.createRow(rowid++);
	        Cell cc=row.createCell(0);cc.setCellValue(doctorName); cc.setCellStyle(style1);
	        spreadsheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
	        
	        //header...
	        row = spreadsheet.createRow(rowid++);
	        Cell c1=row.createCell(0);c1.setCellValue("    Date    ");    c1.setCellStyle(style); 
	        Cell c2=row.createCell(1);c2.setCellValue("   Pt-Name   ");   c2.setCellStyle(style);
	        Cell c3=row.createCell(2);c3.setCellValue("Full-Amt");        c3.setCellStyle(style);
	        Cell c4=row.createCell(3);c4.setCellValue("Paid-Amt");        c4.setCellStyle(style);
	        Cell c5=row.createCell(4);c5.setCellValue("Conc-Amt");      c5.setCellStyle(style);
	        Cell c6=row.createCell(5);c6.setCellValue("Collection");        c6.setCellStyle(style);
	        Cell c7=row.createCell(6);c7.setCellValue("Cut-Amt");         c7.setCellStyle(style);

	        for(int colNum = 0; colNum<row.getLastCellNum();colNum++)   
	            workbook.getSheetAt(0).autoSizeColumn(colNum);
	        
	        //////////////////////////////////////////////////////////////////////////////////
	        int paidAmount=0;
	        int cutAmount=0;
	        int fullAmount=0;
	        for (PathItems pi : pil) {
	        	
	        	//Calculation
	        	paidAmount=paidAmount+pi.getPaidAmount();
	        	cutAmount=cutAmount+pi.getCutAmount();
	        	fullAmount=fullAmount+pi.getFullAmount();
	        	PathItems.printItems(pi);
	            row = spreadsheet.createRow(rowid++);
                c1=row.createCell(0);c1.setCellValue(pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear());
	            c2=row.createCell(1);c2.setCellValue(pi.getPtName());
	            c3=row.createCell(2);c3.setCellValue(pi.getFullAmount());
	            c4=row.createCell(3);c4.setCellValue(pi.getPaidAmount());
	            c5=row.createCell(4);c5.setCellValue(pi.getConcAmount());
	            c6=row.createCell(5);c6.setCellValue(pi.getCollection());
	            c7=row.createCell(6);c7.setCellValue(pi.getCutAmount());
	            
	            c1.setCellStyle(style2);
	            c2.setCellStyle(style2);
	            c3.setCellStyle(style2);
	            c4.setCellStyle(style2);
	            c5.setCellStyle(style2);
	            c6.setCellStyle(style2);
	            c7.setCellStyle(style2);
	        }
	        
	        row = spreadsheet.createRow(rowid++);
	        c1=row.createCell(0);c1.setCellValue("");
            c2=row.createCell(1);c2.setCellValue("Total: ");
            c3=row.createCell(2);c3.setCellValue(fullAmount);
            c4=row.createCell(3);c4.setCellValue(paidAmount);
            c5=row.createCell(4);c5.setCellValue("");
            c6=row.createCell(5);c6.setCellValue("");
            c7=row.createCell(6);c7.setCellValue(cutAmount);
            c1.setCellStyle(style); 
            c2.setCellStyle(style); 
            c3.setCellStyle(style); 
            c4.setCellStyle(style); 
            c5.setCellStyle(style); 
            c6.setCellStyle(style); 
            c7.setCellStyle(style); 
                       
	        workbook.write(this.out);
	        out.close();
	        workbook.close();
	 }
    
   
    @SuppressWarnings("resource")
	public XSSFWorkbook generateReportInOne(XSSFWorkbook workbook,List<PathItems> pil,String doctorName) throws Exception 
    {
	        //style1
	        CellStyle style1 = workbook.createCellStyle();
	        XSSFFont font1 = workbook.createFont();
			font1.setFontHeightInPoints((short) 18);
			font1.setFontName("New Roman");
			font1.setBold(true);
			font1.setColor(IndexedColors.GREEN.getIndex());
	        style1.setFont(font1);
	        style1.setAlignment(HorizontalAlignment.CENTER);
	        
	        //style1
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName("New Roman");
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
	        style.setFont(font);
	        style.setAlignment(HorizontalAlignment.CENTER);
	        
	        style.setBorderBottom(BorderStyle.THICK);  
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderRight(BorderStyle.THICK);  
            style.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style.setBorderLeft(BorderStyle.THICK);  
            style.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style.setBorderTop(BorderStyle.THICK);  
            style.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
            style.setFillBackgroundColor(IndexedColors.SEA_GREEN.getIndex());
            style.setFillPattern(FillPatternType.LESS_DOTS);
            
            //style2
	        CellStyle style2 = workbook.createCellStyle();
	        XSSFFont font2 = workbook.createFont();
			font2.setFontHeightInPoints((short) 10);
			font2.setFontName("New Roman");
			font2.setColor(IndexedColors.BLACK.getIndex());
	        style2.setFont(font2);
	        style2.setAlignment(HorizontalAlignment.LEFT);
	        
	        style2.setBorderBottom(BorderStyle.THIN);  
            style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style2.setBorderRight(BorderStyle.THIN);  
            style2.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderLeft(BorderStyle.THIN);  
            style2.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderTop(BorderStyle.THIN);  
            style2.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
	        
            
            //first row...
			XSSFSheet spreadsheet = workbook.createSheet(doctorName);
	        XSSFRow row;
	        int rowid = 0;
	        row = spreadsheet.createRow(rowid++);
	        Cell cc=row.createCell(0);cc.setCellValue(doctorName); cc.setCellStyle(style1);
	        spreadsheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
	        
	        //header...
	        row = spreadsheet.createRow(rowid++);
	        Cell c1=row.createCell(0);c1.setCellValue("    Date    ");    c1.setCellStyle(style); 
	        Cell c2=row.createCell(1);c2.setCellValue("   Pt-Name   ");   c2.setCellStyle(style);
	        Cell c3=row.createCell(2);c3.setCellValue("Full-Amt");        c3.setCellStyle(style);
	        Cell c4=row.createCell(3);c4.setCellValue("Paid-Amt");        c4.setCellStyle(style);
	        Cell c5=row.createCell(4);c5.setCellValue("Conc-Amt");        c5.setCellStyle(style);
	        Cell c6=row.createCell(5);c6.setCellValue("Collection");      c6.setCellStyle(style);
	        Cell c7=row.createCell(6);c7.setCellValue("Cut-Amt");         c7.setCellStyle(style);

	        for(int colNum = 0; colNum<row.getLastCellNum();colNum++)   
	            workbook.getSheetAt(0).autoSizeColumn(colNum);
	        
	        //////////////////////////////////////////////////////////////////////////////////
	        int paidAmount=0;
	        int cutAmount=0;
	        int fullAmount=0;
	        for (PathItems pi : pil) {
	        	
	        	//Calculation
	        	paidAmount=paidAmount+pi.getPaidAmount();
	        	cutAmount=cutAmount+pi.getCutAmount();
	        	fullAmount=fullAmount+pi.getFullAmount();
	        	PathItems.printItems(pi);
	            row = spreadsheet.createRow(rowid++);
                c1=row.createCell(0);c1.setCellValue(pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear());
	            c2=row.createCell(1);c2.setCellValue(pi.getPtName());
	            c3=row.createCell(2);c3.setCellValue(pi.getFullAmount());
	            c4=row.createCell(3);c4.setCellValue(pi.getPaidAmount());
	            c5=row.createCell(4);c5.setCellValue(pi.getConcAmount());
	            c6=row.createCell(5);c6.setCellValue(pi.getCollection());
	            c7=row.createCell(6);c7.setCellValue(pi.getCutAmount());
	            
	            c1.setCellStyle(style2);
	            c2.setCellStyle(style2);
	            c3.setCellStyle(style2);
	            c4.setCellStyle(style2);
	            c5.setCellStyle(style2);
	            c6.setCellStyle(style2);
	            c7.setCellStyle(style2);
	        }
	        
	        row = spreadsheet.createRow(rowid++);
	        c1=row.createCell(0);c1.setCellValue("");
            c2=row.createCell(1);c2.setCellValue("Total: ");
            c3=row.createCell(2);c3.setCellValue(fullAmount);
            c4=row.createCell(3);c4.setCellValue(paidAmount);
            c5=row.createCell(4);c5.setCellValue("");
            c6=row.createCell(5);c6.setCellValue("");
            c7=row.createCell(6);c7.setCellValue(cutAmount);
            c1.setCellStyle(style); 
            c2.setCellStyle(style); 
            c3.setCellStyle(style); 
            c4.setCellStyle(style); 
            c5.setCellStyle(style); 
            c6.setCellStyle(style); 
            c7.setCellStyle(style);
            return workbook;
	 }
    
    @SuppressWarnings("resource")
	public XSSFWorkbook generateReportMerge(XSSFSheet spreadsheet,XSSFWorkbook workbook,List<PathItems> pil,String doctorName) throws Exception 
    {
	        //style1
	        CellStyle style1 = workbook.createCellStyle();
	        XSSFFont font1 = workbook.createFont();
			font1.setFontHeightInPoints((short) 18);
			font1.setFontName("New Roman");
			font1.setBold(true);
			font1.setColor(IndexedColors.GREEN.getIndex());
	        style1.setFont(font1);
	        style1.setAlignment(HorizontalAlignment.CENTER);
	        
	        //style1
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName("New Roman");
			font.setBold(true);
			font.setColor(IndexedColors.WHITE.getIndex());
	        style.setFont(font);
	        style.setAlignment(HorizontalAlignment.CENTER);
	        
	        style.setBorderBottom(BorderStyle.THICK);  
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderRight(BorderStyle.THICK);  
            style.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style.setBorderLeft(BorderStyle.THICK);  
            style.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style.setBorderTop(BorderStyle.THICK);  
            style.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
            style.setFillBackgroundColor(IndexedColors.SEA_GREEN.getIndex());
            style.setFillPattern(FillPatternType.LESS_DOTS);
            
            //style2
	        CellStyle style2 = workbook.createCellStyle();
	        XSSFFont font2 = workbook.createFont();
			font2.setFontHeightInPoints((short) 10);
			font2.setFontName("New Roman");
			font2.setColor(IndexedColors.BLACK.getIndex());
	        style2.setFont(font2);
	        style2.setAlignment(HorizontalAlignment.LEFT);
	        
	        style2.setBorderBottom(BorderStyle.THIN);  
            style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style2.setBorderRight(BorderStyle.THIN);  
            style2.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderLeft(BorderStyle.THIN);  
            style2.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderTop(BorderStyle.THIN);  
            style2.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
	        
            
            //first row...
	        XSSFRow row;
	        int rowid = spreadsheet.getPhysicalNumberOfRows();
	        row = spreadsheet.createRow(rowid++);
	        Cell cc=row.createCell(0);cc.setCellValue(doctorName); cc.setCellStyle(style1);
	        spreadsheet.addMergedRegion(new CellRangeAddress(rowid-1,rowid-1,0,6));
	        
	        //header...
	        row = spreadsheet.createRow(rowid++);
	        Cell c1=row.createCell(0);c1.setCellValue("    Date    ");    c1.setCellStyle(style); 
	        Cell c2=row.createCell(1);c2.setCellValue("   Pt-Name   ");   c2.setCellStyle(style);
	        Cell c3=row.createCell(2);c3.setCellValue("Full-Amt");        c3.setCellStyle(style);
	        Cell c4=row.createCell(3);c4.setCellValue("Paid-Amt");        c4.setCellStyle(style);
	        Cell c5=row.createCell(4);c5.setCellValue("Conc-Amt");        c5.setCellStyle(style);
	        Cell c6=row.createCell(5);c6.setCellValue("Collection");      c6.setCellStyle(style);
	        Cell c7=row.createCell(6);c7.setCellValue("Cut-Amt");         c7.setCellStyle(style);

	        for(int colNum = 0; colNum<row.getLastCellNum();colNum++)   
	            workbook.getSheetAt(0).autoSizeColumn(colNum);
	        
	        //////////////////////////////////////////////////////////////////////////////////
	        int paidAmount=0;
	        int cutAmount=0;
	        int fullAmount=0;
	        for (PathItems pi : pil) {
	        	
	        	//Calculation
	        	paidAmount=paidAmount+pi.getPaidAmount();
	        	cutAmount=cutAmount+pi.getCutAmount();
	        	fullAmount=fullAmount+pi.getFullAmount();
	        	PathItems.printItems(pi);
	            row = spreadsheet.createRow(rowid++);
                c1=row.createCell(0);c1.setCellValue(pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear());
	            c2=row.createCell(1);c2.setCellValue(pi.getPtName());
	            c3=row.createCell(2);c3.setCellValue(pi.getFullAmount());
	            c4=row.createCell(3);c4.setCellValue(pi.getPaidAmount());
	            c5=row.createCell(4);c5.setCellValue(pi.getConcAmount());
	            c6=row.createCell(5);c6.setCellValue(pi.getCollection());
	            c7=row.createCell(6);c7.setCellValue(pi.getCutAmount());
	            
	            c1.setCellStyle(style2);
	            c2.setCellStyle(style2);
	            c3.setCellStyle(style2);
	            c4.setCellStyle(style2);
	            c5.setCellStyle(style2);
	            c6.setCellStyle(style2);
	            c7.setCellStyle(style2);
	        }
	        
	        row = spreadsheet.createRow(rowid++);
	        c1=row.createCell(0);c1.setCellValue("");
            c2=row.createCell(1);c2.setCellValue("Total: ");
            c3=row.createCell(2);c3.setCellValue(fullAmount);
            c4=row.createCell(3);c4.setCellValue(paidAmount);
            c5=row.createCell(4);c5.setCellValue("");
            c6=row.createCell(5);c6.setCellValue("");
            c7=row.createCell(6);c7.setCellValue(cutAmount);
            c1.setCellStyle(style); 
            c2.setCellStyle(style); 
            c3.setCellStyle(style); 
            c4.setCellStyle(style); 
            c5.setCellStyle(style); 
            c6.setCellStyle(style); 
            c7.setCellStyle(style);
            return workbook;
	 }
    
    
    @SuppressWarnings("resource")
   	public XSSFWorkbook generateReportForEachDay(XSSFWorkbook workbook,List<PathItems> pil,int day) throws Exception 
       {
   	        //style1
   	        CellStyle style1 = workbook.createCellStyle();
   	        XSSFFont font1 = workbook.createFont();
   			font1.setFontHeightInPoints((short) 18);
   			font1.setFontName("New Roman");
   			font1.setBold(true);
   			font1.setColor(IndexedColors.GREEN.getIndex());
   	        style1.setFont(font1);
   	        style1.setAlignment(HorizontalAlignment.CENTER);
   	        
   	        //style1
   	        CellStyle style = workbook.createCellStyle();
   	        XSSFFont font = workbook.createFont();
   			font.setFontHeightInPoints((short) 10);
   			font.setFontName("New Roman");
   			font.setBold(true);
   			font.setColor(IndexedColors.WHITE.getIndex());
   	        style.setFont(font);
   	        style.setAlignment(HorizontalAlignment.CENTER);
   	        
   	        style.setBorderBottom(BorderStyle.THICK);  
               style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
               style.setBorderRight(BorderStyle.THICK);  
               style.setRightBorderColor(IndexedColors.BLUE.getIndex());  
               style.setBorderLeft(BorderStyle.THICK);  
               style.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
               style.setBorderTop(BorderStyle.THICK);  
               style.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
               style.setFillBackgroundColor(IndexedColors.SEA_GREEN.getIndex());
               style.setFillPattern(FillPatternType.LESS_DOTS);
               
               //style2
   	        CellStyle style2 = workbook.createCellStyle();
   	        XSSFFont font2 = workbook.createFont();
   			font2.setFontHeightInPoints((short) 10);
   			font2.setFontName("New Roman");
   			font2.setColor(IndexedColors.BLACK.getIndex());
   	        style2.setFont(font2);
   	        style2.setAlignment(HorizontalAlignment.LEFT);
   	        
   	        style2.setBorderBottom(BorderStyle.THIN);  
            style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style2.setBorderRight(BorderStyle.THIN);  
            style2.setRightBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderLeft(BorderStyle.THIN);  
            style2.setLeftBorderColor(IndexedColors.BLUE.getIndex());  
            style2.setBorderTop(BorderStyle.THIN);  
            style2.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
   	      
               //first row...
   			XSSFSheet spreadsheet = workbook.createSheet("Day-"+day);
   	        XSSFRow row;
   	        int rowid = 0;
   	        row = spreadsheet.createRow(rowid++);
   	        Cell cc=row.createCell(0);cc.setCellValue(day+"-"+ComboBox.combobox1.getSelectedItem().toString()+"-"+Integer.parseInt(Text.t8.getText().toString())); cc.setCellStyle(style1);
   	        spreadsheet.addMergedRegion(new CellRangeAddress(0,0,0,7));

   	        //header...
   	        row = spreadsheet.createRow(rowid++);
   	        Cell c1=row.createCell(0);c1.setCellValue("    Date    ");    c1.setCellStyle(style); 
   	        Cell c2=row.createCell(1);c2.setCellValue("   Pt-Name   ");   c2.setCellStyle(style);
   	        Cell c3=row.createCell(2);c3.setCellValue("Full-Amt");        c3.setCellStyle(style);
   	        Cell c4=row.createCell(3);c4.setCellValue("Paid-Amt");        c4.setCellStyle(style);
   	        Cell c5=row.createCell(4);c5.setCellValue("Conc-Amt");        c5.setCellStyle(style);
   	        Cell c6=row.createCell(5);c6.setCellValue("Collection");      c6.setCellStyle(style);
   	        Cell c7=row.createCell(6);c7.setCellValue("Cut-Amt");         c7.setCellStyle(style);
   	        Cell c8=row.createCell(7);c8.setCellValue("Doctor's Name ");  c8.setCellStyle(style);

   	        for(int colNum = 0; colNum<row.getLastCellNum();colNum++)   
   	            workbook.getSheetAt(0).autoSizeColumn(colNum);
   	        
   	        //////////////////////////////////////////////////////////////////////////////////
   	        int paidAmount=0;
   	        int cutAmount=0;
   	        int fullAmount=0;
   	        for (PathItems pi : pil) {
   	        	
   	        	//Calculation
   	        	paidAmount=paidAmount+pi.getPaidAmount();
   	        	cutAmount=cutAmount+pi.getCutAmount();
   	        	fullAmount=fullAmount+pi.getFullAmount();
   	        	PathItems.printItems(pi);
   	            row = spreadsheet.createRow(rowid++);
                c1=row.createCell(0);c1.setCellValue(pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear());
   	            c2=row.createCell(1);c2.setCellValue(pi.getPtName());
   	            c3=row.createCell(2);c3.setCellValue(pi.getFullAmount());
   	            c4=row.createCell(3);c4.setCellValue(pi.getPaidAmount());
   	            c5=row.createCell(4);c5.setCellValue(pi.getConcAmount());
   	            c6=row.createCell(5);c6.setCellValue(pi.getCollection());
   	            c7=row.createCell(6);c7.setCellValue(pi.getCutAmount());
   	            c8=row.createCell(7);c8.setCellValue(pi.getDoctorName());
   	         
   	            c1.setCellStyle(style2);
   	            c2.setCellStyle(style2);
   	            c3.setCellStyle(style2);
   	            c4.setCellStyle(style2);
   	            c5.setCellStyle(style2);
   	            c6.setCellStyle(style2);
   	            c7.setCellStyle(style2);
   	        }
   	        
   	        row = spreadsheet.createRow(rowid++);
   	        c1=row.createCell(0);c1.setCellValue("");
               c2=row.createCell(1);c2.setCellValue("Total: ");
               c3=row.createCell(2);c3.setCellValue(fullAmount);
               c4=row.createCell(3);c4.setCellValue(paidAmount);
               c5=row.createCell(4);c5.setCellValue("");
               c6=row.createCell(5);c6.setCellValue("");
               c7=row.createCell(6);c7.setCellValue(cutAmount);
               c8=row.createCell(7);c8.setCellValue("");
               c1.setCellStyle(style); 
               c2.setCellStyle(style); 
               c3.setCellStyle(style); 
               c4.setCellStyle(style); 
               c5.setCellStyle(style); 
               c6.setCellStyle(style); 
               c7.setCellStyle(style);
               c8.setCellStyle(style);
               return workbook;
   	 }
}
