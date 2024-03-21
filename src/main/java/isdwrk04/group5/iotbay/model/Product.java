package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }
}
