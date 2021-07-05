package ViewLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Base.BaseFileWriter;
import Base.PathHandler;
import ExcelManager.PathItems;
import ExcelReport.MonthlyReport;
import LogManager.LogWriter;
import Operations.TableOperations;
import Operations.TextOperations;

public class Button extends LogWriter{
	static JButton b0,b1,b2,b3,b4,b5,b10,b11,b12,b13;
	public JButton getButton(String str) {
		
		JButton b=new JButton (str);
		b.setPreferredSize(new Dimension(100,20));
		b.setAlignmentX(JButton.LEFT_ALIGNMENT);

		//Delete Items
		if(str.equals("Delete")) {
		b.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  int input = JOptionPane.showConfirmDialog(null, "Are you sure?");
				  if(input==0) {
					  TableOperations t=new TableOperations();
					  PathItems pi=new PathItems();
					  int SelectedRow= Table.t0.getSelectedRow();
					  pi=PathItemsMaper.mapItemsFromTable_1(pi,SelectedRow);
					  t.deleteSelectedRowFromJtable(pi);
					  LogWriter.WriteLogs("Deleted: "+PathItems.getStringForItems(pi));
					  t.removeAllRow();
					  t.loadTable();
					  JOptionPane.showMessageDialog(null, "Entry is Deleted");
				  }
			  }
		} );
		}
		
		//Update Items
		if(str.equals("Update")) {
		b.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				  if(PathItemsMaper.validateTableFields()) {
					     TableOperations t=new TableOperations();
						  PathItems pi=new PathItems();
						  int SelectedRows[] = Table.t0.getSelectedRows();
						  for(int SelectedRow:SelectedRows) {
							  pi=PathItemsMaper.mapItemsFromTable_1(pi,SelectedRow);
							  t.updateSelectedRowFromJtable(pi);
							  LogWriter.WriteLogs("Updated: "+PathItems.getStringForItems(pi));
						  }
						  t.removeAllRow();
						  t.loadTable();
						  JOptionPane.showMessageDialog(null, "Entries are Updated");
						 }
					  } 
				} );
		}
		
		//Insert Items
		if(str.equals("Insert")) {
			b.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  if(PathItemsMaper.validateTextFields()) {
						  TableOperations t=new TableOperations();
						  TextOperations txt=new TextOperations();
						  PathItems pi=new PathItems();
						  pi=PathItemsMaper.mapItemsFromTextBox(pi);
						  t.addRow(pi);
						  LogWriter.WriteLogs("Inserted: "+PathItems.getStringForItems(pi));
						  txt.SetTextFieldAfterInsert();
						  t.removeAllRow();
						  t.loadTable();
					  }
				  } 
			} );
		}
		
		//Insert Items
		if(str.equals("Add Doctor's Name")) {
			b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent e) { 
				 BaseFileWriter  bfw=new BaseFileWriter(new PathHandler("doctorList","resources"));  
				 bfw.writeFromTextArea(TextArea.ta1);
				 JOptionPane.showMessageDialog(null, "Doctor name added to list. Please exit and open the app again");
			 } 
		} );
		}
		
		//Insert Items
		if(str.equals("Load Table")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 TableOperations t=new TableOperations();
				 t.loadTableForDoctor();
			 } 
		} );
		}
		
		//Print Items
		if(str.equals("Print")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 PrintComponent pc=new PrintComponent();
				 pc.printComponenet(Frame.p1);
				
			} 
		} );
		}
		
		//Generate Report
		if(str.equals("Generate Monthly Report")) {
			b.addActionListener(new ActionListener() {
			 @SuppressWarnings("unchecked")
			 public void actionPerformed(ActionEvent e) { 
			 MonthlyReport mr=new MonthlyReport();
			 mr.generateMonthlyReport();
			 JOptionPane.showMessageDialog(null, "Reports generated");
			 
		} 
	    } );
		}
		
		//Generate Report
		if(str.equals("Generate Daily Report")) {
					b.addActionListener(new ActionListener() {
					 @SuppressWarnings("unchecked")
					 public void actionPerformed(ActionEvent e) { 
					 MonthlyReport mr=new MonthlyReport();
					 mr.generateDailyReport();
					 JOptionPane.showMessageDialog(null, "Reports generated");
					 
		} 
	    } );
		}
				
		//Print Items
		if(str.equals("CUT")) {
			b.addActionListener(new ActionListener() { 
				  @SuppressWarnings("unchecked")
				  public void actionPerformed(ActionEvent e) { 
				  TextOperations tx=new TextOperations();
				  if(ComboBox.combobox3.getSelectedItem().toString().equals("CUT")) {
					    tx.SetCutAmount();
			      }else {
					    tx.SetCutAmount(Integer.parseInt(ComboBox.combobox3.getSelectedItem().toString()));
				  }
			  } 
			});	
		}
		
		
		//Print Items
		if(str.equals("Add")) {
			b.addActionListener(new ActionListener() { 
				   @SuppressWarnings("unchecked")
				   public void actionPerformed(ActionEvent e) { 
			       String str=Text.t5.getText().toString();
			       str=str.equals("")?ComboBox.combobox2.getSelectedItem().toString():str+","+ComboBox.combobox2.getSelectedItem().toString();
			       Text.t5.setText(str);
			    } 
			});	
		}
				
		return b;
	}
	
	public JPanel addButtonToPanelInsert0(JPanel jp) {		
		  b0=this.getButton("Insert");
		  b0. setPreferredSize(new Dimension(120,25));		  
		  Color color1 = new Color(60,179,113);
		  b0.setBackground(color1);		  
		  jp.add(b0);
		  return jp;
	}
	
	public JPanel addButtonToPanelCUT0(JPanel jp) {
		  b11=this.getButton("CUT");
		  b11.setPreferredSize(new Dimension(60,18));		  
		  jp.add(b11);
		  return jp;
	}
	
	public JPanel addButtonToPanelAdd0(JPanel jp) {
		  b13=this.getButton("Add");
		  b13.setPreferredSize(new Dimension(60,18));
		  jp.add(b13);
		  return jp;
	}
	
	public JPanel addButtonToPanel3(JPanel jp) {
		  b3=this.getButton("Add Doctor's Name");
		  b3.setPreferredSize(new Dimension(150,20));
		  jp.add(b3);
		  return jp;
	}
	
	public JPanel addButtonToPanel1(JPanel jp) {
		/*
		 * b12=this.getButton("Print"); b12.setPreferredSize(new Dimension(100,20));
		 * jp.add(b12);
		 */
		  
		  b1=this.getButton("Update");
		  b2=this.getButton("Delete");
		  b5=this.getButton("Load Table");
		  
		  b1.setPreferredSize(new Dimension(100,18));
		  b2.setPreferredSize(new Dimension(100,18));
		  b5.setPreferredSize(new Dimension(100,18));
		  
		  Color color2 = new Color(240,128,128);
		  Color color3 = new Color(255,215,0);
		  
		  b2.setBackground(color2);
		  b5.setBackground(color3);
		  
		  jp.add(b2);
		  jp.add(b1); 
		  jp.add(b5);
		  
		  return jp;
	}
	
	public JPanel addButtonToPanel33(JPanel jp) {
		  b4=this.getButton("Generate Monthly Report");
		  b4.setPreferredSize(new Dimension(170,16));
		  b10=this.getButton("Generate Daily Report");
		  b10.setPreferredSize(new Dimension(170,16));
		  jp.add(b4);
		  jp.add(b10);
		  return jp;
	}
}
