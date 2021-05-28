package Base;

import java.util.Map;

public class MonthProperties {
	  String propetiesFileName="month.properties";
	  String location="resources";
	  static Map <String,String> hm;
	  
	  public MonthProperties(){
		  PropertiesManager pm=new PropertiesManager(propetiesFileName,location);
		  hm=pm.loadProperties();
	  }
	  public int getMonth(String month) {
		  return Integer.parseInt(hm.get(month.trim()));
	  }
}
