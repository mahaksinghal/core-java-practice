package com.app.threads;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

import com.app.core.Student;

public class StoreParticularDetails implements Runnable{
	private Map<String, Student> students;
	private String fileName;
	private String city;
	
	public StoreParticularDetails(Map<String, Student> students, String fileName, String city) {
		super();
		this.students = students;
		this.fileName = fileName;
		this.city = city;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "started");
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			Comparator<Student> comp = (s1, s2) -> 
							((Double)s2.getGpa()).compareTo(s1.getGpa());
			students.values()
			.stream()
			.filter(s -> s.getAddress().getCity().equals(city))
			.sorted(comp)
			.forEach(s -> pw.println(s.getRollNo() + s.getName() + s.getGpa()));
		}catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "got error" + e);
		}
		System.out.println(Thread.currentThread().getName() + "over");
	}
	
}
