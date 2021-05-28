package ViewLayer;

import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Text {
	
	public static JTextField t0,t1,t2,t3,t4,t5,t6,t7,t8;
	
	public JTextField getTextField(int lenght) {
		JTextField t=new JTextField ();
		Font f = new Font("Consolas", Font.PLAIN, 16);
		t.setPreferredSize(new Dimension(lenght,25));
        t.setFont(f);
		return t;
    }
	
	public void loadTextField() {
		LocalDate currentdate = LocalDate.now();
		String date[]=currentdate.toString().split("-");
		t0.setText(currentdate.toString());
		t8.setText(date[0]);
		t2.setText("0");
		t3.setText("0");
		t4.setText("0");
		t5.setText("0");
		t6.setText("0");	
	}
	
	public void SetTextFieldAfterInsert() {
		t1.setText("");
		t2.setText("0");
		t3.setText("0");
		t4.setText("0");
		t5.setText("0");
		t6.setText("0");	
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
		if(isNumber(t3.getText().toString())) {
			int paid=Integer.parseInt(t3.getText().toString());
			int cut=(paid*percent)/100;
			t6.setText(cut+"");
		}
	}
	
	public void SetCutAmount() {
		if(isNumber(t3.getText().toString())&&isNumber(t2.getText().toString())) {
			int paid=Integer.parseInt(t3.getText().toString());
			int full=Integer.parseInt(t2.getText().toString());
			int cut=(full/2)-(full-paid);
			if(cut>=0) {
				t6.setText(cut+"");
			}
		}
	}
	
    public JPanel addTextFieldToPanel0(JPanel jp) {
 	  t0=this.getTextField(107);
	  t1=this.getTextField(152);
	  t2=this.getTextField(98);
	  t3=this.getTextField(105);
	  t4=this.getTextField(103);
	  t5=this.getTextField(103);
	  t6=this.getTextField(103);
	  //t7=this.getTextField(136);
	  
	  jp.add(t0);
	  jp.add(t1);
	  jp.add(t2);
	  jp.add(t3);
	  jp.add(t4);
	  jp.add(t5);
	  jp.add(t6);
	  //jp.add(t7);
	  return jp;
   }
   
   public JPanel addTextFieldToPanel4(JPanel jp) {
	   t8=this.getTextField(95);
 	   jp.add(t8);
	   return jp;
   }
}
