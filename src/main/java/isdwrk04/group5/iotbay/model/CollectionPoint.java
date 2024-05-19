package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class CollectionPoint implements Serializable {

    private int id;
    private String name;
    private String address;
    private int cityId;

    public CollectionPoint(int id, String name, String address, int cityId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cityId = cityId;
    }

    public CollectionPoint() {
        this.id = 0;
        this.name = "";
        this.address = "";
        this.cityId = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCityId() {
        return cityId;
    }
}
