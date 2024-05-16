package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class OrderLine implements Serializable {

    private int quantity;
    private int orderId;
    private int productId;

    public OrderLine(int quantity, int orderId, int productId) {
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderLine() {
        this.quantity = 0;
        this.orderId = 0;
        this.productId = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }
}
