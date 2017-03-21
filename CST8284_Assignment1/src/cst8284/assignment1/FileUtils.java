package cst8284.assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// TODO: import required library files here

public class FileUtils {

	private final static int NUMBER_OF_TODOS = 4;
	private static String relPath = "ToDoList.todo";
	
	public ToDo[] getToDoArray(String fileName) {
	    // TODO: insert required code here, as described in the
 	    // Assignment 1 document
		ToDo toDos[] = new ToDo[NUMBER_OF_TODOS];

		File f = new File(fileName);
		if(fileExists(f)){
			f = new File(getAbsPath(f));
		} else {
			f = new File(getAbsPath());
		}
		
		try {
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream ojs = new ObjectInputStream(fin);
			
			for (int i = 0; i <NUMBER_OF_TODOS; i ++) {
				toDos[i] = (ToDo)(ojs.readObject());
				
				System.out.println(i+"==>"+toDos[i].getTitle());
				System.out.println(i+"==>"+toDos[i].getDueDate());
			}
			
		} catch (IOException ex) {
			System.out.println("Array of ToDo has been transfered from file");
			
		} catch (ClassNotFoundException ex) {
			System.out.print("File not found");
		}
		
		
		return toDos;
	}
		
	public static String getAbsPath() {
		return relPath;
	}

	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

	private static void setAbsPath(File f) { 
		relPath = (fileExists(f))? f.getAbsolutePath():""; 
	}
	
	private static Boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead());
	}

}
