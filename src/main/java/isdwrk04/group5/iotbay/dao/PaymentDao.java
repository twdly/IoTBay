package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.PaymentDetails;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {

    private final Connection connection;

    public PaymentDao() {
        connection = new DbConnector().getConnection();
    }


    public void addPaymentDetails(PaymentDetails paymentDetails, int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PAYMENTDETAILS (Payment_Amount, Payment_Date, Payment_Method, Cardholder_Name, Card_Number, Expiration_Date, Billing_Address, Transaction_Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setFloat(1, paymentDetails.getAmount());
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setString(3, paymentDetails.getMethod().name());
            statement.setString(4, paymentDetails.getCardholder());
            statement.setString(5, paymentDetails.getCardNumber());
            statement.setDate(6, new Date(paymentDetails.getExpirationDate().getTime()));
            statement.setString(7, paymentDetails.getBillingAddress());
            statement.setString(8, paymentDetails.getStatus().name());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            int paymentId;
            if (rs.next()) {
                paymentId = rs.getInt(1);
            } else {
                throw new SQLException("Creating payment failed, no ID obtained.");
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PaymentDetails getPaymentDetailsById(int paymentId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PAYMENTDETAILS WHERE Payment_ID = ?");
            statement.setInt(1, paymentId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return createPaymentDetailsFromResult(rs);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<PaymentDetails> getAllPaymentDetails() {
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PAYMENTDETAILS");
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
        Date date = rs.getDate("Payment_Date");
        PaymentDetails.Method method = PaymentDetails.Method.valueOf(rs.getString("Payment_Method"));
        String cardholder = rs.getString("Cardholder_Name");
        String cardNumber = rs.getString("Card_Number");
        Date expirationDate = rs.getDate("Expiration_Date");
        String billingAddress = rs.getString("Billing_Address");
        PaymentDetails.Status status = PaymentDetails.Status.valueOf(rs.getString("Transaction_Status"));

        return new PaymentDetails(id, amount, method, cardholder, cardNumber, expirationDate, billingAddress, status);
    }

    public boolean savePaymentDetails(PaymentDetails paymentDetails) {
        String query = "INSERT INTO payment_details (amount, method, cardholder, card_number, expiration_date, billing_address, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setFloat(1, paymentDetails.getAmount());
            stmt.setString(2, paymentDetails.getMethod().toString());
            stmt.setString(3, paymentDetails.getCardholder());
            stmt.setString(4, paymentDetails.getCardNumber());
            stmt.setDate(5, new java.sql.Date(paymentDetails.getExpirationDate().getTime()));
            stmt.setString(6, paymentDetails.getBillingAddress());
            stmt.setString(7, paymentDetails.getStatus().toString());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePaymentDetails(int paymentId) {
        String query = "DELETE FROM PAYMENTDETAILS WHERE Payment_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, paymentId);
            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
