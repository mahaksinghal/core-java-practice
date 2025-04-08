package com.app.threads;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

import com.app.core.Student;

public class SubjectNameGpaSorterTask implements Runnable{
	private Map<String, Student> students;
	private String fileName;
	
	public SubjectNameGpaSorterTask(Map<String, Student> students, String fileName) {
		super();
		this.students = students;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "started");
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			Comparator<Student> comp = (s1, s2) -> {
				int retVal = s1.getSubject().name().compareTo(s2.getSubject().name());
				if(retVal == 0) 
					return ((Double)s1.getGpa()).compareTo(s2.getGpa());
				return retVal;
					};
			students.values()
			.stream()
			.sorted(comp)
			.forEach(s -> pw.println(s));
		}catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "got error" + e);
		}
		System.out.println(Thread.currentThread().getName() + "over");
	}
	
}
