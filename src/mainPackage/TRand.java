package mainPackage;

import java.io.File;
import java.security.SecureRandom;
import java.util.Properties;

public class TRand {
	
	File fileDirectory;
	File currentFile;
	String s = "";
	public TRand(String filePath) {
		filePath = filePath.replace("\\", "/");
		if(filePath.equals("") || !new File(filePath).isDirectory()) {
			System.out.println("Please enter a file directory");
			return;
		}
		fileDirectory = new File(filePath);
	}
	
	public TRand() {
		
	}
	
	private String noise() {
		SecureRandom sr = new SecureRandom();
		return String.valueOf(Math.abs(sr.nextInt())+ "" +System.currentTimeMillis());
	}
	//Loop through the specified file directory
	private String loopFiles(File f) {
		if(f!=null && f.isDirectory()) {
			for(File file: f.listFiles()) {
				loopFiles(file);
			}
		} else if (f!=null && f.isFile()) {
			s+=String.valueOf(f.length() + noise());
		} else {
			return null;
		}
		return s;
	}
	public String loopFiles() {
		return loopFiles(fileDirectory);
	}
	
}
