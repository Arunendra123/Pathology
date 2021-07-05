package Operations;

public class TextLoader extends Thread{
	public void run() {
		TextOperations t=new TextOperations();
		 t.loadTextField();
	}
}
