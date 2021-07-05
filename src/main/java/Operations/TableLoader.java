package Operations;

public class TableLoader extends Thread{
	public void run() {
		  TableOperations tt=new TableOperations();
		  tt.loadTable();
	}
}
