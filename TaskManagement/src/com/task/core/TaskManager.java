package com.task.core;
/*
You can create a class Task with fields like taskId, taskName, description, taskDate, status, active. 
taskId should be unique and generated automatically.
status should be either PENDING, IN PROGRESS or COMPLETED.
active should be either true or false. Deleted task will have active=false 
Newly added task should have default status as PENDING and active=true
 */

import java.time.LocalDate;

public class TaskManager {
	int taskId;
	String description;
	LocalDate taskDate;
	Status status;
	boolean active;
	static int counter = 0;
	
	public TaskManager() {
		status = Status.PENDING;
		active = true;
	}
	
	public TaskManager(int id) {
		taskId = id;
	}
	
	public TaskManager(String description, LocalDate taskDate, Status status, boolean active) {
		counter++;
		taskId = counter;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
	}

	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", description=" + description + ", task date=" + taskDate + ", status="
				+ status + ", active=" + active + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TaskManager) 
			return this.taskId == ((TaskManager) obj).taskId;
		return false;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		TaskManager.counter = counter;
	}
	
}


