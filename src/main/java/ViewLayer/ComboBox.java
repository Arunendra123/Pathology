package ViewLayer;

import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Base.BaseFileReader;
import Base.PathHandler;

public class ComboBox {
	  
	public static List<String> listOfLines;
	public static List<String> listOfLines1;
	public static List<String> month;
	@SuppressWarnings("rawtypes")
	public static JComboBox combobox;
	@SuppressWarnings("rawtypes")
	public static JComboBox combobox1;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox getCombBox(ArrayList<String> ar){
    	  combobox = new JComboBox(ar.toArray());
        return combobox;
     }
      
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox getCombBoxForDoctor(){
    	    Dimension d = new Dimension(175, 25);
    	    BaseFileReader bf=new BaseFileReader(new PathHandler("doctorList","resources"));
    	    listOfLines=bf.getList();
    	    combobox = new JComboBox(listOfLines.toArray());
    	    combobox.setPreferredSize(d);
            return combobox;
     }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox getCombBoxForMonth(){
    	 Dimension d = new Dimension(170, 25);
    	    BaseFileReader bf=new BaseFileReader(new PathHandler("month","resources"));
    	    listOfLines1=bf.getList();
    	    combobox1 = new JComboBox(listOfLines1.toArray());
    	    combobox1.setPreferredSize(d);
            return combobox1;
      }
      
    @SuppressWarnings("rawtypes")
	public JPanel addComboBoxToPanel0(JPanel jp) {
    	  JComboBox c=this.getCombBoxForDoctor();
    	  jp.add(c);
    	  return jp;
    }
    
    @SuppressWarnings("rawtypes")
    public JPanel addComboBoxToPanel4(JPanel jp) {
	    JComboBox c=this.getCombBoxForMonth();
  	    jp.add(c);
 	    return jp;
    }
    
    public void loadComboBox() {
    	LocalDate currentdate = LocalDate.now();
    	combobox1.setSelectedItem(currentdate.getMonth().toString());
    }
}
