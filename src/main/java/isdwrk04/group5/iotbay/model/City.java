package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class City implements Serializable {

    private int id;
    private String name;
    private String postcode;
    private State state;

    public City(int id, String name, String postcode, State state) {
        this.id = id;
        this.name = name;
        this.postcode = postcode;
        this.state = state;
    }

    public City() {
        this.id = 0;
        this.name = "";
        this.postcode = "";
        this.state = State.NSW;
    }

    public enum State {
        NSW,
        VIC,
        QLD,
        WA,
        ACT,
        SA,
        TAS,
        NT
    }
}
