package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class DeliveryAddress implements Serializable {

    private int id;
    private String address;
    private int cityId;

    public DeliveryAddress(int id, String address, int cityId) {
        this.id = id;
        this.address = address;
        this.cityId = cityId;
    }

    public DeliveryAddress() {
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getCityId() {
        return cityId;
    }

    public void setShipmentMethod(String shipmentMethod) {
    }
}