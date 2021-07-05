package Base;

import java.util.Map;

public class PathProperties {
  String propetiesFileName="path.properties";
  String location="resources";
  static Map <String,String> hm_path;
  
  public PathProperties(){
	  PropertiesManager pm=new PropertiesManager(propetiesFileName,location);
	  if(hm_path==null) {
		  hm_path=pm.loadProperties();
	  }
  }
  public String getUserName() {
	  return hm_path.get("path.user.username");
  }
  public String getPassword() {
	  return hm_path.get("path.user.password");
  }
  public String getLogFileName() {
	  return hm_path.get("path.log.fileName");
  }
  
  public String getDBName() {
	  return hm_path.get("path.DB.name");
  }
  public String getDBUserName() {
	  return hm_path.get("path.DB.username");
  }
  public String getDBPassword() {
	  return hm_path.get("path.DB.password");
  }
  public String getDBIpAddress() {
	  return hm_path.get("path.DB.ipAddress");
  }
  public String getDBPort() {
	  return hm_path.get("path.DB.port");
  }
  public String getDBDriver() {
	  return hm_path.get("path.DB.driver");
  }
  public String getDBDialect() {
	  return hm_path.get("path.DB.dialect");
  }
  public String getDBUrl() {
	  return hm_path.get("path.DB.url");
  }

  public String getLogFileDirectory() {
	  return hm_path.get("path.log.directoryName");
  }
  public String getLogFilePath() {
	  System.out.println(hm_path.get("path.log.directoryName")+","+hm_path.get("path.log.fileName") );
	  PathHandler PathHandler = new PathHandler(hm_path.get("path.log.fileName"), hm_path.get("path.log.directoryName"));
	  return PathHandler.getOutputDirectoryPath();
  }
}
