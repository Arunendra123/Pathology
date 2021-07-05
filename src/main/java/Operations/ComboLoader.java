package Operations;

import ViewLayer.ComboBox;

public class ComboLoader extends Thread{
	public void run() {
		  ComboBox cb=new ComboBox();
		  cb.loadComboBox();
	}
}
