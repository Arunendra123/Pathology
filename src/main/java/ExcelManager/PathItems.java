package ExcelManager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import Base.BaseFileReader;
import Base.BaseFileWriter;
import Base.PathHandler;

@Entity
public class PathItems {
	@Id
   private int indexNo;
   private int day;
   private int month;
   private int year;
   private String ptName;
   private int fullAmount;
   private int paidAmount;
   private int concAmount;
   private String collection;
   private int cutAmount;
   private String doctorName;
   
   public PathItems(int indexNo,int day,int month,int year,String ptName,int fullAmount,int paidAmount,int concAmount,int cutAmount,String collection,String doctorName) {
	   this.indexNo=indexNo;
	   this.day=day;
	   this.month=month;
	   this.year=year;
	   this.ptName=ptName;
	   this.fullAmount=fullAmount;
	   this.paidAmount=paidAmount;
	   this.concAmount=concAmount;
	   this.cutAmount=cutAmount;
	   this.collection=collection;
	   this.doctorName=doctorName;
   }
   
   public PathItems() {
	   
   } 
   
   public int getIndex() {
	   return indexNo;
   }
   
   public int generateIndex() {
	   PathHandler ph=new PathHandler("index","resources");
	   BaseFileReader bfr=new BaseFileReader(ph);
	   BaseFileWriter bfw=new BaseFileWriter(ph);
	   int cur=bfr.readIndex();
	   cur=cur+1;
	   System.out.println(cur);
	   bfw.writeIndex(cur+"");
	   return cur;
   }
   
   public int getDay() {
	   return day;
   }
   public int getMonth() {
	   return month;
   }
   public int getYear() {
	   return year;
   }
   public String getPtName() {
	   return ptName;
   }
   public int getFullAmount() {
	   return fullAmount;
   }
   public int getPaidAmount() {
	   return paidAmount;
   }
   public int getConcAmount() {
	   return concAmount;
   }
   public int getCutAmount() {
	   return cutAmount;
   }
   public String getCollection() {
	   return collection;
   }
   public String getDoctorName() {
	   return doctorName;
   }
  
   
   public void setIndex(int indexNo) {
	   this.indexNo=indexNo;
   }
   public void setDay(int day) {
	   this.day=day;
   }
   public void setMonth(int month) {
	   this.month=month;
   }
   public void setYear(int year) {
	   this.year=year;
   }
   public void setPtName(String ptName) {
	   this.ptName=ptName;
   }
   public void setFullAmount(int fullAmount) {
	   this.fullAmount=fullAmount;
   }
   public void setPaidAmount(int paidAmount) {
	   this.paidAmount=paidAmount;
   }
   public void setConcAmount(int concAmount) {
	   this.concAmount=concAmount;
   }
   public void setCutAmount(int cutAmount) {
	   this.cutAmount=cutAmount;
   }
   public void setCollection(String collection) {
	   this.collection=collection;
   }
   public void setDoctorName(String doctorName) {
	   this.doctorName=doctorName;
   }
   
   public void setAll() {
	   this.indexNo=0;
	   this.day=0;
	   this.month=0;
	   this.year=0;
	   this.ptName="unknown";
	   this.fullAmount=0;
	   this.paidAmount=0;
	   this.concAmount=0;
	   this.cutAmount=0;
	   this.collection="";
	   this.doctorName="unknown";
   }
   
   
   public static void printItems(PathItems item){
	   System.out.print(item.getIndex()+"\t");
	   System.out.print(item.getPtName()+"\t");
	   System.out.print(item.getDay()+"-"+item.getMonth()+"-"+item.getYear()+"\t");
	   System.out.print(item.getFullAmount()+"\t");
	   System.out.print(item.getPaidAmount()+"\t");
	   System.out.print(item.getConcAmount()+"\t");
	   System.out.print(item.getCutAmount()+"\t");
	   System.out.print(item.getCollection()+"\t");
	   System.out.print(item.getDoctorName()+"\t\n");
   }
   
   public static void printItems(List<PathItems> ItemsList){
	      for(PathItems pi:ItemsList) {
	    	  PathItems.printItems(pi);
	      }
   }
   
   public static String getStringForItems(PathItems item){
	   return "Index: "+item.getIndex()+", "
			   +"PtName: "+item.getPtName()+","
			   +"Date: "+item.getDay()+"-"+item.getMonth()+"-"+item.getYear()+","
			   +"Full Amt: "+item.getFullAmount()+", "
			   +"Pat Amt: "+item.getPaidAmount()+", "
			   +"Con Amt: "+item.getConcAmount()+", "
			   +"Cut Amt: "+item.getCutAmount()+", "
			   +"Collection: "+item.getCollection()+", "
			   +"Doctor's Name: "+item.getDoctorName();
   }
}
