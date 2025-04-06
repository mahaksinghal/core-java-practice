import java.util.Scanner;
class TestPoint {
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);

  System.out.println("enter the coordinates x and y of p1");
  Point2D p1 = new Point2D(sc.nextInt(),sc.nextInt());

  System.out.println("enter the coordinates x and y of p2");
  Point2D p2 = new Point2D(sc.nextInt(),sc.nextInt());
  
  p1.show();
  p2.show();

  if(p2.isEqual(p1))
   {
     System.out.println("Equal");
   }
   else
   {
     System.out.println(p1.distance(p2));
   }
  
 
 }
}