package ViewLayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Base.MonthProperties;
import DBManager.ConnectToDB_H;
import DBManager.ReadItemsFromDB;
import DBManager.WriteInItemsToDB;
import ExcelManager.PathItems;

public class Table {
	static JTable  t0;
	static DefaultTableModel model ;
	public JTable getTable() {
		return t0;
	}
	
	public JPanel addTable(JPanel jp) {
		  System.out.println("adding table...");
		  t0=new JTable() {
			  public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
			        Component returnComp = super.prepareRenderer(renderer, row, column);
			        Color alternateColor = new Color(199,199,199);
			        Color whiteColor = Color.WHITE;
			        if (!returnComp.getBackground().equals(getSelectionBackground())){
			            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
			            returnComp .setBackground(bg);
			            bg = null;
			        }
			        return returnComp;
			  }
		  };
		  addTableHeader();
		  t0.setPreferredScrollableViewportSize(t0.getPreferredSize());
		  t0.setRowHeight(22);
		  t0.setFont(new Font("Consolas", Font.PLAIN, 17));
		  //t0.setForeground(Color.BLUE);
		  t0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		  JScrollPane pane = new JScrollPane(t0);
	      pane.setPreferredSize(new Dimension(980, 460));
	      jp.setOpaque(true);
		  jp.add(pane);
		  return jp;
	  }
	  
	  public void  addTableHeader() {
	        model = (DefaultTableModel) t0.getModel();
	        Object[] newIdentifiers = new Object[]{"Key","Date","Patient-Name","Full-Amount",
			"Paid-Amount","Conc-Amount","Coll-Amount","Cut-Amount","Doctor's-Name "};
	        model.setColumnIdentifiers(newIdentifiers);
	       TableColumnModel columnModel = t0.getColumnModel();
	        columnModel.getColumn(0).setPreferredWidth(5);
	        columnModel.getColumn(1).setPreferredWidth(40);
	        columnModel.getColumn(2).setPreferredWidth(100);
	        columnModel.getColumn(3).setPreferredWidth(30);
	        columnModel.getColumn(4).setPreferredWidth(30);
	        columnModel.getColumn(5).setPreferredWidth(30);
	        columnModel.getColumn(6).setPreferredWidth(30);
	        columnModel.getColumn(7).setPreferredWidth(30);
	        columnModel.getColumn(8).setPreferredWidth(100);
	   }
	  
	  public JPanel addTableToPanel1(JPanel jp){
		   return this.addTable(jp);
	   }
	  
	  // Add Items 
	  public void addRow(PathItems pi) {
		  model = (DefaultTableModel) t0.getModel();
		  model.addRow(new Object[]{pi.getIndex(),pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear(),pi.getPtName(),pi.getFullAmount(),pi.getPaidAmount(),pi.getConcAmount(),pi.getCollectionAmount(),pi.getCutAmount(),pi.getDoctorName()});  
		  
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
			  model = (DefaultTableModel) t0.getModel();
			  model.addRow(new Object[]{pi.getIndex(),pi.getDay()+"-"+pi.getMonth()+"-"+pi.getYear(),pi.getPtName(),pi.getFullAmount(),pi.getPaidAmount(),pi.getConcAmount(),pi.getCollectionAmount(),pi.getCutAmount(),pi.getDoctorName()}); 
			  
			  PathItems.printItems(pi);
	  }
	  
	  // load Calculation
	  public void loadCalculation(int fullAmount,int paidAmount,int concAmount,int collectionAmount,int cutAmount) {
				  model = (DefaultTableModel) t0.getModel();
				  model.addRow(new Object[]{"","","Total: ",fullAmount,paidAmount,concAmount,collectionAmount,cutAmount,""});  
	  }
	  	 
	  // Delete Items
	   public void deleteSelectedRowFromJtable(PathItems pi) {    
	        int getSelectedRowForDeletion = t0.getSelectedRow();

	        if (getSelectedRowForDeletion >= 0) {
	        	
	        	PathItems.printItems(pi);
	            /////////////////////////////////////////////////////
	            ConnectToDB_H ctdh=new ConnectToDB_H();
	            WriteInItemsToDB wittd=new WriteInItemsToDB(ctdh);
	            wittd.delete(pi);
	            /////////////////////////////////////////////////////
	            model.removeRow(getSelectedRowForDeletion);
	            JOptionPane.showMessageDialog(null, "Entry is Deleted");
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a Entry");
	        }
	  }
	   
	   // Update Items
	   public void updateSelectedRowFromJtable(PathItems pi) {    
	        int getSelectedRowForDeletion = t0.getSelectedRow();
	        if (getSelectedRowForDeletion >= 0) {
	        	PathItems.printItems(pi);
	            /////////////////////////////////////////////////////
	            ConnectToDB_H ctdh=new ConnectToDB_H();
	            WriteInItemsToDB wittd=new WriteInItemsToDB(ctdh);
	            wittd.update(pi);
	            wittd.evict(pi);
	            /////////////////////////////////////////////////////
	            
	            JOptionPane.showMessageDialog(null, "Entry is Updated");
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a Entry");
	        }
	  }
	   
	   public void loadTable() {
		   int fullAmount=0;
		   int paidAmount=0;
		   int concAmount=0;
		   int collectionAmount=0;
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
			   collectionAmount=collectionAmount+pi.getCollectionAmount();
			   cutAmount=cutAmount+pi.getCutAmount();
		   }
		   loadCalculation(fullAmount,paidAmount,concAmount,collectionAmount,cutAmount);
		   
		   TextArea ta=new TextArea();
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
			   int collectionAmount=0;
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
			   collectionAmount=collectionAmount+pi.getCollectionAmount();
			   cutAmount=cutAmount+pi.getCutAmount();
		   }
		   loadCalculation(fullAmount,paidAmount,concAmount,collectionAmount,cutAmount);
		   TextArea ta=new TextArea();
		   ta.setTextArea(paidAmount, cutAmount);
		   }
	   }
	   
	   public void removeAllRow() {
		   int rowCount = model.getRowCount();
		   for (int i = rowCount - 1; i >= 0; i--) {
		       model.removeRow(i);
		   }
	   }
}
