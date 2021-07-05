package Operations;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Base.MonthProperties;
import DBManager.ConnectToDB_H;
import DBManager.ReadItemsFromDB;
import DBManager.WriteInItemsToDB;
import ExcelManager.PathItems;
import ViewLayer.ComboBox;
import ViewLayer.Text;
import ViewLayer.TextArea;
import ViewLayer.Table;

public class TableOperations {
	 // Add Items 
	  public void addRow(PathItems pi) {
		  Table.model = (DefaultTableModel) Table.t0.getModel();
		  Table.model.addRow(new Object[]{pi.getIndex(),pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear(),pi.getPtName(),pi.getFullAmount(),pi.getPaidAmount(),pi.getConcAmount(),pi.getCollection(),pi.getCutAmount(),pi.getDoctorName()});  
		  
		  PathItems.printItems(pi);////////////////////////////////////////////////////////
		  ConnectToDB_H ctdh=new ConnectToDB_H();
		  WriteInItemsToDB wittd=new WriteInItemsToDB(ctdh);
		  wittd.insert(pi);
		  wittd.evict(pi);
		  ///////////////////////////////////////////////////////
		  //JOptionPane.showMessageDialog(null, "Entry is Added");
	  }
	  
	  // load Items 
	  public void loadRow(PathItems pi) {
		  Table.model = (DefaultTableModel) Table.t0.getModel();
		  Table.model.addRow(new Object[]{pi.getIndex(),pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear(),pi.getPtName(),pi.getFullAmount(),pi.getPaidAmount(),pi.getConcAmount(),pi.getCollection(),pi.getCutAmount(),pi.getDoctorName()}); 
		  PathItems.printItems(pi);
	  }
	  
	  // load Calculation
	  public void loadCalculation(int fullAmount,int paidAmount,int concAmount,int cutAmount) {
		  Table.model = (DefaultTableModel) Table.t0.getModel();
		  Table.model.addRow(new Object[]{"","","Total: ",fullAmount,paidAmount,concAmount,"",cutAmount,""});  
	  }
	  	 
	  // Delete Items
	   public void deleteSelectedRowFromJtable(PathItems pi) {    
	        int getSelectedRowForDeletion = Table.t0.getSelectedRow();

	        if (getSelectedRowForDeletion >= 0) {
	        	
	        	PathItems.printItems(pi);
	            /////////////////////////////////////////////////////
	            ConnectToDB_H ctdh=new ConnectToDB_H();
	            WriteInItemsToDB wittd=new WriteInItemsToDB(ctdh);
	            wittd.delete(pi);
	            /////////////////////////////////////////////////////
	            Table.model.removeRow(getSelectedRowForDeletion);
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a Entry");
	        }
	  }
	   
	   // Update Items
	   public void updateSelectedRowFromJtable(PathItems pi) {    
	        int getSelectedRowForDeletion = Table.t0.getSelectedRow();
	        if (getSelectedRowForDeletion >= 0) {
	        	PathItems.printItems(pi);
	            /////////////////////////////////////////////////////
	            ConnectToDB_H ctdh=new ConnectToDB_H();
	            WriteInItemsToDB wittd=new WriteInItemsToDB(ctdh);
	            wittd.update(pi);
	            wittd.evict(pi);
	            /////////////////////////////////////////////////////
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a Entry");
	        }
	  }
	   
	   public void loadTable() {
		   int fullAmount=0;
		   int paidAmount=0;
		   int concAmount=0;
		   int cutAmount=0;
		   /////////////////////////////
		   ConnectToDB_H ctdh=new ConnectToDB_H();
		   ReadItemsFromDB rifb=new ReadItemsFromDB(ctdh);
		   List<PathItems> pathItems=new ArrayList<PathItems>();
		   MonthProperties mp=new MonthProperties();
		   System.out.println(ComboBox.combobox1.getSelectedItem().toString());
		   pathItems=rifb.getItemList("FROM PathItems P WHERE P.month = :month and P.year = :year",mp.getMonth(ComboBox.combobox1.getSelectedItem().toString()),Integer.parseInt(Text.t8.getText().toString()));
		   /////////////////////////////
		   for(PathItems pi:pathItems) {
			   loadRow(pi);
			   fullAmount=fullAmount+pi.getFullAmount();
			   paidAmount=paidAmount+pi.getPaidAmount();
			   concAmount=concAmount+pi.getConcAmount();
			   cutAmount=cutAmount+pi.getCutAmount();
		   }
		   loadCalculation(fullAmount,paidAmount,concAmount,cutAmount);
		   
		   TextAreaOperations ta=new TextAreaOperations();
		   ta.setTextArea(paidAmount, cutAmount);
	   }
	   
