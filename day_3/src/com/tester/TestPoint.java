package com.tester;

import java.util.Scanner;
import com.developers.geometry.Point2D;

class TestPoint {
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);

  System.out.println("enter the coordinates x and y of p1");
  Point2D p1 = new Point2D(sc.nextInt(),sc.nextInt());

  System.out.println("enter the coordinates x and y of p2");
  Point2D p2 = new Point2D(sc.nextInt(),sc.nextInt());

  System.out.println("the coordinates of p1 is ");  
  p1.show();
  System.out.println("the coordinates of p2 is ");
  p2.show();

  if(p1.isEqual(p2))
   {
     System.out.println("Equal");
   }
   else
   {
     System.out.println(p1.distance(p2));
   }
  
 
 }
}

// D:\cdac\oop with java\day-3\src>javac -d ..\bin com\tester\TestPoint.java
// D:\cdac\oop with java\day-3\src>cd ..\bin
// D:\cdac\oop with java\day-3\bin>java com.tester.TestPoint

// or
// C:\>java -cp "D:\cdac\oop with java\day-3\bin" com.tester.TestPoint

// or
// set enviornmental variable