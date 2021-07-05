package ViewLayer;

import javax.swing.JOptionPane;

import ExcelManager.PathItems;

public class PathItemsMaper {
   public static PathItems mapItemsFromTextBox(PathItems pi) {
	      pi=new PathItems(); 
		  String date[]=Text.t0.getText().split("-");
		  pi.setIndex(pi.generateIndex());
		  pi.setYear(Integer.parseInt(date[0]));
		  pi.setMonth(Integer.parseInt(date[1]));
		  pi.setDay(Integer.parseInt(date[2]));
		  pi.setPtName(Text.t1.getText());
		  pi.setFullAmount(Integer.parseInt(Text.t2.getText()));
		  pi.setPaidAmount(Integer.parseInt(Text.t3.getText()));
		  pi.setConcAmount(Integer.parseInt(Text.t4.getText()));
		  pi.setCollection(Text.t5.getText());
		  int cut=(Integer.parseInt(Text.t6.getText())==0)?(Integer.parseInt(Text.t2.getText().toString())/2)-(Integer.parseInt(Text.t2.getText().toString())-Integer.parseInt(Text.t3.getText().toString())):Integer.parseInt(Text.t6.getText());
		  pi.setCutAmount(cut>=0?cut:0);
		  pi.setDoctorName(ComboBox.combobox.getSelectedItem().toString());
	      return pi;
   }
   
