package LogManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Base.PathProperties;

public class  LogWriter{
	
	public static LogWriter lw;
	static PrintStream out=null;
	static PathProperties pp;
	public static PrintStream getLogWriter() {
    	pp=new PathProperties();
		try {
			FileOutputStream fw = new FileOutputStream(pp.getLogFilePath(), true);
			out=new PrintStream(fw,false);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  return out;
      }
	
      public static void WriteLogs(String logs) {
    	  getLogWriter();
    	  Path path = Paths.get(pp.getLogFilePath());
    	  try  {
			     long bytes = Files.size(path);
			     if(bytes>1024*1024*10) {
			    	 close();
			    	 Files.move(path,path.resolveSibling(pp.getLogFileName()+".old."+java.util.Calendar.getInstance().getTime().toString().replaceAll("\\s+", ".").replaceAll(":",".")));
			    	 getLogWriter();
			     }
		    } catch (IOException e) {
			e.printStackTrace();
		  }
    	  out.println(java.util.Calendar.getInstance().getTime()+": "+pp.getUserName()+" :"+" ["+logs+"]");
      }
      
      public static void close() {
    	  out.close();
      }
      
      public LogWriter getLogWriterObject() {
    	  return lw;
      }
      
      public void setLogWriterObject(LogWriter lw) {
    	  this.lw=lw;
      }
}

   

