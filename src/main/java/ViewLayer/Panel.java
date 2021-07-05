package ViewLayer;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Operations.TableOperations;
import Operations.TextAreaOperations;
import Operations.TextOperations;
import Operations.ValueLoader;

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
  
  public JPanel addButtonInsert0(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanelInsert0(jp);
  }
  
  public JPanel addButtonCUT0(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanelCUT0(jp);
  }
  
  public JPanel addButtonAdd0(JPanel jp) {
	  Button b=new Button();
	  return b.addButtonToPanelAdd0(jp);
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
  
  public JPanel addComboBox00(JPanel jp) {
	  ComboBox cb=new ComboBox();
	  jp=cb.addComboBoxToPanel00(jp);
	  return jp;
  }
  
  public JPanel addComboBox000(JPanel jp) {
	  ComboBox cb=new ComboBox();
	  jp=cb.addComboBoxToPanel000(jp);
	  return jp;
  }
  
  public void loadInitialValues() {
	  ValueLoader vl=new ValueLoader();
	  vl.start();
  }
}