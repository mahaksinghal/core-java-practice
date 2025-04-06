package com.app.fruits;

public class Orange extends Fruit {

	public Orange(String name, String color, double weight) {
		super(name, color, weight);
	}

	@Override
	public String toString() {
		return "Orange: " + super.toString();
	}

	public String taste() {
		return "Sour";
	}

	public void juice() {
		System.out.println("Name: " + getName() + " Weight: " + getWeight() + " extracting juice!!!");
	}
}
