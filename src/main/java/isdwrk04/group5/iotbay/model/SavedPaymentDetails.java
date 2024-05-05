package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class SavedPaymentDetails implements Serializable {

    private int customerId;
    private int paymentId;

    public SavedPaymentDetails(int customerId, int paymentId) {
        this.customerId = customerId;
        this.paymentId = paymentId;
    }

    public SavedPaymentDetails() {
        this.customerId = 0;
        this.paymentId = 0;
    }
}
