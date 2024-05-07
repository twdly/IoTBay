package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {

    private final Connection connection;

    public OrderDao() {
        connection = new DbConnector().getConnection();
    }

    public List<Order> getOrdersForUser(int userId) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from \"ORDER\" where USER_ID=?");
            statement.setInt(1, userId);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                orders.add(createOrderFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public Order getOrderById(int orderId) {
        Order order;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from \"ORDER\" where ORDER_ID=?");
            statement.setInt(1, orderId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                order = createOrderFromResult(result);
            } else {
                order = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    private Order createOrderFromResult(ResultSet results) throws SQLException {
        int id = results.getInt("ORDER_ID");
        String name = results.getString("NAME");
        String phoneNo = results.getString("PHONE");
        Order.Status status = getStatusFromString(results.getString("ORDER_STATUS"));
        Date orderDate = results.getDate("ORDER_DATE");
        Order.Method method = getMethodFromString(results.getString("ORDER_METHOD"));
        int userId = results.getInt("USER_ID");
        int paymentId = results.getInt("PAYMENT_ID");
        int collectionId = results.getInt("COLLECTION_ID");
        int deliveryId = results.getInt("DELIVERY_ID");

        return new Order(id, name, phoneNo, status, orderDate, method, userId, paymentId, collectionId, deliveryId);
    }

    private Order.Status getStatusFromString(String statusString) {
        switch (statusString) {
            case "Shipped":
                return Order.Status.Shipped;
            case "ReadyToCollect":
                return Order.Status.ReadyToCollect;
            default:
                return Order.Status.Processing;
        }
    }

    private Order.Method getMethodFromString(String methodString) {
        if (methodString.equals("Delivery")) {
            return Order.Method.Delivery;
        } else {
            return Order.Method.Collection;
        }
    }
}
