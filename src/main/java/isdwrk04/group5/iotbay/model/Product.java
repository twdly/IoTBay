package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

	public String getImageUrl() {
		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
		String fileName = isWindows
				? path.substring(1, path.length()-16).replace("%20", " ")
				: path.substring(0, path.length()-16).replace("%20", " ");

		fileName += "images/" + id + ".jpg";
		System.out.println(fileName);
		Path filePath = Paths.get(fileName);

		return Files.exists(filePath) ? id + ".jpg" : "digital-temperature-sensor.jpg";
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
