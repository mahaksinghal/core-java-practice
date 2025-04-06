/*
Write Java program for the following - 
It should  run till user enters any other option than add or sub or multiply or divide
Prompt user to enter the input operation : (add|subtract|multiply|divide) & 2 numbers(double)
Display the result of the operation.
Use Scanner for accepting all inputs from user. 
Hint : use switch-case
*/

import java.util.Scanner;
class Calculator {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter 2 numbers:");
  double a = sc.nextDouble();
  double b = sc.nextDouble();
  boolean exit = false;
  while(!exit) {
   System.out.println("Menu: \n1. Add\n2. Subtract\n3. Multiply\n4. Divide");
   System.out.println("Enter your choice");
   switch(sc.nextInt()) {
    case 1: System.out.println("Addition = " + (a+b));
	    break;
    case 2: System.out.println("Subtraction = " + (a-b));
	    break;
    case 3: System.out.println("Multiplication = " + (a*b));
	    break;
    case 4: System.out.println("Division = " + (a/b));
	    break;
    default: exit = true;
	     System.out.println("Exiting...");
	     break;
   }
  }
  sc.close();
 }
}
