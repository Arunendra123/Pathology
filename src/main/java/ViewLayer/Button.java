package ViewLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Base.BaseFileWriter;
import Base.MonthlyReport;
import Base.PathHandler;
import ExcelManager.PathItems;
import LogManager.LogWriter;


public class Button extends LogWriter{
	static JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
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
					  Table t=new Table();
					  PathItems pi=new PathItems();
					  pi=PathItemsMaper.mapItemsFromTable(pi);
					  t.deleteSelectedRowFromJtable(pi);
					  LogWriter.WriteLogs("Deleted: "+PathItems.getStringForItems(pi));
					  TextArea.ta2.append("Deleted Entry- PTName: "+pi.getPtName()+", DoctorName:"+pi.getDoctorName()+"\n");
				  }
			  } 
		} );
		}
		
		//Update Items
		if(str.equals("Update")) {
		b.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				  if(PathItemsMaper.validateTableFields()) {
						  Table t=new Table();
						  PathItems pi=new PathItems();
						  pi=PathItemsMaper.mapItemsFromTable(pi);
						  t.updateSelectedRowFromJtable(pi);
						  LogWriter.WriteLogs("Updated: "+PathItems.getStringForItems(pi));
						  TextArea.ta2.append("Updated Entry- PTName: "+pi.getPtName()+", DoctorName:"+pi.getDoctorName()+"\n");
						  }
					  } 
				} );
		}
		
		//Insert Items
		if(str.equals("Insert")) {
			b.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  if(PathItemsMaper.validateTextFields()) {
						  Table t=new Table();
						  Text txt=new Text();
						  PathItems pi=new PathItems();
						  pi=PathItemsMaper.mapItemsFromTextBox(pi);
						  t.addRow(pi);
						  LogWriter.WriteLogs("Inserted: "+PathItems.getStringForItems(pi));
						  TextArea.ta2.append("Inserted Entry- PTName: "+pi.getPtName()+", DoctorName:"+pi.getDoctorName()+"\n");
						  txt.SetTextFieldAfterInsert();
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
				 TextArea.ta2.append("Doctor's Name added. Please re-open app\n");
			 } 
		} );
		}
		
		//Insert Items
		if(str.equals("Load Table")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 Table t=new Table();
				 t.loadTableForDoctor();
				 TextArea.ta2.append("Table has been loaded\n");
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
				 TextArea.ta2.append("Printing Documents.\n");
			} 
		} );
		}
		
		//Generate Report
		if(str.equals("Generate Monthly Report")) {
			b.addActionListener(new ActionListener() {
			 @SuppressWarnings("unchecked")
			 public void actionPerformed(ActionEvent e) { 
			 TextArea.ta2.append("Generating Reports...\n");
			 MonthlyReport mr=new MonthlyReport();
			 mr.generateMonthlyReport();
			 JOptionPane.showMessageDialog(null, "Reports generated");
			 TextArea.ta2.append("Reports generated\n");
		} 
	    } );
		}
		
		//Generate Report
		if(str.equals("Generate Daily Report")) {
					b.addActionListener(new ActionListener() {
					 @SuppressWarnings("unchecked")
					 public void actionPerformed(ActionEvent e) { 
					 TextArea.ta2.append("Generating Reports...\n");
					 MonthlyReport mr=new MonthlyReport();
					 mr.generateDailyReport();
					 JOptionPane.showMessageDialog(null, "Reports generated");
					 TextArea.ta2.append("Reports generated\n");
		} 
	    } );
		}
		
	       //Print Items
		if(str.equals("30%")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 Text tx=new Text();
				 tx.SetCutAmount(30);
			} 
		} );
		}
		
		//Print Items
		if(str.equals("40%")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 Text tx=new Text();
				 tx.SetCutAmount(40);
			} 
		} );
		}
		
		//Print Items
		if(str.equals("50%")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 Text tx=new Text();
				 tx.SetCutAmount(50);
			} 
		} );
		}
		
		//Print Items
		if(str.equals("60%")) {
				b.addActionListener(new ActionListener() { 
				 @SuppressWarnings("unchecked")
				 public void actionPerformed(ActionEvent e) { 
				 Text tx=new Text();
			     tx.SetCutAmount(60);
			} 
		} );
		}
		
		//Print Items
		if(str.equals("CUT")) {
				b.addActionListener(new ActionListener() { 
			    @SuppressWarnings("unchecked")
			    public void actionPerformed(ActionEvent e) { 
				Text tx=new Text();
				tx.SetCutAmount();
			} 
		} );
		}
		return b;
	}
	
	public JPanel addButtonToPanel0(JPanel jp) {
		  b0=this.getButton("Insert");
		  b1=this.getButton("Update");
		  b2=this.getButton("Delete");
		  b5=this.getButton("Load Table");
		  b6=this.getButton("60%");
		  b7=this.getButton("50%");
		  b8=this.getButton("40%");
		  b9=this.getButton("30%");
		  b11=this.getButton("CUT");
		  b6.setPreferredSize(new Dimension(60,20));
		  b7.setPreferredSize(new Dimension(60,20));
		  b8.setPreferredSize(new Dimension(60,20));
		  b9.setPreferredSize(new Dimension(60,20));
		  b11.setPreferredSize(new Dimension(60,20));
		  Color color1 = new Color(60,179,113);
		  Color color2 = new Color(240,128,128);
		  Color color3 = new Color(255,215,0);
		  b0.setBackground(color1);
		  b2.setBackground(color2);
		  b5.setBackground(color3);
		  jp.add(b0);
		  jp.add(b1);
		  jp.add(b2);
		  jp.add(b5);
		  jp.add(b11);
		  jp.add(b6);
		  jp.add(b7);
		  jp.add(b8);
		  jp.add(b9);
		  return jp;
	}
	
	public JPanel addButtonToPanel3(JPanel jp) {
		  b3=this.getButton("Add Doctor's Name");
		  b3.setPreferredSize(new Dimension(150,20));
		  jp.add(b3);
		  return jp;
	}
	
	public JPanel addButtonToPanel1(JPanel jp) {
		  b3=this.getButton("Print");
		  b3.setPreferredSize(new Dimension(100,20));
		  jp.add(b3);
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
