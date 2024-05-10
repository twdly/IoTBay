package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.StringEscapeUtils;

public class ProductDao {

    private final Connection connection;

    public ProductDao() {
        connection = new DbConnector().getConnection();
    }

    public List<String> getProductCategories() {
        List<String> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT DISTINCT Product_Category FROM PRODUCT");
            while (results.next()) {
                categories.add(results.getString("Product_Category"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
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

    public List<Product> getSearchProducts(String search) {

        String escapedSearch = StringEscapeUtils.escapeJava(search).toUpperCase();

        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM PRODUCT WHERE UPPER(Product_Name) LIKE '%" + escapedSearch + "%'");
            while (results.next()) {
                products.add(createProductFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getCategoryProducts(String category) {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM PRODUCT WHERE Product_Category = '" + category + "'";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                products.add(createProductFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getProductsFromOrder(int orderId) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from PRODUCT, ORDERLINE\n where ORDERLINE.PRODUCT_ID=PRODUCT.PRODUCT_ID and ORDERLINE.ORDER_ID=?");
            statement.setInt(1, orderId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Product newProduct = createProductFromResult(result);
                newProduct.setQuantity(result.getInt("PRODUCT_QUANTITY"));
                products.add(newProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    private Product createProductFromResult(ResultSet result) throws SQLException {
        int id = result.getInt("PRODUCT_ID");
        String name = result.getString("PRODUCT_NAME");
        String description = result.getString("PRODUCT_DESCRIPTION");
        double price = result.getDouble("PRODUCT_PRICE");
        int stock = result.getInt("PRODUCT_STOCK");
        return new Product(id, name, description, price, stock);
    }
}