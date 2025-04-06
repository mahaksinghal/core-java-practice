package com.developers.geometry;

public class Point2D{
private int x;
private int y;
public Point2D (int x,int y){
  this.x =x;
  this.y = y;
 }

public void show(){
  System.out.println("x = " + x + " y = " +  y);
 }

public boolean isEqual(Point2D p){
 if(x==p.x && y==p.y)
return true;
else return false;
 }

public double distance(Point2D p2) {
  return Math.sqrt((Math.pow(x-p2.x, 2)) + (Math.pow(y-p2.y, 2)));
 }
}