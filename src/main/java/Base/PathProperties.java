package Base;

import java.util.Map;

public class PathProperties {
  String propetiesFileName="path.properties";
  String location="resources";
  static Map <String,String> hm;
  
  public PathProperties(){
	  PropertiesManager pm=new PropertiesManager(propetiesFileName,location);
	  hm=pm.loadProperties();
  }
  public String getUserName() {
	  return hm.get("path.user.username");
  }
  public String getPassword() {
	  return hm.get("path.user.password");
  }
  public String getLogFileName() {
	  return hm.get("path.log.fileName");
  }
  
  
  public String getDBName() {
	  return hm.get("path.DB.name");
  }
  public String getDBUserName() {
	  return hm.get("path.DB.username");
  }
  public String getDBPassword() {
	  return hm.get("path.DB.password");
  }
  public String getDBIpAddress() {
	  return hm.get("path.DB.ipAddress");
  }
  public String getDBPort() {
	  return hm.get("path.DB.port");
  }
  public String getDBDriver() {
	  return hm.get("path.DB.driver");
  }
  public String getDBDialect() {
	  return hm.get("path.DB.dialect");
  }
  public String getDBUrl() {
	  return hm.get("path.DB.url");
  }

  public String getLogFileDirectory() {
	  return hm.get("path.log.directoryName");
  }
  public String getLogFilePath() {
	  System.out.println(hm.get("path.log.directoryName")+","+hm.get("path.log.fileName") );
	  PathHandler PathHandler = new PathHandler(hm.get("path.log.fileName"), hm.get("path.log.directoryName"));
	  return PathHandler.getOutputDirectoryPath();
  }
}
