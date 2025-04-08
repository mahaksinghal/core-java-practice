package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateStudentMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.threads.DateSorterTask;
import com.app.threads.StoreParticularDetails;
import com.app.threads.SubjectNameGpaSorterTask;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Student> populatedMap = populateStudentMap(populateList());

			System.out.println("Enter the 1st fileName");
			String fileName1 = sc.nextLine();
			Thread t1 = new Thread(new DateSorterTask(populatedMap, fileName1), "one");

			System.out.println("Enter the 2st fileName");
			String fileName2 = sc.nextLine();
			Thread t2 = new Thread(new SubjectNameGpaSorterTask(populatedMap, fileName2), "two");

			System.out.println("Enter the 3st fileName");
			String fileName3 = sc.nextLine();
			System.out.println("Enter the specified city");
			String city = sc.nextLine();
			Thread t3 = new Thread(new StoreParticularDetails(populatedMap, fileName3, city), "two");

			t1.start();
			t2.start();
			t3.start();
			System.out.println("main waiting for child thrds....");
			t1.join();
			t2.join();
			t3.join();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Main ended");
		}

	}
}
