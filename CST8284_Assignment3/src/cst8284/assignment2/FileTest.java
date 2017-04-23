package cst8284.assignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;

public class FileTest {

	private static final String FILENAME = "D:\\ToDoList30.todo";

	  public static void main( String[] args )
	   {	
	      try{
	    	String content = "This is my content which would be appended " +
	        	"at the end of the specified file";
	        //Specify the file name and path here
	    	File file =new File(FILENAME);

	    	/* This logic is to create the file if the
	    	 * file is not already present
	    	 */
	    	if(!file.exists()){
	    	   file.createNewFile();
	    	}

	    	//Here true is to append the content to file
	    	FileWriter fw = new FileWriter(file,true);
	    	//BufferedWriter writer give better performance
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	bw.write(content);
	    	//Closing BufferedWriter Stream
	    	bw.close();

		System.out.println("Data successfully appended at the end of file");

	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }
	      
	  		ArrayList<ToDo> toDoArray = new ArrayList<>();
	      
			ToDo tdTemp = new ToDo();
			tdTemp.setCompleted(false);
			tdTemp.setEmpty(false);
			tdTemp.setRemove(true);
			
//			tdTemp = toDoArray.get(0);


			tdTemp.setTitle("ABC");
			tdTemp.setSubject("test");
//			tdTemp.setDueDate(Date.valueOf(getTempDate().getValue()));
//			tdTemp.setPriority(Integer.parseInt(getTempPriority().getText()));
			tdTemp.setPriority(2);
			tdTemp.setDueDate(new Date(117, 2, 15));
			
			
			
//			toDoArray.set(0, tdTemp);
			toDoArray.add(0, tdTemp);
			

				try (
						FileOutputStream fos = new FileOutputStream(FILENAME);
						ObjectOutputStream oos = new ObjectOutputStream(fos);
					) {
//							getToDoArray().add(tdTemp);
//							setToDoArray(getToDoArray());
//					
//					for (int j = 0; j < getToDoArray().size(); j++) 
//						oos.writeObject(getToDoArray().get(j));	
					for (int j = 0; j < toDoArray.size(); j++) 
					oos.writeObject(toDoArray.get(j));	

					
					} catch (IOException e) {
						e.printStackTrace();
					}

	      
	      
	      
	      
	   }	
}
