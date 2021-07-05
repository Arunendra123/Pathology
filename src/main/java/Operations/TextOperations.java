package Operations;

import java.time.LocalDate;

import ViewLayer.Text;

public class TextOperations {
	public void loadTextField() {
		LocalDate currentdate = LocalDate.now();
		String date[]=currentdate.toString().split("-");
		Text.t0.setText(currentdate.toString());
		Text.t8.setText(date[0]);
		Text.t2.setText("0");
		Text.t3.setText("0");
		Text.t4.setText("0");
		Text.t5.setText("");
		Text.t6.setText("0");	
	}
	
	public void SetTextFieldAfterInsert() {
		Text.t1.setText("");
		Text.t2.setText("0");
		Text.t3.setText("0");
		Text.t4.setText("0");
		Text.t5.setText("");
		Text.t6.setText("0");	
	}
	
	private static boolean isNumber(String text) {
		  try {
		         Integer.parseInt(text);
		         return true;
		      } catch (NumberFormatException e) {
		         return false;
		      }
	}
	public void SetCutAmount(int percent) {
		if(isNumber(Text.t3.getText().toString())) {
			int paid=Integer.parseInt(Text.t3.getText().toString());
			int cut=(paid*percent)/100;
			Text.t6.setText(cut+"");
		}
	}	
	public void SetCutAmount() {
		if(isNumber(Text.t3.getText().toString())&&isNumber(Text.t2.getText().toString())) {
			int paid=Integer.parseInt(Text.t3.getText().toString());
			int full=Integer.parseInt(Text.t2.getText().toString());
			int cut=(full/2)-(full-paid);
			if(cut>=0) {
				Text.t6.setText(cut+"");
			}
		}
	}
}
