package ViewLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ExcelManager.PathItems;


public class Panel {
  public  JPanel getPanel(int a,int b,int c,int d){
	  JPanel p=new JPanel();
	  p.setBounds(a,b,c,d);  
	  p.setBorder(BorderFactory.createLineBorder(Color.black));
	  return p;
  }
  
  public  JPanel addLabel0(JPanel jp) {
	  Label l=new Label();
	  jp=l.addLabelToPanel0(jp);
	  return jp;
  }

  
  public JPanel addTextField0(JPanel jp) {
	  Text t=new Text();
	  jp=t.addTextFieldToPanel0(jp);
	  return jp;
  }
  
  public JPanel addTextField4(JPanel jp) {
	  Text t=new Text();
	  jp=t.addTextFieldToPanel4(jp);
	  return jp;
  }
  
  public JPanel addComboBox4(JPanel jp) {
	  ComboBox cb=new ComboBox();
	  jp=cb.addComboBoxToPanel4(jp);
	  return jp;
  }
  
  public JPanel addButton0(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanel0(jp);
  }
  
  public JPanel addButton1(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanel1(jp);
  }
  
  public JPanel addButton3(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanel3(jp);
  }
  
  public JPanel addButton33(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanel33(jp);
  }
  
  public JPanel addTables1(JPanel jp) {
	    Table t=new Table();
		return t.addTableToPanel1(jp);
  }
  
  public JPanel addTextArea2(JPanel jp) {
	    TextArea ta=new TextArea();
		return ta.addTextAreaToPanel2(jp);
  }
  
  public JPanel addTextArea3(JPanel jp) {
	    TextArea ta=new TextArea();
		return ta.addTextAreaToPanel3(jp);
}
  
  public JPanel addTextArea33(JPanel jp) {
	    TextArea ta=new TextArea();
		return ta.addTextAreaToPanel33(jp);
}
  
  public JPanel addLabel3(JPanel jp) {
	  Label l=new Label();
	  jp=l.addLabelToPanel3(jp);
	  return jp;
  }
  public JPanel addLabel33(JPanel jp) {
	  Label l=new Label();
	  jp=l.addLabelToPanel33(jp);
	  return jp;
  }
  
  public JPanel addComboBox0(JPanel jp) {
	  ComboBox cb=new ComboBox();
	  jp=cb.addComboBoxToPanel0(jp);
	  return jp;
  }
  
  public void loadInitialValues() {
	  Text t=new Text();
	  TextArea ta=new TextArea();
	  Table tt=new Table();
	  ComboBox cb=new ComboBox();
	  cb.loadComboBox();
	  t.loadTextField();
	  ta.loadTextArea();
	  tt.loadTable();
  }
}