package mainPackage;

import java.io.File;
import java.security.SecureRandom;

public class TRand {
	
	File fileDirectory;
	File currentFile;
	String s = "";
	public TRand(String filePath) {
		filePath = filePath.replace("\\", "/");
		if(!new File(filePath).isDirectory()) {
			return;
		}
		fileDirectory = new File(filePath);
	}
	
	public TRand() {
		
	}
	
	
	
	private String loopFiles(File f) {
		if(f!=null && f.isDirectory()) {
			for(File file: f.listFiles()) {
				loopFiles(file);
			}
		} else if (f!=null && f.isFile()) {
			s+=String.valueOf(f.length());
		} else {
			return null;
		}
		return s;
	}
	public String loopFiles() {
		return loopFiles(fileDirectory);
	}
	
}
