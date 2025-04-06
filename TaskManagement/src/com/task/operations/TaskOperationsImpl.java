package com.task.operations;

import static com.task.validations.TaskValidations.checkTaskNo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.task.core.Status;
import com.task.core.TaskManager;
import com.task.custom_exception.ExceptionHandling;

public class TaskOperationsImpl implements TaskOperations {
	private ArrayList<TaskManager> tasks = new ArrayList<>();

	public TaskOperationsImpl() {
		tasks = new ArrayList<>();
		try {
			createTask("long task", "2002-03-29", "COMPLETED", false);
			createTask("short task", "2010-02-19", "INPROGRESS", true);
			createTask("difficult", "2008-12-29", "PENDING", true);
			createTask("easy", "2004-09-27", "PENDING", false);
			createTask("challenging", "2012-07-11", "INPROGRESS", true);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public String createTask(String description, String taskDate, String status, boolean active)
			throws ExceptionHandling, IllegalArgumentException {
		LocalDate date = LocalDate.parse(taskDate);
		Status myStatus = Status.valueOf(status.toUpperCase());
		TaskManager task = new TaskManager(description, date, myStatus, active);
		tasks.add(task);
		return "Task Added Successfully with TaskId = " + task.getTaskId();

	}

	@Override
	public void displayTasks() {
		System.out.println("All Tasks stored");
		for (TaskManager t : tasks)
			System.out.println(t);
	}

	@Override
	public void deleteTask(int id) throws ExceptionHandling {
		Iterator<TaskManager> itr = tasks.iterator();
		while (itr.hasNext()) {
			TaskManager task = itr.next();
			if (task.getTaskId() == id) {
				itr.remove();
				System.out.println(task + " is deleted");
			}
		}
	}

	@Override
	public String updateTask(int id, String status) throws ExceptionHandling {
		TaskManager task = checkTaskNo(id, tasks);
		Status updateStatus = Status.valueOf(status.toUpperCase());
		task.setStatus(updateStatus);
		return "Task Status Updated";
	}

	@Override
	public void displayPendingTask() throws ExceptionHandling {
//		for(TaskManager task: tasks) {
//			if(task.getStatus() == Status.PENDING)
//				System.out.println(task);
//			
//			}
		tasks.stream().filter(t -> t.getStatus().equals(Status.PENDING)).forEach(s -> System.out.println(s));
	}

	@Override
	public String displayPendingTaskByDate(String date) throws ExceptionHandling {
		LocalDate specifiedDate = LocalDate.parse(date);
		for (TaskManager task : tasks) {
			if (task.getStatus() == Status.PENDING && task.getTaskDate().isEqual(specifiedDate))
				return task.toString();
		}
		throw new ExceptionHandling("NO pending task found for specified date");
	}

	@Override
	public void sortTaskByDate() {
		Collections.sort(tasks, new Comparator<TaskManager>() {
			@Override
			public int compare(TaskManager t1, TaskManager t2) {
				return t1.getTaskDate().compareTo(t2.getTaskDate());
			}
		});
	}
}













