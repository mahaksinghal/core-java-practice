package com.task.tester;

import java.util.Scanner;

import com.task.operations.TaskOperations;
import com.task.operations.TaskOperationsImpl;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			TaskOperations ops = new TaskOperationsImpl();
			boolean exit = false;
			while (!exit) {
				try {
					System.out
							.println("Menu: \n" 
									+ "1. Add New Task\n" 
									+ "2. Display all tasks\n"
									+ "3. Delete a task\n" 
									+ "4. Update task status\n"
									+ "5. Display all pending tasks\n" 
									+ "6. Display all pending tasks for specified date\n"
									+ "7. Display all tasks sorted by taskDate\n" 
									+ "0. Exit\n");
					System.out.println("Enter your choice");
					switch (sc.nextInt()) {
					case 1:
						// Add New Task
						System.out.println("Enter details of a new task");
						System.out.println("Enter description, task Date, "
								+ "Status (Pending/InProgress/Completed), "
								+ "active(true/false)");
						System.out.println(ops.createTask(sc.next(), sc.next(), 
								sc.next(), sc.nextBoolean()));
						break;
					case 2:
						ops.displayTasks();
						break;
					case 3: 
						System.out.println("Enter the task Id to delete");
						ops.deleteTask(sc.nextInt());
						break;
					case 4:
						System.out.println("Enter the task Id and status to update");
						System.out.println(ops.updateTask(sc.nextInt(), sc.next()));
						break;
					case 5: 
						ops.displayPendingTask();
						break;
					case 6:
						System.out.println("Enter Date to search for pending task");
						System.out.println(ops.displayPendingTaskByDate(sc.next()));
						break;
					case 7:
						System.out.println("Task sorted as per the date");
						ops.sortTaskByDate();
						ops.displayTasks();
						break;
					case 0:
						exit = true;
						System.out.println("Program Terminated");
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					e.getStackTrace();
					sc.nextLine();
				}
			}
		}
	}

}
