package cst8284.assignment2;
/**
 * Read a file, write a file, validation check and create arrayList<ToDo>
 * @fileName FileUtils.java
 * @author Saeil Kim 040845408
 * @course CST8284
 * @section 300
 * @assignment Assignment3
 * @version 3.0
 * @date 2017.04.17
 * @professor David Houtman
 * @purpose Controlling File (i.e read a file, write a file, creating arrayLst from the file
 * @Create_User David Houtman
 * @Create_date 2017. 03.
 * @Modify_User Saeil Kim
 * @Modify_date 2017. 04. 17.
 * @see java.io.EOFException
 * @see java.io.File
 * @see java.io.FileInputStream
 * @see java.io.FileOutputStream
 * @see java.io.IOException
 * @see java.io.ObjectInputStream
 * @see java.io.ObjectOutputStream
 * @see java.util.ArrayList
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileUtils {

	/**
	 * The relPath is providing default fileName
	 */
	private static String relPath = "ToDoList.todo";

	/**
	 * This method is used to create ArrayList of ToDo from the file
	 * @param fileName 
	 * @return ArrayList<ToDo>
	 */
	public ArrayList<ToDo> getToDoArray(String fileName) {
		ArrayList<ToDo> toDos = new ArrayList<ToDo>();
		
		try {
			FileInputStream fis = getFIStreamFromAbsPath(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);

			while(true) {
				try {
				toDos.add((ToDo)(ois.readObject()));
				} catch (EOFException e) {
					break;
				}
			}
			
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return toDos;
	}
	
	
	
	/**
	 * Creating FileinputStream from the file
	 * @param absPath filePath
	 * @return FileInputStream file changes to fileInputStream 
	 */
	public static FileInputStream getFIStreamFromAbsPath(String absPath){
		FileInputStream fis = null;
		try {
     		fis = new FileInputStream(absPath);
		} catch (IOException e){
			e.printStackTrace();
		}
		return fis;
	}
	
	
	/**
	 * Return AbsolutePath with No the parameter
	 * @return String return absolutepath of file
	 */
	public static String getAbsPath() {
		return relPath;
	}

	/**
	 * Return AbsolutePath with a file parameter
	 * @param f filename
	 * @return String return absolutepath of file
	 */
	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

	/**
	 * Set-up Real path that if file exists return absolutepath else ""
	 * @param f fileName
	 */
	public static void setAbsPath(File f) { 
		relPath = (fileExists(f))? f.getAbsolutePath():""; 
	}
	
	/**
	 * Checking validation of file that file exists or check file type or read available
	 * @param f fileName
	 * @return Boolean 
	 */
	public static Boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead());
	}
	
	/**
	 * Creating File Again from existing toDoArray
	 * @param fileName For create array, exist filename input
	 * @param toDoArray Call to exist toDoArray for creating the fileStream
	 */
	public static void setToDoArrayListToFile(String fileName, ArrayList<ToDo> toDoArray){
		try (
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
			for (int j = 0; j < toDoArray.size(); j++) 
			oos.writeObject(toDoArray.get(j));	

			
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}
	
	

}
