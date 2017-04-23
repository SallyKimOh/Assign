package cst8284.assignment2;
/**
 * This class manages ToDo object that is adding ToDo objects and removing ToDo objects.
 * Also Task displays sequential ToDo List and can change order of ToDo
 * @fileName TaskManger.java
 * @author Saeil Kim 040845408
 * @course CST8284
 * @section 300
 * @assignment Assignment3
 * @version 3.0
 * @date 2017.04.17
 * @professor David Houtman
 * @purpose Creating abstract method for getters and setters
 * @Create_User David Houtman
 * @Create_date 2017. 03.
 * @Modify_User Saeil Kim
 * @Modify_date 2017. 04. 17.
 * @see java.util.Date
 */

import java.util.Date;

public abstract class Task {
	private Date dateCreated;
	
	public Task(){setDateCreated();}
	
	public abstract String getSubject();	
	public abstract void setSubject(String subject);
	
	public abstract String getTitle();	
	public abstract void setTitle(String title);
	
	public Date getDateCreated(){return dateCreated;}
	private void setDateCreated(){this.dateCreated = new Date();}

	@Override
	public String toString(){return (getDateCreated().toString());}
	
}