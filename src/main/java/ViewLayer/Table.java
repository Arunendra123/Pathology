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
	public static JTable  t0;
	public static DefaultTableModel model ;
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
		  t0.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		  JScrollPane pane = new JScrollPane(t0);
	      pane.setPreferredSize(new Dimension(980, 460));
	      jp.setOpaque(true);
		  jp.add(pane);
		  return jp;
	  }
	  
	  public void  addTableHeader() {
	        model = (DefaultTableModel) t0.getModel();
	        Object[] newIdentifiers = new Object[]{"Key","Date","Patient-Name","Full-Amount",
			"Paid-Amount","Conc-Amount","Collection","Cut-Amount","Doctor's-Name "};
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
}
