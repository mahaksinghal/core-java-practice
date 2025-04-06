package com.app.fruits;

public class Apple extends Fruit {

	public Apple(String name, String color, double weight) {
		super(name, color, weight);
	}

	@Override
	public String toString() {
		return "Apple: " + super.toString();
	}

	public String taste() {
		return "Sweet and Sour";
	}

	public void jam() {
		System.out.println("Name: " + getName() + " making jam!!!");
	}
}
