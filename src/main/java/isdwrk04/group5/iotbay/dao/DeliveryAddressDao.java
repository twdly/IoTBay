package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.DeliveryAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDao {

    private final Connection connection;

    public DeliveryAddressDao() {
        connection = new DbConnector().getConnection();
    }

    public boolean insertDeliveryAddress(DeliveryAddress da) {
        String sql = "INSERT INTO DeliveryAddress (id, address, cityId) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, da.getId());
            statement.setString(2, da.getAddress());
            statement.setInt(3, da.getCityId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DeliveryAddress getDeliveryAddressById(int id) {
        String sql = "SELECT * FROM DeliveryAddress WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String address = resultSet.getString("address");
                    int cityId = resultSet.getInt("cityId");
                    return new DeliveryAddress(id, address, cityId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<DeliveryAddress> listAllDeliveryAddresses() {
        List<DeliveryAddress> listDeliveryAddress = new ArrayList<>();
        String sql = "SELECT * FROM DeliveryAddress";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                int cityId = resultSet.getInt("cityId");
                listDeliveryAddress.add(new DeliveryAddress(id, address, cityId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listDeliveryAddress;
    }

    public boolean updateDeliveryAddress(DeliveryAddress da) {
        String sql = "UPDATE DeliveryAddress SET address = ?, cityId = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, da.getAddress());
            statement.setInt(2, da.getCityId());
            statement.setInt(3, da.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteDeliveryAddress(int id) {
        String sql = "DELETE FROM DeliveryAddress WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
