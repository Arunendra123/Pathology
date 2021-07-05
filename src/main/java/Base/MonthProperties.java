package Base;

import java.util.Map;

public class MonthProperties {
	  String propetiesFileName="month.properties";
	  String location="resources";
	  static Map <String,String> hm_month;
	  
	  public MonthProperties(){
		  PropertiesManager pm=new PropertiesManager(propetiesFileName,location);
		  if(hm_month==null) {
			  hm_month=pm.loadProperties();
		  }
	  }
	  public int getMonth(String month) {
		  return Integer.parseInt(hm_month.get(month.trim()));
	  }
}
