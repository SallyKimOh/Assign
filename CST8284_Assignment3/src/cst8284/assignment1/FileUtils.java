package cst8284.assignment1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileUtils {

	private static String relPath = "ToDoList.todo";
	
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
	
	
	
	
	public static FileInputStream getFIStreamFromAbsPath(String absPath){
		FileInputStream fis = null;
		try {
     		fis = new FileInputStream(absPath);
		} catch (IOException e){
			e.printStackTrace();
		}
		return fis;
	}
	
	public static String getAbsPath() {
		return relPath;
	}

	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

	public static void setAbsPath(File f) { 
		relPath = (fileExists(f))? f.getAbsolutePath():""; 
	}
	
	public static Boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead());
	}
	
	public static void setToDoArrayyListToFile(String fileName, ArrayList<ToDo> toDoArray){
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