	   public void loadTableForDoctor() {
		   if(ComboBox.combobox.getSelectedItem().toString().equals("All")) {
			   removeAllRow();
			   loadTable();
		   }else {
			   int fullAmount=0;
			   int paidAmount=0;
			   int concAmount=0;
			   int cutAmount=0;
		   /////////////////////////////
		   ConnectToDB_H ctdh=new ConnectToDB_H();
		   ReadItemsFromDB rifb=new ReadItemsFromDB(ctdh);
		   List<PathItems> pathItems=new ArrayList<PathItems>();
		   MonthProperties mp=new MonthProperties();
		   pathItems=rifb.getItemList("FROM PathItems P WHERE P.doctorName = :doctorName and P.month = :month and P.year = :year",ComboBox.combobox.getSelectedItem().toString(),mp.getMonth(ComboBox.combobox1.getSelectedItem().toString()),Integer.parseInt(Text.t8.getText().toString()));
		   /////////////////////////////
		   removeAllRow();
		   for(PathItems pi:pathItems) {
			   loadRow(pi);
			   fullAmount=fullAmount+pi.getFullAmount();
			   paidAmount=paidAmount+pi.getPaidAmount();
			   concAmount=concAmount+pi.getConcAmount();
			   cutAmount=cutAmount+pi.getCutAmount();
		   }
		   loadCalculation(fullAmount,paidAmount,concAmount,cutAmount);
		   TextAreaOperations ta=new TextAreaOperations();
		   ta.setTextArea(paidAmount, cutAmount);
		 }
	   }
	   
	   public List<PathItems> getTableForDoctor(String doctorName,int month,int year) {
	    	if(doctorName.equals("All")) {
	                  /////////////////////////////
	                  ConnectToDB_H ctdh=new ConnectToDB_H();
	                  ReadItemsFromDB rifb=new ReadItemsFromDB(ctdh);
	                  List<PathItems> pathItems=new ArrayList<PathItems>();
	                  pathItems=rifb.getItemList("FROM PathItems P WHERE P.month = :month and P.year = :year",month,year);
	                  /////////////////////////////
	                  return pathItems;
	    	}else {
			           /////////////////////////////
			           ConnectToDB_H ctdh=new ConnectToDB_H();
			           ReadItemsFromDB rifb=new ReadItemsFromDB(ctdh);
			           List<PathItems> pathItems=new ArrayList<PathItems>();
			           pathItems=rifb.getItemList("FROM PathItems P WHERE P.doctorName = :doctorName and P.month = :month and P.year = :year",doctorName,month,year);
			           /////////////////////////////
			           return pathItems;
	    	}
		}
	    
	    public List<PathItems> getTableForDay(int day,int month,int year) {
	                  /////////////////////////////
	                  ConnectToDB_H ctdh=new ConnectToDB_H();
	                  ReadItemsFromDB rifb=new ReadItemsFromDB(ctdh);
	                  List<PathItems> pathItems=new ArrayList<PathItems>();
	                  pathItems=rifb.getItemList("FROM PathItems P WHERE P.month = :month and P.year = :year and P.day = :day",month,year,day);
	                  /////////////////////////////
	                  return pathItems;
		}
	   
	   public void removeAllRow() {
		   int rowCount = Table.model.getRowCount();
		   for (int i = rowCount - 1; i >= 0; i--) {
			   Table.model.removeRow(i);
		   }
	   }
}
