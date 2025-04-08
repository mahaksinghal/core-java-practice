package com.app.threads;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;

public class DateSorterTask implements Runnable{
	private Map<String, Student> students;
	private String fileName;
	
	public DateSorterTask(Map<String, Student> students, String fileName) {
		super();
		this.students = students;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "started");
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			students.values()
			.stream()
			.sorted((s1, s2) -> s1.getDob().compareTo(s2.getDob()))
			.forEach(s -> pw.println(s));
		}catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "got error" + e);
		}
		System.out.println(Thread.currentThread().getName() + "over");
	}
	
}
