package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class City implements Serializable {

    private int id;
    private String name;
    private String postcode;

    public City(int id, String name, String postcode) {
        this.id = id;
        this.name = name;
        this.postcode = postcode;
    }

    public City() {
        this.id = 0;
        this.name = "";
        this.postcode = "";
    }
}
