package com.cricket.services;

import static com.cricket.validations.CricketValidations.*;

import java.util.HashMap;
import java.util.Map;

import com.cricket.core.Cricketers;
import com.cricket.exception_handling.CustomException;

public class CricketServicesImpl implements CricketServices {

//	private ArrayList<Cricketers> players = new ArrayList<Cricketers>();
	private Map<String, Cricketers> players = new HashMap<>();

	public CricketServicesImpl() {
//		this.players = new HashMap<>();
		try {
			System.out.println("Map Created");
			addCricketers("a1", 21, "a1@gmail.com", "1234567892", 4);
			addCricketers("a2", 30, "a2@gmail.com", "1554656455", 3);
			addCricketers("a3", 25, "a3@gmail.com", "5456547454", 2);
			addCricketers("a4", 32, "a4@gmail.com", "6765746335", 5);
			addCricketers("a5", 38, "a5@gmail.com", "4574354535", 4);
			addCricketers("a6", 22, "a6@gmail.com", "2656564648", 1);
			addCricketers("a7", 38, "a7@gmail.com", "5136451464", 2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String addCricketers(String name, int age, String email_id, String phone, int rating)
			throws CustomException, IllegalArgumentException {
		validateEmail(email_id, players);
		validatePhone(phone);
		validateAge(age);
		validateRating(rating);
		Cricketers player = new Cricketers(name, age, email_id, phone, rating);
		players.put(email_id, player);
		return "Player Added with email id " + email_id;
	}

	@Override
	public void displayCricketers() {
		System.out.println("Players in the Map");
		players.values().stream().forEach(value -> System.out.println(value));
	}

	@Override
	public void updateRating(String email, int rating) throws CustomException {
		checkEmail(email, players.keySet());
		validateRating(rating);
		players.values().stream().filter(p -> p.getEmail_id().equals(email)).forEach(p -> {
			p.setRating(rating);
			System.out.println("Rating set for player " + p.getName());
		});
	}
	
	@Override
	public void searchByName(String name) {
		players.values().stream()
		.filter(p -> p.getName().equals(name))
		.forEach(p -> System.out.println(p));
	}
	
	@Override
	public void sortByRating() {
		players.values().stream()
		.sorted((p1, p2) -> ((Integer)p1.getRating()).compareTo(p2.getRating()))
		.forEach(p -> System.out.println(p));
	}
}









