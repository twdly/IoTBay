package IoTBay.mvp.model;

public class Payment_Order {
    private int orderId;
    private double amount;
    // Add more attributes as needed

    // Constructors
    public Payment_Order() {
    }

    public Payment_Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Override toString() method if needed
    @Override
    public String toString() {
        return "Payment_Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }
}
