package DBManager;
import org.hibernate.Transaction;

import ExcelManager.PathItems;

public class WriteInItemsToDB {
	
	ConnectToDB_H ctdbh;
	public WriteInItemsToDB(ConnectToDB_H ctdbh){
		this.ctdbh=ctdbh;
	}
	
	public void insert(PathItems items) {
		Transaction ts=ctdbh.getSession().beginTransaction();
		ctdbh.getSession().save(items);
		System.out.println("Items Inserted:");
		PathItems.printItems(items);
		ts.commit();
		//evict(items);
    }
	
	public void evict(PathItems items) {
		Transaction ts=ctdbh.getSession().beginTransaction();
		ctdbh.getSession().evict(items);
		ts.commit();
    }
	
	public void update(PathItems items) {
		Transaction ts=ctdbh.getSession().beginTransaction();
		ctdbh.getSession().merge(items);
		System.out.println("Items updated:");
		PathItems.printItems(items);
		ts.commit();
		//evict(items);
    }
	
	public void delete(PathItems items) {
		ctdbh.getSession().clear();
		Transaction ts=ctdbh.getSession().beginTransaction();
		ctdbh.getSession().delete(items);
		System.out.println("Items deleted:");
		PathItems.printItems(items);
		ts.commit();
    }
}
