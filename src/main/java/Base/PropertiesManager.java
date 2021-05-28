package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesManager {
	Map<String, String>  hm;
	String propertiesFileName;
	String location;
	
	public PropertiesManager(String propertiesFileName,String location){
		this.propertiesFileName=propertiesFileName;
		this.location=location;
	}
	
	public Map<String,String> loadProperties() {
		    PathHandler ph=new PathHandler(propertiesFileName,location);
			File f=new File(ph.getOutputDirectoryPath());
			hm = new HashMap<String, String>();
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("<======Print Properties====>");
			for (String key : properties.stringPropertyNames()) {
				   hm.put(key, properties.get(key).toString());
				   System.out.println(key+","+ properties.get(key).toString());
			}
			System.out.println("<====== Properties ====>");
			return hm;
	}
}
