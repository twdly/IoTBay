package unit;

import isdwrk04.group5.iotbay.model.PaymentDetails;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentDaoTest {

    private static Connection connection;
    private PaymentDao paymentDao;

    @AfterAll
    public static void tearDownClass() throws SQLException {
        connection.close();
    }

    @BeforeEach
    public void setUp() {
        paymentDao = new PaymentDao(connection);
    }

    @Test
    public void testAddPaymentDetails() throws SQLException {
        PaymentDetails paymentDetails = new PaymentDetails(0, 100.0f, PaymentDetails.Method.CREDIT_CARD, "John Doe", "1234567890123456", Date.valueOf(LocalDate.now().plusYears(2)), "123 Main St", PaymentDetails.Status.COMPLETED);
        int userId = 1;

        paymentDao.addPaymentDetails(paymentDetails, userId);

        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM PAYMENTDETAILS WHERE User_ID = ?")) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next());
                assertEquals(userId, rs.getInt("User_ID"));
                assertEquals(100.0f, rs.getFloat("Payment_Amount"));
                assertEquals(PaymentDetails.Method.CREDIT_CARD.name(), rs.getString("Payment_Method"));
                assertEquals("John Doe", rs.getString("Cardholder_Name"));
                assertEquals("1234567890123456", rs.getString("Card_Number"));
                assertEquals("123 Main St", rs.getString("Billing_Address"));
                assertEquals(PaymentDetails.Status.COMPLETED.name(), rs.getString("Transaction_Status"));
            }
        }
    }

    @Test
    public void testGetPaymentDetailsById() throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO PAYMENTDETAILS (User_ID, Payment_Amount, Payment_Date, Payment_Method, Cardholder_Name, Card_Number, Expiration_Date, Billing_Address, Transaction_Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, 1);
            stmt.setFloat(2, 100.0f);
            stmt.setDate(3, Date.valueOf(LocalDate.now()));
            stmt.setString(4, PaymentDetails.Method.CREDIT_CARD.name());
            stmt.setString(5, "John Doe");
            stmt.setString(6, "1234567890123456");
            stmt.setDate(7, Date.valueOf(LocalDate.now().plusYears(2)));
            stmt.setString(8, "123 Main St");
            stmt.setString(9, PaymentDetails.Status.COMPLETED.name());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                rs.next();
                int paymentId = rs.getInt(1);

                PaymentDetails paymentDetails = paymentDao.getPaymentDetailsById(paymentId);

                assertNotNull(paymentDetails);
                assertEquals(paymentId, paymentDetails.getId());
                assertEquals(100.0f, paymentDetails.getAmount());
                assertEquals(PaymentDetails.Method.CREDIT_CARD, paymentDetails.getMethod());
                assertEquals("John Doe", paymentDetails.getCardholder());
                assertEquals("1234567890123456", paymentDetails.getCardNumber());
                assertEquals("123 Main St", paymentDetails.getBillingAddress());
                assertEquals(PaymentDetails.Status.COMPLETED, paymentDetails.getStatus());
            }
        }
    }
}
