package Operations;

import ViewLayer.ComboBox;

public class ValueLoader extends Thread{
	public void run() {
		TextOperations t=new TextOperations();
		  TextAreaOperations ta=new TextAreaOperations();
		  TableOperations tt=new TableOperations();
		  ComboBox cb=new ComboBox();
		  cb.loadComboBox();
		  t.loadTextField();
		  ta.loadTextArea_1();
		  ta.loadTextArea_2();
		  tt.loadTable();
	}
}
