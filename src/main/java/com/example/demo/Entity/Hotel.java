package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	private int rating;
	private double pricePerNight;
	
    public Hotel() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Hotel(int id, String name, String location, int rating, double pricePerNight) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.pricePerNight = pricePerNight;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating
				+ ", pricePerNight=" + pricePerNight + "]";
	}
	
	

}
