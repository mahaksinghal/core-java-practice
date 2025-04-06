class Point2D{
private int x;
private int y;
Point2D (int x,int y){
  this.x =x;
  this.y = y;
 }

void show(){
  System.out.println("x = " + x + " y = " +  y);
 }

boolean isEqual(Point2D p1){
 if(x==p1.x && y==p1.y)
return true;
else return false;
 }

double distance(Point2D p2) {
  return Math.sqrt((Math.pow(x-p2.x, 2)) + (Math.pow(y-p2.y, 2)));
 }
}