package ExcelReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.BaseFileReader;
import Base.MonthProperties;
import Base.PathHandler;
import DBManager.ConnectToDB_H;
import DBManager.ReadItemsFromDB;
import ExcelManager.PathItems;
import ExcelManager.Writer;
import LogManager.LogWriter;
import Operations.TableOperations;
import ViewLayer.ComboBox;
import ViewLayer.Text;

public class MonthlyReport {
	int month;
	int year;
	ConnectToDB_H ctdb;
	
    public MonthlyReport(int month,int year){
	      this.month=month;
	      this.year=year;
    }
    
    public MonthlyReport(){
	   
    }
    
    public List<PathItems> getTableForDoctor(String doctorName) {
    	TableOperations to=new TableOperations();
        return to.getTableForDoctor(doctorName, this.month, this.year);
	}
    
    public List<PathItems> getTableForDay(int day) {
                  TableOperations to=new TableOperations();
                  return to.getTableForDay(day, this.month, this.year);
	}

    public void generateMonthlyReport() {
    	MonthProperties mp=new MonthProperties();
    	MonthlyReport mr= new MonthlyReport(mp.getMonth(ComboBox.combobox1.getSelectedItem().toString()),Integer.parseInt(Text.t8.getText().toString()));
    	BaseFileReader bf=new BaseFileReader(new PathHandler("doctorList","resources"));
   
    	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	Writer wr=new Writer();
    	Writer wr1=new Writer();
    	wr1.setPath(new PathHandler(ComboBox.combobox1.getSelectedItem().toString()+"-Main-Report"+".xlsx","monthly-"+ComboBox.combobox1.getSelectedItem().toString()+"-Report-B"));
        Writer wr2=new Writer();
    	wr2.setPath(new PathHandler(ComboBox.combobox1.getSelectedItem().toString()+"-Merge-Report"+".xlsx","monthly-"+ComboBox.combobox1.getSelectedItem().toString()+"-Report-B"));

    	XSSFWorkbook workbook1=new XSSFWorkbook();
    	XSSFWorkbook workbook2=new XSSFWorkbook();
    	XSSFSheet spreadsheet2=workbook2.createSheet("Maa Vindhyavasini cut report");
    	    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////Indidual
	    List<String> listOfLines=bf.getList();
    	for(String doctorName: listOfLines) {
    		System.out.println("Doctor Name: "+doctorName);
    		try {
    			          List<PathItems> tmpList=mr.getTableForDoctor(doctorName);
    			          if(tmpList.size()==0) {
    			        	  continue;
    			          }
    			          wr.setPath(new PathHandler(ComboBox.combobox1.getSelectedItem().toString()+"-"+doctorName+"-Report"+".xlsx","monthly-"+ComboBox.combobox1.getSelectedItem().toString()+"-Report-A"));
				          wr.generateReport(tmpList,doctorName);
				workbook1=wr1.generateReportInOne(workbook1,tmpList,doctorName);
    		    workbook2=wr2.generateReportMerge(spreadsheet2,workbook2,tmpList,doctorName);
				System.out.print("...");
			} catch (Exception e) {
				LogWriter.WriteLogs("Class:MonthlyReport,Method:generateMonthlyReport"+e);
			}
    	}
    	
    	try 
    	{
			workbook1.write(wr1.getOut());
			workbook1.close();
			wr1.getOut().close();
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			workbook2.write(wr2.getOut());
			workbook2.close();
			wr2.getOut().close();
		} catch (IOException e) {
			LogWriter.WriteLogs("Class:MonthlyReport,Method:generateMonthlyReport"+e);
		}
    	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
    
    public void generateDailyReport() {
    	MonthProperties mp=new MonthProperties();
    	MonthlyReport mr= new MonthlyReport(mp.getMonth(ComboBox.combobox1.getSelectedItem().toString()),Integer.parseInt(Text.t8.getText().toString()));

    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	Writer wr3=new Writer();
    	wr3.setPath(new PathHandler(ComboBox.combobox1.getSelectedItem().toString()+"-Each-Day-Report"+".xlsx","monthly-"+ComboBox.combobox1.getSelectedItem().toString()+"-Report-B"));
        XSSFWorkbook workbook3=new XSSFWorkbook();
    	for(int i=1;i<=31;i++) {
    		List<PathItems> tmpList=mr.getTableForDay(i);
    		try {
    			if(tmpList.size()!=0) 
    			{
    			     workbook3=wr3.generateReportForEachDay(workbook3,tmpList,i);
    			}
			} catch (Exception e) {
				LogWriter.WriteLogs("Class:MonthlyReport,Method:generateDailyReport"+e);
			}
    	}
    	
    	try 
    	{
			workbook3.write(wr3.getOut());
			workbook3.close();
			wr3.getOut().close();
		} catch (IOException e) {
			LogWriter.WriteLogs("Class:MonthlyReport,Method:generateDailyReport"+e);
		}
    	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
