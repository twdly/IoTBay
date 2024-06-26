package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int id;
    private String name;
    private String phoneNo;
    private Status status;
    private Date orderDate;
    private Method method;
    private int userId;
    private int paymentId;
    private int collectionId;
    private int deliveryId;

    public enum Status {
        Processing,
        Shipped,
        ReadyToCollect,
        Cancelled
    }

    public enum Method {
        Collection,
        Delivery
    }

    public Order(int id, String name, String phoneNo, Status status, Date orderDate, Method method, int userId, int paymentId, int collectionId, int deliveryId) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.status = status;
        this.orderDate = orderDate;
        this.method = method;
        this.userId = userId;
        this.paymentId = paymentId;
        this.collectionId = collectionId;
        this.deliveryId = deliveryId;
    }

    public Order() {
        this.name = "";
        this.phoneNo = "";
        this.status = Status.Processing;
        this.orderDate = new Date();
        this.method = Method.Delivery;
        this.userId = 0;
        this.paymentId = 0;
        this.collectionId = 0;
        this.deliveryId = 0;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Method getMethod() {
        return method;
    }

    public int getUserId() {
        return userId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
