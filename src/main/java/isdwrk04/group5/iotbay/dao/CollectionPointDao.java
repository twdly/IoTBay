package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.CollectionPoint;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionPointDao {

    private final Connection connection;

    public CollectionPointDao() {
        connection = new DbConnector().getConnection();
    }

    public boolean insertCollectionPoint(CollectionPoint cp) {
        String sql = "INSERT INTO CollectionPoint (id, name, address, cityId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cp.getId());
            statement.setString(2, cp.getName());
            statement.setString(3, cp.getAddress());
            statement.setInt(4, cp.getCityId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CollectionPoint getCollectionPointById(int id) {
        String sql = "SELECT * FROM CollectionPoint WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    int cityId = resultSet.getInt("cityId");
                    return new CollectionPoint(id, name, address, cityId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<CollectionPoint> listAllCollectionPoints() {
        List<CollectionPoint> listCollectionPoint = new ArrayList<>();
        String sql = "SELECT * FROM CollectionPoint";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int cityId = resultSet.getInt("cityId");
                listCollectionPoint.add(new CollectionPoint(id, name, address, cityId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCollectionPoint;
    }

    public boolean updateCollectionPoint(CollectionPoint cp) {
        String sql = "UPDATE CollectionPoint SET name = ?, address = ?, cityId = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cp.getName());
            statement.setString(2, cp.getAddress());
            statement.setInt(3, cp.getCityId());
            statement.setInt(4, cp.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCollectionPoint(int id) {
        String sql = "DELETE FROM CollectionPoint WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
