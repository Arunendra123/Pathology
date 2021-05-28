package Base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseFileReader {
	  List<String> listOfLines;
	  PathHandler ph;
	  BufferedReader bufReader = null;
      public BaseFileReader(PathHandler ph) {
    	  this.ph=ph;
      }
      
      public BufferedReader getReader() {
		try {
			bufReader = new BufferedReader(new FileReader(ph.getOutputDirectoryPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	  return bufReader;
      }
      
      public void close() {
    	  try {
			bufReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      
      public List<String> getList()
      {
    	  bufReader=getReader();
    	  listOfLines=new ArrayList<String>();
    	  String line = null;
		  try {
			    line = bufReader.readLine();
			    while (line != null){ 
	    		  listOfLines.add(line); 
	    	      line = bufReader.readLine(); 
	    	    }
			    close();
		  } catch (IOException e) {
			    e.printStackTrace();
		  } 
    	 return  listOfLines;
      }
      
      public int readIndex() {
    	String str = "0";
      	try {
  			str=getReader().readLine();
  			close();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
      	return Integer.parseInt(str);
      }
}