   public static PathItems mapItemsFromTable(PathItems pi) {
	   int getSelectedRowForDeletion = Table.t0.getSelectedRow();	   
       if (getSelectedRowForDeletion >= 0) {
           pi.setIndex(Integer.parseInt(Table.model.getValueAt(getSelectedRowForDeletion, 0).toString()));
           String date[]=Table.model.getValueAt(getSelectedRowForDeletion, 1).toString().split("-");
           pi.setDay(Integer.parseInt(date[0]));
 		   pi.setMonth(Integer.parseInt(date[1]));
 		   pi.setYear(Integer.parseInt(date[2]));
           pi.setPtName(Table.model.getValueAt(getSelectedRowForDeletion, 2).toString());
           pi.setFullAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRowForDeletion, 3).toString()));
           pi.setPaidAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRowForDeletion, 4).toString()));
           pi.setConcAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRowForDeletion, 5).toString()));
           pi.setCollection(Table.model.getValueAt(getSelectedRowForDeletion, 6).toString());
           pi.setCutAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRowForDeletion, 7).toString()));
           pi.setDoctorName(Table.model.getValueAt(getSelectedRowForDeletion, 8).toString());
       }
	return pi;
  }
   
   public static PathItems mapItemsFromTable_1(PathItems pi,int getSelectedRow) {	   
       if (getSelectedRow >= 0) {
           pi.setIndex(Integer.parseInt(Table.model.getValueAt(getSelectedRow, 0).toString()));
           String date[]=Table.model.getValueAt(getSelectedRow, 1).toString().split("-");
           pi.setDay(Integer.parseInt(date[0]));
 		   pi.setMonth(Integer.parseInt(date[1]));
 		   pi.setYear(Integer.parseInt(date[2]));
           pi.setPtName(Table.model.getValueAt(getSelectedRow, 2).toString());
           pi.setFullAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRow, 3).toString()));
           pi.setPaidAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRow, 4).toString()));
           pi.setConcAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRow, 5).toString()));
           pi.setCollection(Table.model.getValueAt(getSelectedRow, 6).toString());
           pi.setCutAmount(Integer.parseInt(Table.model.getValueAt(getSelectedRow, 7).toString()));
           pi.setDoctorName(Table.model.getValueAt(getSelectedRow, 8).toString());
       }
	return pi;
  }
   
   
   private static boolean isNumber(String text) {
	  try {
	         Integer.parseInt(text);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
   }
   
   public static boolean validateTextFields() {
	  String str[]=Text.t0.getText().split("-");
	  System.out.print(str.length);
	  if(str.length==3) {
		  if(!isNumber(str[0])) {
			   JOptionPane.showMessageDialog(null, "Please input correct Year");
			   return false; 
		  }
		  if(!isNumber(str[1])) {
			   JOptionPane.showMessageDialog(null, "Please input correct month");
			   return false; 
		   }else{
			   if(Integer.parseInt(str[1])>12){
				   JOptionPane.showMessageDialog(null, "Month can be more than 12");
				   return false;
			   }
		   }
		  if(!isNumber(str[2])) {
			   JOptionPane.showMessageDialog(null, "Please input correct day");
			   return false; 
		   }else {
			   if(Integer.parseInt(str[2])>31){
				   JOptionPane.showMessageDialog(null, "Day can be more than 31");
				   return false;
			   }
		   }
	   }else {
		   JOptionPane.showMessageDialog(null, "Please input correct date");
		   return false;
	   }
	  System.out.print(Text.t1.getText());
	   if(Text.t1.getText().equals("")) {
		   JOptionPane.showMessageDialog(null, "Please input petients name");
		   return false;
	   }
	   if(Text.t2.getText().equals("")||Text.t3.getText().equals("")||Text.t4.getText().equals("")||Text.t6.getText().equals("")) {
		   if(Text.t2.getText().equals("")) {
			   Text.t2.setText("0");
		   }
		   if(Text.t3.getText().equals("")) {
			   Text.t3.setText("0");
		   }
		   if(Text.t4.getText().equals("")) {
			   Text.t4.setText("0");
		   }
		   if(Text.t6.getText().equals("")) {
			   Text.t6.setText("0");
		   }
	   }else {
		   if(!isNumber(Text.t2.getText())) {
			   JOptionPane.showMessageDialog(null, "Please input correct full amount");
			   return false; 
		   }
		   if(!isNumber(Text.t3.getText())) {
			   JOptionPane.showMessageDialog(null, "Please input correct paid amount");
		      return false; 
		   }
		   if(!isNumber(Text.t4.getText())) {
			   JOptionPane.showMessageDialog(null, "Please input correct conc amount");
		       return false; 
		   }
		   if(!isNumber(Text.t6.getText())) {
			   JOptionPane.showMessageDialog(null, "Please input correct cut amount");
			   return false;
		   }
	   }
	   
	   if(Integer.parseInt(Text.t3.getText().toString())>Integer.parseInt(Text.t2.getText().toString())){
		   JOptionPane.showMessageDialog(null, "Paid amount can't be more than full amount");
		   return false;
	   }
	   return true;
   }
   
   public static boolean validateTableFields() {
	   
	      int getSelectedRowForDeletion = Table.t0.getSelectedRow();
	      if (getSelectedRowForDeletion >= 0) {
		  String str[]=Table.model.getValueAt(getSelectedRowForDeletion, 1).toString().split("-");
		  System.out.print(str.length);
		  if(str.length==3) {
			  if(!isNumber(str[2])) {
				   JOptionPane.showMessageDialog(null, "Please input correct Year");
				   return false; 
			  }
			  if(!isNumber(str[1])) {
				   JOptionPane.showMessageDialog(null, "Please input correct month");
				   return false; 
			   }else{
				   if(Integer.parseInt(str[1])>12){
					   JOptionPane.showMessageDialog(null, "Month can be more than 12");
					   return false;
				   }
			   }
			  if(!isNumber(str[0])) {
				   JOptionPane.showMessageDialog(null, "Please input correct day");
				   return false; 
			   }else {
				   if(Integer.parseInt(str[0])>31){
					   JOptionPane.showMessageDialog(null, "Day can be more than 31");
					   return false;
				   }
			   }
		   }else {
			   JOptionPane.showMessageDialog(null, "Please input correct date");
			   return false;
		   }
		   if(Table.model.getValueAt(getSelectedRowForDeletion, 2).toString().equals("")) {
			   JOptionPane.showMessageDialog(null, "Please input petients name");
			   return false;
		   }
		   if(Table.model.getValueAt(getSelectedRowForDeletion, 3).toString().equals("") || Table.model.getValueAt(getSelectedRowForDeletion, 4).toString().equals("")||Table.model.getValueAt(getSelectedRowForDeletion, 5).toString().equals("")||Table.model.getValueAt(getSelectedRowForDeletion, 7).toString().equals("")) {
			   JOptionPane.showMessageDialog(null, "Please input correct amount");
			   return false;
		   }else {
			   if(!isNumber(Table.model.getValueAt(getSelectedRowForDeletion, 3).toString())) {
				   JOptionPane.showMessageDialog(null, "Please input correct full-amount");
				   return false; 
			   }
			   if(!isNumber(Table.model.getValueAt(getSelectedRowForDeletion, 4).toString())) {
				   JOptionPane.showMessageDialog(null, "Please input correct paid-amount");
			      return false; 
			   }
			   if(!isNumber(Table.model.getValueAt(getSelectedRowForDeletion, 5).toString())) {
				   JOptionPane.showMessageDialog(null, "Please input correct conc-amount");
			       return false; 
			   }
			   if(!isNumber(Table.model.getValueAt(getSelectedRowForDeletion, 7).toString())) {
				   JOptionPane.showMessageDialog(null, "Please input correct cut-amount");
				   return false;
			   }
		   }
		   return true;
		   }else 
		   {
		       JOptionPane.showMessageDialog(null, "Please select a Entry");
			   return false; 
		   }
	 }
}
