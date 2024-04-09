package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {

	private int id;
	private String name;
	private double price;
	private String description;
	private int stock;

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
	public Product(int id, String name, String description, double price, int stock) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product() {
		this.id = 0;
		this.name = "";
		this.price = 0;
		this.description = "";
		this.stock = 0;
	}
}
