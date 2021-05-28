package DBManager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Transaction;
import ExcelManager.PathItems;

public class ReadItemsFromDB {
	ConnectToDB_H ctdbh;
	
	public ReadItemsFromDB(ConnectToDB_H ctdbh){
		this.ctdbh=ctdbh;
	}
	
	public PathItems getItem(int indexNo) {
		Transaction ts=ctdbh.getSession().beginTransaction();
		PathItems pi=(PathItems)ctdbh.getSession().get(PathItems.class,indexNo);
		ts.commit();
		if(pi!=null) {
			return pi;
		}else {
			return new PathItems();
		}
    }
	
	public List<PathItems> getItemList(){
		CriteriaBuilder cb = ctdbh.getSession().getCriteriaBuilder();
	    CriteriaQuery<PathItems> cq = cb.createQuery(PathItems.class);
	    Root<PathItems> rootEntry = cq.from(PathItems.class);
	    CriteriaQuery<PathItems> all = cq.select(rootEntry);
	    TypedQuery<PathItems> allQuery = ctdbh.getSession().createQuery(all);
	    return allQuery.getResultList();
	}
	
	public List<PathItems> getItemList(String query,int month,int year) {
		List<PathItems> pathitems=new ArrayList<PathItems>();
		Transaction ts=ctdbh.getSession().beginTransaction();
		pathitems= ctdbh.getSession().createQuery(query, PathItems.class).setParameter("month", month).setParameter("year", year).getResultList(); 
	    ts.commit();
	    return pathitems;
	}
	
	public List<PathItems> getItemList(String query,String doctorName,int month,int year) {
		List<PathItems> pathitems=new ArrayList<PathItems>();
		Transaction ts=ctdbh.getSession().beginTransaction();
		pathitems= ctdbh.getSession().createQuery(query, PathItems.class).setParameter("doctorName", doctorName).setParameter("month", month).setParameter("year", year).getResultList(); 
	    ts.commit();
	    return pathitems;
	}
	
	public List<PathItems> getItemList(String query,int month,int year,int day) {
		List<PathItems> pathitems=new ArrayList<PathItems>();
		Transaction ts=ctdbh.getSession().beginTransaction();
		pathitems= ctdbh.getSession().createQuery(query, PathItems.class).setParameter("month", month).setParameter("year", year).setParameter("day",day).getResultList(); 
	    ts.commit();
	    return pathitems;
	}
	
	public int getMonthCutTotal(int month,int year) {
		List<PathItems> piL=this.getItemList();
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getCutAmount();
		}
		return sum;
	}
	
	public int getMonthCutTotal(int month,int year,List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getCutAmount();
		}
		return sum;
	}
	
	public int getMonthCutTotal(List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			sum=sum+pis.getCutAmount();
		}
		return sum;
	}
	
	public int getMonthFullTotal(int month,int year) {
		List<PathItems> piL=this.getItemList();
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			   sum=sum+pis.getFullAmount();
		}
		return sum;
	}
	
	public int getMonthFullTotal(int month,int year,List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getFullAmount();
		}
		return sum;
	}
	
	public int getMonthFullTotal(List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			sum=sum+pis.getFullAmount();
		}
		return sum;
	}
	
	public int getMonthPaidTotal(int month,int year) {
		List<PathItems> piL=this.getItemList();
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getPaidAmount();
		}
		return sum;
	}
	
	public int getMonthPaidTotal(int month,int year,List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getPaidAmount();
		}
		return sum;
	}
	
	public int getMonthPaidTotal(List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			sum=sum+pis.getPaidAmount();
		}
		return sum;
	}
	
	public int getMonthCollectionTotal(int month,int year) {
		List<PathItems> piL=this.getItemList();
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getCollectionAmount();
		}
		return sum;
	}
	
	public int getMonthCollectionTotal(int month,int year,List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			if(pis.getMonth()==month&&pis.getYear()==year)
			sum=sum+pis.getCollectionAmount();
		}
		return sum;
	}
	
	public int getMonthCollectionTotal(List<PathItems> piL) {
		int sum=0;
		for(PathItems pis: piL) {
			sum=sum+pis.getCollectionAmount();
		}
		return sum;
	}
	
}
