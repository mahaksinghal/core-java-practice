package com.app.tester;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter the name of the class/interface, "
					+ "to find out internal details via reflection");
			/*
			 * how to load specified class in memory(method area( also known as meta space))
			 * Method of java.lang.Class<T> (generic class)
			 * public static Class<?> forName(String fullyQualifiedClassName)
			 * 								throws ClassNotFoundException
			 * forName()--
			 * --loads the specified class in the method area, JVM creates the singleton
			 * instance of Class<T> in heap and returns this reference to the caller.
			 * 
			 * 
			 * --> triggers for class loading in method area
			 * 1. creating class instance	OR
			 * 2. accessing static members	OR
			 * 3. Class.forName(name)		OR
			 * 4. NameOfTheClass.class
			 */
			
			 Class<?> anyClass = Class.forName(sc.next());
			 if(anyClass.isInterface()) {
				 System.out.println(anyClass.getName() + " is an interface");
				 System.out.println("Direct super interfaces - ");
				 System.out.println(Arrays.toString(anyClass.getGenericInterfaces()));
			 }
			 else {
				 System.out.println(anyClass.getName() + " is a class");
				 System.out.println("Name of the super class ");
				 System.out.println(anyClass.getSuperclass());
				 System.out.println("Implemented Interfaces- ");
				 Arrays.stream(anyClass.getInterfaces())
				 .forEach(System.out::println); 	// equivalent lambda expression i -> sop(i)
				 
				 /*
				  * can you find class modifiers using reflection?
				  * yes
				  */
				 int modifiers = anyClass.getModifiers();
				 System.out.println(Modifier.isAbstract(modifiers)?"Abstract": "Concrete");
				 System.out.println(Modifier.isFinal(modifiers)?"Final": "");
				 System.out.println(Modifier.isPublic(modifiers)?"Public": "Package-private");
			 }
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}







