package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Product implements Serializable {

	private int id;
	private String name;
	private String category;
	private String description;
	private double price;
	private int stock;
	private int quantity;

	// Getters
	public String getName() {
		return name;
	}
	public String getCategory() { return category; }
	public String getDescription() { return description; }
	public String getPrice() {
		return String.format("%.2f", price);
	}
	public int getStock() { return stock; }

	public int getId() {
		return this.id;
	}

	public int getQuantity() {
		return quantity;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) { this.id = id; }

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
		String fileName = isWindows
				? path.substring(1, path.length()-16).replace("%20", " ")
				: path.substring(0, path.length()-16).replace("%20", " ");

		fileName += "images/" + id + ".jpg";
		Path filePath = Paths.get(fileName);

		return Files.exists(filePath) ? id + ".jpg" : "digital-temperature-sensor.jpg";
	}

	// Constructor
	// this constructor is used when staff is adding a new product via the system as the ID has not yet been assigned
	public Product(String name, String category, String description, double price, int stock) {
		this.id = 0;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public Product(int id, String name, String category, String description, double price, int stock) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public Product() {
		this.id = 0;
		this.name = "";
		this.category = "";
		this.description = "";
		this.price = 0;
		this.stock = 0;
	}

	public double calculatePrice() {
		return quantity * price;
	}
}
