package com.task.operations;

import com.task.custom_exception.ExceptionHandling;

public interface TaskOperations {
	
	String createTask(String description, String taskDate, String status, boolean active) 
			throws ExceptionHandling, IllegalArgumentException;
	
	void displayTasks();
	
	void deleteTask(int id) throws ExceptionHandling;
	
	String updateTask(int taskId, String status) throws ExceptionHandling;
	
	void displayPendingTask() throws ExceptionHandling;
	
	String displayPendingTaskByDate(String date) throws ExceptionHandling;
	
	void sortTaskByDate();
}
