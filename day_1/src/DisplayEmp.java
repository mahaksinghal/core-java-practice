/* Write java application to accept int(emp id) , double(salary) , emp's first name(string), is permanent :  boolean from Scanner & display the same using printf */

import java.util.Scanner;
class DisplayEmp {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.printf("Emp id: %d,\nName: %s,\nSalary: %.2f\nIs Permanent? %b \n",sc.nextInt(), sc.next(), sc.nextFloat(), sc.nextBoolean());
 }
}