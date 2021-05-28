package Base;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class BaseFileWriter {
	PathHandler ph;
	BufferedWriter bufWriter = null;
    public BaseFileWriter(PathHandler ph) {
  	  this.ph=ph;
    }
    
    public BufferedWriter getWriter() {
		try {
			bufWriter = new BufferedWriter(new FileWriter(ph.getOutputDirectoryPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  	  return bufWriter;
    }
    
    public void close() {
  	  try {
  		bufWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void writeFromTextArea(JTextArea ta) {
    	String str=ta.getText();
    	try {
			getWriter().write(str);
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void writeIndex(String index) {
    	try {
			getWriter().write(index);
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
