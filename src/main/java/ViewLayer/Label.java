package ViewLayer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Label {

  public JLabel getLabel(String label) {
	    JLabel l = new JLabel(label,SwingConstants.LEFT);
	    Border blackline = BorderFactory.createLineBorder(Color.lightGray);
		l.setFont(new Font("New Roman", Font.BOLD, 15));
		l.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		l.setBorder(blackline);
		return l;
  }
  
  public JLabel getLabelWithouBorder(String label) {
	    JLabel l = new JLabel(label);
		l.setFont(new Font("New Roman", Font.BOLD, 15));
		return l;
  }
  
  public JPanel addLabelToPanel0(JPanel jp) {
	  JLabel l0,l1,l2,l3,l4,l5,l6,l7;
	  Label l=new Label();
	  l0 = l.getLabel("          Date        ");
	  l1 = l.getLabel("        Patient-Name      ");
	  l2 = l.getLabel(" Full-Amount  ");
	  l3 = l.getLabel(" Paid-Amount  ");
	  l4 = l.getLabel(" Conc-Amount  ");
	  l5 = l.getLabel(" Coll-Amount  ");
	  l6 = l.getLabel(" Cut-Amount   ");
	  l7 = l.getLabel("          Doctor's-Name       ");
	  jp.add(l0);
	  jp.add(l1);
	  jp.add(l2);
	  jp.add(l3);
	  jp.add(l4);
	  jp.add(l5);
	  jp.add(l6);
	  jp.add(l7);
	  return jp;
  }
  
  public JPanel addLabelToPanel2(JPanel jp) {
	  JLabel l8,l9,l10,l11;
	  Label l=new Label();
	  l8 =  l.getLabelWithouBorder("Total Cases       : ");
	  l9 =  l.getLabelWithouBorder("Total Paid Amount : ");
	  l10 = l.getLabelWithouBorder("Total Cut Amount  : ");
	  l11 = l.getLabelWithouBorder("  ");
	  jp.add(l8);
	  jp.add(l9);
	  jp.add(l10);
	  jp.add(l11);
	  return jp;
  }
  
  public JPanel addLabelToPanel3(JPanel jp) {
	  JLabel l8;
	  Label l=new Label();
	  l8 =  l.getLabelWithouBorder("Doctor's name ");
	  jp.add(l8);
	  return jp;
  }
  public JPanel addLabelToPanel33(JPanel jp) {
	  JLabel l8;
	  Label l=new Label();
	  l8 =  l.getLabelWithouBorder("Daily Report");
	  jp.add(l8);
	  return jp;
  }
}
