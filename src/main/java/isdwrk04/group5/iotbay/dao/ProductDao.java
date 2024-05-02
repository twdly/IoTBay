package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private final Connection connection;

    public ProductDao() {
        connection = new DbConnector().getConnection();
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from PRODUCT");
            while (results.next()) {
                products.add(createProductFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product createProductFromResult(ResultSet result) throws SQLException {
        int id = result.getInt("PRODUCT_ID");
        String name = result.getString("PRODUCT_NAME");
        String description = result.getString("PRODUCT_DESCRIPTION");
        double price = result.getDouble("PRODUCT_PRICE");
        int stock = result.getInt("PRODUCT_STOCK");
        return new Product(id, name, description, price, stock);
    }

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        for (Product product : dao.getAllProducts()) {
            System.out.println(product.getName());
        }
    }
}
