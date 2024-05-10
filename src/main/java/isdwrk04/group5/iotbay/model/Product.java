package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {

	private final int id;
	private String name;
	private final double price;
	private final String description;
	private int stock;
	private int quantity;

	public int getId() {
		return id;
	}

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
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public Product() {
		this.id = 0;
		this.name = "";
		this.price = 0;
		this.description = "";
		this.stock = 0;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public double calculatePrice() {
		return quantity * price;
	}
}
