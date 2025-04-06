package com.app.fruits;

public class Mango extends Fruit {

	public Mango(String name, String color, double weight) {
		super(name, color, weight);
	}

	@Override
	public String toString() {
		return "Mango: " + super.toString();
	}

	public String taste() {
		return "Sweet";
	}
}
