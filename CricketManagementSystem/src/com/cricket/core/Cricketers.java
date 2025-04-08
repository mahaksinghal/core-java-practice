package com.cricket.core;
// String name,int age,String email_id,String Phone,int rating
public class Cricketers {
	
	private String name;
	private int age;
	private String email_id;	// UID(PK)
	private String phone;
	private int rating;
	
	public Cricketers(String name, int age, String email_id, String phone, int rating) {
		super();
		this.name = name;
		this.age = age;
		this.email_id = email_id;
		this.phone = phone;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Cricketers [name=" + name + ", age=" + age + ", email_id=" + email_id + ", Phone=" + phone + ", rating="
				+ rating + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cricketers)
			return this.email_id.equals(((Cricketers)obj).email_id);
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.email_id.hashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		phone = phone;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
