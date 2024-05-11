package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public String getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.calculatePrice();
        }
        return String.format("%.2f", totalPrice);
    }

    public void clearCart() {
        products = new ArrayList<>();
    }

    public void addItem(Product product) {
        Product foundProduct = products.stream().filter(selectedProduct -> selectedProduct.getId() == product.getId()).findAny().orElse(null);
        if (foundProduct != null) {
            products.get(products.indexOf(foundProduct)).setQuantity(foundProduct.getQuantity() + 1);
        } else {
            product.setQuantity(1);
            products.add(product);
        }
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void updateQuantity(int index, int quantity) {
        this.products.get(index).setQuantity(quantity);
    }
}
