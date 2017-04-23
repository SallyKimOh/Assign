package cst8284.fileIO;
import java.io.File;

public class FileInfo {
	
	public String infoStr;
	public StringBuilder infoStr1;
	
	public FileInfo(File f){
	   if (f.exists() && f.isFile()){
		  infoStr = "File Name: " + f.getName() + "\n";
		  infoStr += "File Path: " + f.getAbsolutePath() + "\n";
		  infoStr += "Length " + f.length() + " bytes" + "\n";
		  infoStr += "Total Number of Words: " + WordDump.getWordCtr() + "\n";
		  infoStr += "File Read Status: " + f.canRead() + "\n";
		  infoStr += "File Write Status: " + f.canWrite() + "\n";
		  infoStr += "Is File Hidden?: " + f.isHidden() + "\n";
	   }
	   else
		  infoStr = f.getName() + " does not exist or is not a file";

	   System.out.println(infoStr);
	}

	public FileInfo(File f,int i){
		   if (f.exists() && f.isFile()){
			  infoStr1.append("File Name: " + f.getName() + "\n"+
			  "File Path: " + f.getAbsolutePath() + "\n"+
			  "Length " + f.length() + " bytes" + "\n"+
			  "Total Number of Words: " + WordDump.getWordCtr() + "\n"+
			  "File Read Status: " + f.canRead() + "\n"+
			  "File Write Status: " + f.canWrite() + "\n"+
			  "Is File Hidden?: " + f.isHidden() + "\n");
		   }
		   else
			  infoStr1.append(f.getName() + " does not exist or is not a file");

		   System.out.println(infoStr);
		}
	
	
	public String getInfoString(){
		return infoStr;
	}
	
	
}
