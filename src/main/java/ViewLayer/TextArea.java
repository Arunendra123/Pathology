package ViewLayer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Base.BaseFileReader;
import Base.PathHandler;

public class TextArea {
   static JTextArea  ta0,ta1,ta2;
   public JTextArea getTextArea(JPanel jp,int l,int b) {
	   JTextArea ta=new JTextArea(l,b);
	   return ta;
   }
   
   public JPanel addTextAreaToPanel2(JPanel jp) {
	   ta0=getTextArea(jp,5,16);
	   ta0.setEditable(false);
	   Color color1 = new Color(0,0,0);
	   ta0.setForeground(Color.white);
	   ta0.setBackground(color1);
	   jp.add(new JScrollPane(ta0));
	   return jp;
   }
   
   public JPanel addTextAreaToPanel3(JPanel jp) {
	   ta1=getTextArea(jp,13,15);
	   jp.add(new JScrollPane(ta1));
	   return jp;
   }
   
   public JPanel addTextAreaToPanel33(JPanel jp) {
	   ta2=getTextArea(jp,8,16);
	   ta2.setEditable(false);
	   Color color1 = new Color(0,0,0);
	   ta2.setForeground(Color.white);
	   ta2.setBackground(color1);
	   jp.add(new JScrollPane(ta2));
	   return jp;
   }
   
   public void setTextArea(int tpa,int tca) {
	   String str="Total Cases: "+(Table.t0.getRowCount()-1)+"\nTotal Paid Amount: "+tpa+"\nTotal Cut Amount: "+tca;
	   ta0.setText(str);
   }
   public void setTextArea2(String str) {
	   ta2.append(str);
   }
   public void loadTextArea(){
	   String doctorName="";
	   for(String str: ComboBox.listOfLines) {
		   doctorName=doctorName+str+"\n";
	   }
	   ta1.setText(doctorName);
   }
}
