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

    public void addProduct(Product product){
        try {
            int id = getNextProductId();
            product.setId(id);
            PreparedStatement statement = connection.prepareStatement("insert into \"PRODUCT\" values (?, ?, ?, ?, ?, ?)");
            buildInsertQuery(product, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        List<Product> products = new ArrayList<>();
        try {

            String sanitisedSearch = search.replaceAll("[^a-zA-Z0-9 ]", "");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PRODUCT WHERE UPPER(Product_Name) LIKE ?");
            preparedStatement.setString(1, "%" + sanitisedSearch.toUpperCase() + "%");

            ResultSet results = preparedStatement.executeQuery();
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
            String query = "SELECT * FROM PRODUCT WHERE Product_Category = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category);

            ResultSet results = preparedStatement.executeQuery();
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

    public int getNextProductId(){
        int foundId;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select max(PRODUCT_ID) as ID from \"PRODUCT\"");
            result.next();
            foundId = result.getInt("ID") + 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foundId;
    }

    public void buildInsertQuery(Product product, PreparedStatement statement) throws SQLException {
        statement.setInt(1, getNextProductId());
        statement.setString(2, product.getName());
        statement.setString(3, product.getCategory());
        statement.setString(4, product.getDescription());
        statement.setDouble(5, Double.parseDouble(product.getPrice()));
        statement.setInt(6, product.getStock());
    }
    private Product createProductFromResult(ResultSet result) throws SQLException {
        int id = result.getInt("PRODUCT_ID");
        String name = result.getString("PRODUCT_NAME");
        String category = result.getString("PRODUCT_CATEGORY");
        String description = result.getString("PRODUCT_DESCRIPTION");
        double price = result.getDouble("PRODUCT_PRICE");
        int stock = result.getInt("PRODUCT_STOCK");
        return new Product(id, name, category, description, price, stock);
    }
}