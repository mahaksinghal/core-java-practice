package com.app.fruits;

public class Alphonso extends Mango {

	public Alphonso(String name, String color, double weight) {
		super(name, color, weight);
	}

	@Override
	public String toString() {
		return "Alphonso" + super.toString();
	}

	public String taste() {
		return "Very Very Sweet";
	}

	public void pulp() {
		System.out.println("Name: " + getName() + " Color: " + getColor() + " creating pulp!!!");
	}
}
