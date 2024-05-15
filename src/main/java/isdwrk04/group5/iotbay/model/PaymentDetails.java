package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.util.Date;

public class PaymentDetails implements Serializable {

    private int id;
    private float amount;
    private Date date;
    private Method method;
    private String cardholder;
    private Date expirationDate;
    private String address;
    private Status status;

    public enum Method {
        Credit,
        Debit,
    }

    public enum Status {
        Success,
        Pending,
        Declined
    }

    public PaymentDetails(int id, float amount, Date date, Method method, String cardholder, Date expirationDate, String address, Status status) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.cardholder = cardholder;
        this.expirationDate = expirationDate;
        this.address = address;
        this.status = status;
    }

    public PaymentDetails() {
        this.id = 0;
        this.amount = 0;
        this.date = new Date();
        this.method = Method.Credit;
        this.cardholder = "";
        this.expirationDate = new Date();
        this.address = "";
        this.status = Status.Pending;
    }
}