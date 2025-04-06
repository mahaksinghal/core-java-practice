/*
1.2 Properties (instance variables)  in Fruit class-
 color : String , weight : double , name:String, isFresh : boolean

1.3 Add suitable constructors

1.4 Override  toString correctly to return state of all fruits 
(return only  - name ,color , weight )

1.5 Add a taste() method : public String taste()
*/

package com.app.fruits;

public class Fruit {
	private String name;
	private String color;
	private double weight;
//	private boolean isFresh;

	public Fruit(String name, String c, double weight) {
		this.name = name;
		color = c;
		this.weight = weight;
//		this.isFresh = true;
	}

	@Override
	public String toString() {
		return "name: " + name + " color: " + color + " weight: " + weight;
	}

	public String taste() {
		return "Unknown Taste";
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getWeight() {
		return weight;
	}
}
