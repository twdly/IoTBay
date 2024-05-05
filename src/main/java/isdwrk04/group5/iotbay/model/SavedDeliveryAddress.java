package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class SavedDeliveryAddress implements Serializable {

    private int customerId;
    private int deliveryId;

    public SavedDeliveryAddress(int customerId, int deliveryId) {
        this.customerId = customerId;
        this.deliveryId = deliveryId;
    }

    public SavedDeliveryAddress() {
        this.customerId = 0;
        this.deliveryId = 0;
    }
}
