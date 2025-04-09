package com.app.tester;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.app.core.Emp;

public class Test4 {
	public static void main(String[] args) {
		try {
			// emp.class --> this triggers the class loading in the method area
			Class<Emp> empClass = Emp.class;
			Constructor<Emp> empCtor = empClass.getConstructor(String.class, double.class);
			Emp emp = empCtor.newInstance("Rama Kher", 23234);
			System.out.println(emp);
			// dynamic method invocation
			Arrays.stream(empClass.getDeclaredMethods())
			.filter(m->m.getName().equals("updateSalary"))
			.forEach(m->{
				try {
					m.setAccessible(true);
					m.invoke(emp, 5000);	// security exception if setAccessible is false
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			System.out.println(emp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
