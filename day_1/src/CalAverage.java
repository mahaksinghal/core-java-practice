import java.util.Scanner;

class CalAverage {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter 5 numbers");
   double a = sc.nextDouble();
   double b = sc.nextDouble();
   double c = sc.nextDouble();
   double d = sc.nextDouble();
   double e = sc.nextDouble();
   double avg = (a+b+c+d+e)/5;
   System.out.println("Average is "+ avg);
   sc.close();
 }
}