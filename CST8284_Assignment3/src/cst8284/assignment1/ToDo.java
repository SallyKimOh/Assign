package cst8284.assignment1;

import java.io.Serializable;
import java.util.Date;
/**
 * This class manages ToDo object.
 * It has a constractor, setter and getter
 * @fileName ToDo.java
 * @author Saeil Kim 040845408
 * @course CST8284
 * @section 300
 * @assignment Assignment3
 * @version 3.0
 * @date 2017.04.17
 * @professor David Houtman
 * @purpose getters and setters
 * @Create_User David Houtman
 * @Create_date 2017. 03.
 * @Modify_User Saeil Kim
 * @Modify_date 2017. 04. 17.
 * @see java.util.Date
 */

public class ToDo extends Task implements Serializable  {
	private int priority;
	private Date dueDate;
	private boolean completed, remove, empty;
	private String subject, title;
	private static final long serialVersionUID = 4418499318752076272L;
	
	public ToDo(){
		title = subject = "";
//		dueDate = new Date();
		dueDate = null;
		priority = 0;
		remove = true;
		
	}
	
	public ToDo(String subject, String title, int priority, Date dueDate, boolean completed, boolean remove, boolean empty){
		setSubject(subject); setTitle(title); setPriority(priority); setDueDate(dueDate);
		setCompleted(completed); setRemove(remove); setEmpty(empty);
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public boolean isRemoveSet() {
		return remove;
	}
	
	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	public boolean isEmptySet() {
		return empty;
	}
	
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
//	@Override
//	public String toString(){
//		return (getDueDate().toString());
//	}

}
