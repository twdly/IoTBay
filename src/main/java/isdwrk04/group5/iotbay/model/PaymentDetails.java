package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PaymentDetails implements Serializable {

    private int id;
    private float amount;
    private Method method;
    private String cardholder;
    private String cardNumber;
    private LocalDate expirationDate;
    private String billingAddress;
    private Status status;
    private String cvv;

    public float getAmount() {
        return amount;
    }

    public Method getMethod() {
        return method;
    }

    public String getCardholder() {
        return cardholder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public Status getStatus() {
        return status;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public enum Method {
        Credit,
        Debit
    }

    public enum Status {
        Success,
        Pending,
        Declined
    }

    public PaymentDetails() {
    }

    public PaymentDetails(int id, float amount, Method method, String cardholder, String cardNumber, LocalDate expirationDate, String billingAddress, Status status) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.cardholder = cardholder;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.billingAddress = billingAddress;
        this.status = status;
    }
}
