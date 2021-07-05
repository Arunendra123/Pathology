package Operations;

public class TextAreaLoader extends Thread{
	public void run() {		
		  TextAreaOperations ta=new TextAreaOperations();
		  ta.loadTextArea_1();
		  ta.loadTextArea_2();
	}
}
