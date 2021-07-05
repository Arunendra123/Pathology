package ViewLayer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea {
   public static JTextArea  ta0;
   public static JTextArea ta1;
   public static JTextArea ta2;
   public JTextArea getTextArea(JPanel jp,int l,int b) {
	   JTextArea ta=new JTextArea(l,b);
	   return ta;
   }
   
   public JPanel addTextAreaToPanel2(JPanel jp) {
	   ta0=getTextArea(jp,5,16);
	   ta0.setEditable(false);
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
	   jp.add(new JScrollPane(ta2));
	   return jp;
   }
}
