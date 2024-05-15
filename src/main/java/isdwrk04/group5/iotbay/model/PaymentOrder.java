package isdwrk04.group5.iotbay.model;

public class PaymentOrder {
    private String paymentMethod;
    private String datePaid;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String nameOnCard;

    public PaymentOrder() {
    }

    public PaymentOrder(String paymentMethod, String datePaid, String cardNumber, String expiryDate, String cvv, String nameOnCard) {
        this.paymentMethod = paymentMethod;
        this.datePaid = datePaid;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }
}
