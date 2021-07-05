package Operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Base.MonthProperties;
import ExcelManager.PathItems;
import ViewLayer.ComboBox;
import ViewLayer.Table;
import ViewLayer.Text;
import ViewLayer.TextArea;

public class TextAreaOperations {
	  public void setTextArea(int tpa,int tca) {
		   String str="Total Cases: "+(Table.t0.getRowCount()-1)+"\nTotal Paid Amount: "+tpa+"\nTotal Cut Amount: "+tca;
		   TextArea.ta0.setText(str);
	   }
	   public void setTextArea2(String str) {
		   TextArea.ta2.append(str);
	   }
	   public void loadTextArea_1(){
		   String doctorName="";
		   for(String str: ComboBox.listOfLines) {
			   doctorName=doctorName+str+"\n";
		   }
		   TextArea.ta1.setText(doctorName);
	   }
	   
	   
	   public void loadTextArea_2(){
		   String str="";
		   TableOperations to=new TableOperations();
		   MonthProperties mp=new MonthProperties();
		   LocalDate currentdate = LocalDate.now();
		   String date[]=currentdate.toString().split("-");
			
		   for(int i=0;i<=Integer.parseInt(date[2]);i++) {
			   int cutAmount=0;
			   int paidAmount=0;
			   List<PathItems> pis=to.getTableForDay(i,mp.getMonth(ComboBox.combobox1.getSelectedItem().toString()),Integer.parseInt(Text.t8.getText().toString()));  
		       for(PathItems pi:pis) {
		    	   cutAmount=cutAmount+pi.getCutAmount();
		    	   paidAmount=paidAmount+pi.getPaidAmount();
		       }
		       str=str+ "Day:"+i+"\n"+"Total Case:"+pis.size()+"\n"+"Piad Amount:"+paidAmount+"\n"+"Cut Amount:"+cutAmount+"\n";
		   }
		   TextArea.ta2.setText(str);
	   }
}
