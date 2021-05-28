package Base;

import java.io.File;

public class PathHandler {
	static String workingDirectory = System.getProperty("user.dir");
	static String fileSeparator = System.getProperty("file.separator");
	String outputDirectory;
	String fileName;
	
	public PathHandler(String filename,String outPutDirectory){
		this.fileName=filename;
		this.outputDirectory=outPutDirectory;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getOutputDirectory() {
		return outputDirectory;
	}
	public String getOutputDirectoryPath() {
		File directory = new File(workingDirectory + fileSeparator + outputDirectory);
	    if (! directory.exists()){
	        directory.mkdir();
	    }
		return workingDirectory + fileSeparator + outputDirectory + fileSeparator + fileName;
	}
}
