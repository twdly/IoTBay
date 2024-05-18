package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.PaymentDetails;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {

    private final Connection connection;

    public PaymentDao() {
        this.connection = new DbConnector().getConnection();
    }

    public void addPaymentDetails(PaymentDetails paymentDetails, int userId) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO PAYMENTDETAILS (User_ID, Payment_Amount, Payment_Date, Payment_Method, Cardholder_Name, Card_Number, Expiration_Date, Billing_Address, Transaction_Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, userId);
            statement.setFloat(2, paymentDetails.getAmount());
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.setString(4, paymentDetails.getMethod().name());
            statement.setString(5, paymentDetails.getCardholder());
            statement.setString(6, paymentDetails.getCardNumber());
            statement.setDate(7, Date.valueOf(paymentDetails.getExpirationDate()));
            statement.setString(8, paymentDetails.getBillingAddress());
            statement.setString(9, paymentDetails.getStatus().name());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating payment failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int paymentId = generatedKeys.getInt(1);
                    paymentDetails.setId(paymentId);
                } else {
                    throw new SQLException("Creating payment failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add payment details.", e);
        }
    }

    public PaymentDetails getPaymentDetailsById(int paymentId) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM PAYMENTDETAILS WHERE Payment_ID = ?")) {
            statement.setInt(1, paymentId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return createPaymentDetailsFromResult(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve payment details by ID.", e);
        }
        return null;
    }

    public List<PaymentDetails> getAllPaymentDetails() {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM PAYMENTDETAILS")) {
            while (rs.next()) {
                paymentDetailsList.add(createPaymentDetailsFromResult(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all payment details.", e);
        }
        return paymentDetailsList;
    }

    public List<PaymentDetails> getPaymentsByUserId(int userId) {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM PAYMENTDETAILS WHERE User_ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                paymentDetailsList.add(createPaymentDetailsFromResult(rs));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentDetailsList;
    }

    public List<PaymentDetails> getPaymentsByDateRange(int userId, String startDate, String endDate) {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM PAYMENTDETAILS WHERE User_ID = ? AND Payment_Date BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setDate(2, Date.valueOf(startDate));
            statement.setDate(3, Date.valueOf(endDate));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                paymentDetailsList.add(createPaymentDetailsFromResult(rs));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentDetailsList;
    }

    public List<PaymentDetails> getPaymentsByStatus(int userId, PaymentDetails.Status status) {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM PAYMENTDETAILS WHERE User_ID = ? AND Transaction_Status = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setString(2, status.name());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                paymentDetailsList.add(createPaymentDetailsFromResult(rs));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentDetailsList;
    }

    public List<PaymentDetails> getPaymentsByMethod(int userId, PaymentDetails.Method method) {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM PAYMENTDETAILS WHERE User_ID = ? AND Payment_Method = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setString(2, method.name());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                paymentDetailsList.add(createPaymentDetailsFromResult(rs));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentDetailsList;
    }

    private PaymentDetails createPaymentDetailsFromResult(ResultSet rs) throws SQLException {
        int id = rs.getInt("Payment_ID");
        float amount = rs.getFloat("Payment_Amount");
        LocalDate date = rs.getDate("Payment_Date").toLocalDate();
        PaymentDetails.Method method = PaymentDetails.Method.valueOf(rs.getString("Payment_Method"));
        String cardholder = rs.getString("Cardholder_Name");
        String cardNumber = rs.getString("Card_Number");
        LocalDate expirationDate = rs.getDate("Expiration_Date").toLocalDate();
        String billingAddress = rs.getString("Billing_Address");
        PaymentDetails.Status status = PaymentDetails.Status.valueOf(rs.getString("Transaction_Status"));

        return new PaymentDetails(id, amount, method, cardholder, cardNumber, expirationDate, billingAddress, status);
    }
}
