package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.OrderLine;

import java.sql.*;
import java.time.LocalDate;
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

    public void placeOrder(Order order, List<OrderLine> orderLines) {
        try {
            int orderId = getNextOrderId();

            PreparedStatement statement = connection.prepareStatement("insert into \"ORDER\" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, orderId);
            statement.setString(2, order.getName());
            statement.setString(3, order.getPhoneNo());
            statement.setString(4, Order.Status.Processing.name());
            statement.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            statement.setString(6, order.getMethod().name());

            if (order.getUserId() == 0) {
                statement.setNull(7, Types.INTEGER);
            } else {
                statement.setInt(7, order.getUserId());
            }
            if (order.getPaymentId() == 0) {
                statement.setNull(8, Types.INTEGER);
            } else {
                statement.setInt(8, order.getPaymentId());
            }
            if (order.getCollectionId() == 0) {
                statement.setNull(9, Types.INTEGER);
            } else {
                statement.setInt(9, order.getCollectionId());
            }
            if (order.getDeliveryId() == 0) {
                statement.setNull(10, Types.INTEGER);
            } else {
                statement.setInt(10, order.getDeliveryId());
            }

            statement.execute();

            for (OrderLine orderLine : orderLines) {
                statement = connection.prepareStatement("insert into ORDERLINE values (?, ?, ?)");
                statement.setInt(1, orderLine.getQuantity());
                statement.setInt(2, orderId);
                statement.setInt(3, orderLine.getProductId());
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancelOrder(int orderId) {
        try {
            PreparedStatement statement = connection.prepareStatement("update \"ORDER\" set ORDER_STATUS='Cancelled' where ORDER_ID=?");
            statement.setInt(1, orderId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
            case "Processing":
                return Order.Status.Processing;
            default:
                return Order.Status.Cancelled;
        }
    }

    private Order.Method getMethodFromString(String methodString) {
        if (methodString.equals("Delivery")) {
            return Order.Method.Delivery;
        } else {
            return Order.Method.Collection;
        }
    }

    private int getNextOrderId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select max(ORDER_ID) as ID from \"ORDER\"");
        result.next();
        return result.getInt("ID") + 1;
    }
}
