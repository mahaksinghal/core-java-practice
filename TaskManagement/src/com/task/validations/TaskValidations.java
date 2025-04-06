package com.task.validations;

import java.util.List;

import com.task.core.TaskManager;
import com.task.custom_exception.ExceptionHandling;

public class TaskValidations {

	public static TaskManager checkTaskNo(int taskId, List<TaskManager> tasks) throws ExceptionHandling {
		TaskManager task = new TaskManager(taskId);
		int index = tasks.indexOf(task);
		if(index == -1)
			throw new ExceptionHandling("Account Not Found");
		return tasks.get(index);
	}
}
