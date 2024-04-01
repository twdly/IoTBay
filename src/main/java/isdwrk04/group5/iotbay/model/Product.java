package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {

	private String name;
	private double price;
	private String description;

	// Getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPrice() {
		return String.format("%.2f", price);
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	// Constructor
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
}
